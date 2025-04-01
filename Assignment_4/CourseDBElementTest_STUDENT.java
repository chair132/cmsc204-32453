import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseDBElementTest_STUDENT {
	CourseDBElement element1, element2;
	@BeforeEach
	void setUp() throws Exception {
		element1 = new CourseDBElement("CMSC204", 32409, 4, "SW409", "Farnaz Eivazi");
		element2 = new CourseDBElement("CHEM135", 17283, 3, "HS119", "Anthony Stewart");
	}

	@AfterEach
	void tearDown() throws Exception {
		element1 = null;
		element2 = null;
	}

	@Test
	void testHashCode() {
		
		assertEquals(element1.hashCode(), 48640638);
		assertEquals(element2.hashCode(), 46940871);
	}

	@Test
	void testGetId() {
		assertTrue(element1.getID().equals("CMSC204"));
		assertTrue(element2.getID().equals("CHEM135"));
		
		element1.setID("MATH140");
		
		assertTrue(element1.getID().equals("MATH140"));
	}

	@Test
	void testGetCrn() {
		assertEquals(element1.getCRN(), 32409);
		assertEquals(element2.getCRN(), 17283);
		
		element1.setCRN(12342);
		
		assertEquals(element1.getCRN(), 12342);
		
	}

	@Test
	void testGetCredits() {
		assertEquals(element1.getCredits(), 4);
		assertEquals(element2.getCredits(), 3);
		
		element1.setCredits(1);
		assertEquals(element1.getCredits(), 1);
	}

	@Test
	void testGetInstructor() {
		assertTrue(element1.getInstructor().equals("Farnaz Eivazi"));
		assertTrue(element2.getInstructor().equals("Anthony Stewart"));
		
		element1.setInstructor("John Vu");
		
		assertTrue(element1.getInstructor().equals("John Vu"));
	}
	
	@Test
	void testGetRoomNum() {
		assertTrue(element1.getRoomNum().equals("SW409"));
		assertTrue(element2.getRoomNum().equals("HS119"));
		
		element1.setRoomNum("SA312");
		
		assertTrue(element1.getRoomNum().equals("SA312"));
	}

	@Test
	void testEqualsObject() {
		assertFalse(element1.equals(element2));
		
		CourseDBElement element3 = new CourseDBElement(element2);
		
		assertTrue(element2.equals(element3));
	}

}
