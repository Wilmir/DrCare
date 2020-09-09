package com.ait.drcare.payment;

import java.util.ArrayList;
import java.util.List;

import com.ait.drcare.model.Prescription;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaymentServices {
	private static final String CLIENT_ID = "AdCRTVGLrxhrqEbRqXNJwWrrmTThctuhuOBRPM7BxkxQHXSgqfqXKyX5iF3lmN9wwr4Yvdzr-P2e1dJU";
	private static final String CLIENT_SECRET = "EJHHs-dmndcCEvzZx1Kf_fW73gXzQtH4TxUtcMSB9qz6-OkShl9SQ5BDiBifPCJ8xh4XS6ZLONDE90fg";
	private static final String MODE = "sandbox";
	
	public String authorisePayment(Prescription prescription) throws PayPalRESTException {
		presc = prescription;
		Payer payer = getPayerInformation();
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(prescription);
         
        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");
 
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
 
        Payment approvedPayment = requestPayment.create(apiContext);
 
        return getApprovalLink(approvedPayment);
	}
	
	private Payer getPayerInformation() {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
         
        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName("John")
                 .setLastName("Doe")
                 .setEmail("sb-eveby3155559@personal.example.com");
         
        payer.setPayerInfo(payerInfo);         
        return payer;
    }
	
    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/DrCare/cancel.jsf");
        redirectUrls.setReturnUrl("http://localhost:8080/DrCare/confirm.jsf");  
        return redirectUrls;
    }
    
    private List<Transaction> getTransactionInformation(Prescription prescription) {
    	Details details = new Details();
    	String subtotal = String.format("%.2f", prescription.getTheItem().getSubtotal());
    	details.setSubtotal(subtotal);
    	
    	Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setTotal(subtotal);
        amount.setDetails(details);
        
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(prescription.getTheName());
    	
        ItemList itemList = new ItemList();
        List<Item> items = new ArrayList<Item>();
         
        Item item = new Item();
        item.setCurrency("EUR");
        item.setName(prescription.getTheName());
        item.setPrice(subtotal);
        item.setQuantity("1");
         
        items.add(item);
        itemList.setItems(items);
        transaction.setItemList(itemList);
     
        List<Transaction> listTransaction = new ArrayList<Transaction>();
        listTransaction.add(transaction);  
         
        return listTransaction;    	
    }
    
    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;
         
        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }      
         
        return approvalLink;
    }
    
    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
        return Payment.get(apiContext, paymentId);
    }
    
    public Payment executePayment(String paymentId, String payerId)
            throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);
     
        Payment payment = new Payment().setId(paymentId);
     
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
     
        return payment.execute(apiContext, paymentExecution);
    }
}
