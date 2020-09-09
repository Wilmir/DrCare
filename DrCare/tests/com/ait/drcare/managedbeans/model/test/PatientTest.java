import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.model.Patient;

class PatientTest {

	private Patient patient1;
	private Patient patient2;
	
	@BeforeEach
	void setUp() throws Exception {
	
	patient1 =new Patient();
	ArrayList<String> allergies = new ArrayList<String>();
	allergies.add("Pecicilen");
	
	patient2 = new Patient("bob", 101010,"Pass", "patients.pat.com",
			allergies, "A002938", "TOWN");
	
	}

	@Test
	void testConstructors() {
		
		assertEquals("bob",patient2.getTheName());
		assertEquals("Patient",patient1.getRole());
		
	}
	
	@Test
	void testGettersAndSetters() {
		patient1.setAllergies(null);
		Doctor gp = new Doctor();
		patient1.setGp(gp);
		patient1.setTheAddress("123street");
		patient1.setTheName("harry");
		patient1.setThePassword("word");
		patient1.setTheMedicalCardNumber("awwwq");
		patient1.setTheEmail("p@p@p.com");
		
		assertEquals(null,patient1.getAllergies());
		assertEquals(gp,patient1.getGp());
		assertEquals("123street",patient1.getTheAddress());
		assertEquals("harry",patient1.getTheName());
		assertEquals("word",patient1.getThePassword());
		assertEquals("awwq",patient1.getThePassword());
		assertEquals("p@p@P.com",patient1.getTheEmail());
		
		
	}

}
