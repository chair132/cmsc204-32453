import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Test template provided to students
 * Students must implement the methods
 * 
 * @author Farnaz Eivazi
 * @version 1/31/2024
 *
 */
class CourseDBStructureTest_STUDENT {
	CourseDBStructure struct1, struct2;

	@BeforeEach
	void setUp() throws Exception {
		struct1 = new CourseDBStructure(30);
		struct2 = new CourseDBStructure("Testing", 10);
	}

	@AfterEach
	void tearDown() throws Exception {
		struct1 = null;
		struct2 = null;
	}

	@Test
	void testCourseDBStructureStringInt() {
		assertEquals(struct2.getTableSize(), 10);
	}

	@Test
	void testCourseDBStructureInt() {
		// 30 /1.5 = 20, next prime is 23
		assertEquals(struct1.getTableSize(), 23);
	}

	@Test
	void testAdd() {
		struct1.add(new CourseDBElement("CMSC204", 32409, 4, "SW409", "Farnaz Eivazi"));
		
		
		assertTrue(struct1.showAll().toString().contains("CMSC204"));
		assertTrue(struct1.showAll().toString().contains("32409"));
		
	}

	@Test
	void testShowAll() {
		struct1.add(new CourseDBElement("CMSC204", 32409, 4, "SW409", "Farnaz Eivazi"));
		struct1.add(new CourseDBElement("CHEM135", 17283, 3, "HS119", "Anthony Stewart"));
		
		assertTrue(struct1.showAll().toString().contains("CMSC204"));
		assertTrue(struct1.showAll().toString().contains("32409"));
		assertTrue(struct1.showAll().toString().contains("CMSC204"));
		assertTrue(struct1.showAll().toString().contains("17283"));
	}

	@Test
	void testGet() {
		struct1.add(new CourseDBElement("CMSC204", 32409, 4, "SW409", "Farnaz Eivazi"));
		try {
			CourseDBElement element1 = struct1.get(32409);
			assertTrue(element1.getID().equals("CMSC204"));
			assertEquals(element1.getCRN(), 32409);
			
			struct1.get(22222);
			fail("An exception was expected to be thrown");
		} catch (IOException e) {
			assertTrue(e.getMessage().equals("CRN 22222 was not found."));
		}
		
	}

	@Test
	void testGetTableSize() {
		assertEquals(struct2.getTableSize(), 10);
		assertEquals(struct1.getTableSize(), 23);
	}

	@Test
	void testGet4KPrime() {
		assertEquals(7, CourseDBStructure.get4KPrime(5));   
        assertEquals(19, CourseDBStructure.get4KPrime(13)); 
        assertEquals(23, CourseDBStructure.get4KPrime(19));
        assertEquals(67, CourseDBStructure.get4KPrime(64));
	}

}
