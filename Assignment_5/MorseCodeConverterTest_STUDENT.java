import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeConverterTest_STUDENT {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testConvertToEnglish() {
    	
    	assertTrue(MorseCodeConverter.convertToEnglish(".--- --- .... -. / ...- ..-").equals("john vu "));
    	
    }

    @Test
    public void testHowDoILoveTheeFile() {
    	try {
    		File fileToTest = new File("src/howDoILoveThee.txt");
    		
    		assertTrue((MorseCodeConverter.convertToEnglish(fileToTest)).equals("how do i love thee let me count the ways "));
    	} catch (FileNotFoundException e) {
    		fail("File was not found");
    	}
    }

    @Test
    public void testDaisyFile() {
    	try {
    		File fileToTest = new File("src/Daisy.txt");
    		
    		assertTrue((MorseCodeConverter.convertToEnglish(fileToTest)).equals("give me your answer do "));
    	} catch (FileNotFoundException e) {
    		fail("File was not found");
    	}
    }

    @Test
    public void testDaisyDaisyFile() {
    	try {
    		File fileToTest = new File("src/DaisyDaisy.txt");
    		
    		assertTrue((MorseCodeConverter.convertToEnglish(fileToTest)).equals("im half crazy all for the love of you "));
    	} catch (FileNotFoundException e) {
    		fail("File was not found");
    	}
    }

    @Test
    public void testLoveLooksNotFile() {
    	try {
    		File fileToTest = new File("src/LoveLooksNot.txt");
    		
    		assertTrue((MorseCodeConverter.convertToEnglish(fileToTest)).equals("love looks not with the eyes but with the mind "));
    	} catch (FileNotFoundException e) {
    		fail("File was not found");
    	}
    }

    @Test
    public void testStudentFiles() {
    	try {
    		File fileToTest = new File("src/student.txt");
    		
    		assertTrue((MorseCodeConverter.convertToEnglish(fileToTest)).equals("anthony vu and i are so cool "));
    	} catch (FileNotFoundException e) {
    		fail("File was not found");
    	}
    }

}
