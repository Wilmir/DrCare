import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.model.Prescription;

class PrescriptionTest {

	private Prescription prescription1;
	private Prescription prescription2 = new Prescription();
	
	@BeforeEach
	void setUp() throws Exception {
	prescription1 = new Prescription("John",Date.valueOf("06/01/2020"));
	
	}

	@Test
	void testConstructors() {
		
		assertEquals("", prescription2.getTheNote());
		assertEquals("Waiting for payment",prescription2.getTheStatus());
		assertEquals("Waiting for payment",prescription2.getTheStatus());
		assertEquals(3,prescription2.getStatusValues().size());
		assertEquals("Waiting for payment",prescription2.getTheStatus());
		assertFalse(prescription2.isCanEditNote());
		
	}
	
	@Test
	void testGettersSetters() {
		prescription1.setCanEditNote(true);
		assertTrue(prescription1.isCanEditNote());
		
		prescription1.setTheStatus("Order Dispenced");
		assertEquals("Order Dispenced",prescription1.getTheStatus());
		prescription1.setTheDatePrescribed(Date.valueOf("01/02/0000"));
		assertEquals(prescription1.getTheStatus());
		prescription1.setTheName("bobo");
		assertEquals("bobo",prescription1.getTheName());
		
		
		
	}

}