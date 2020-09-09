import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.model.Pharmacist;

class Pharmacisttest {

	private Pharmacist pharmacist;
	private Pharmacist2 pharmacist2 = new Pharmacist();
	
	
	@BeforeEach
	void setUp() throws Exception {
	
	
	}

	@Test
	void testConstructor() {
		pharmacist = new Pharmacist( "Pharm",  1111,  "paww",
				 "pharm@pharm.com", "Addwas");
		
		assertEquals("Pharm",pharmacist.getTheName());
		assertEquals(1111,pharmacist.getTheID());
		assertEquals("paww",pharmacist.getThePassword());
		assertEquals("pharm@pharm.com",pharmacist.getTheEmail());
		assertEquals("Addwas",pharmacist.getTheAddress());
		
	}
	
	

}
