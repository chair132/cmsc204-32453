import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Test template provided to students
 * Students must implement the methods
 * 
 * @author Farnaz Eivazi
 * @version 1/31/2024
 *
 */
class CourseDBManagerTest_STUDENT {
	CourseDBManager manager;
	@BeforeEach
	void setUp() throws Exception {
		manager = new CourseDBManager();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		manager = null;
	}

	@Test
	void testAdd() {
		manager.add("CMSC204", 32409, 4, "SW409", "Farnaz Eivazi");
		assertTrue(manager.showAll().toString().contains("CMSC204"));
		assertTrue(manager.showAll().toString().contains("SW409"));
	}

	@Test
	void testShowAll() {
		manager.add("CMSC204", 32409, 4, "SW409", "Farnaz Eivazi");
		manager.add("CHEM135", 17283, 3, "HS119", "Anthony Stewart");
		System.out.println(manager.showAll());
		assertTrue(manager.showAll().toString().contains("Course:CMSC204 CRN:32409"));
		assertTrue(manager.showAll().toString().contains("Course:CHEM135 CRN:17283"));
	}

	@Test
	void testReadFile() {
		File tempFile;
        try  {
        	tempFile = File.createTempFile("testCourses", ".txt");
        	FileWriter writer = new FileWriter(tempFile);
            writer.write("CMSC204 32409 4 SW409 Farnaz Eivazi\n");
            writer.write("CHEM135 17283 3 HS119 Anthony Stewart\n");
            writer.close();
            
            manager.readFile(tempFile);
            CourseDBElement element1 = manager.get(32409);
            CourseDBElement element2 = manager.get(17283);
            
            assertTrue(element1.getID().equals("CMSC204"));
            assertEquals(element1.getCRN(), 32409);
            
            assertTrue(element2.getID().equals("CHEM135"));
            assertEquals(element2.getCRN(), 17283);
            
            
        } catch (IOException e) {
        }
        
        
       
        
	}

	@Test
	void testGet() {
		manager.add("CMSC204", 32409, 4, "SW409", "Farnaz Eivazi");
		CourseDBElement element1 = manager.get(32409);
		assertTrue(element1.getID().equals("CMSC204"));
		assertEquals(element1.getCRN(), 32409);
		
		assertEquals(manager.get(22222), null);
		
		
	}

}
