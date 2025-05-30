
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the Good Faith Attempt test file for the MorseCodeConverter, students
 * should not modify this code.
 * 
 * @author Farnaz Eivazi
 * @version 4/4/2024
 *
 */
public class MorseCodeConverter_GFA_Test {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testConvertToEnglishString() {
	String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.. ");
	assertEquals("hello world", converter1);
    }

}