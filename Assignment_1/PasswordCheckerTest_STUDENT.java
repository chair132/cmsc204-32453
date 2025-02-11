
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * STUDENT tests for the methods of PasswordCheckerUtility
 * @author John Vu
 *
 */
public class PasswordCheckerTest_STUDENT {
	
	@BeforeEach
	public void setUp() throws Exception {
	
	}

	@AfterEach
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the two arguments are equivalent 
	 */
	
	@Test
	public void testComparePasswords() {
		String a = "aaa";
		String b = "aab";
		
		try {
			PasswordCheckerUtility.comparePasswords(a, b);
		} catch (UnmatchedException e) {
			assertTrue("Passwords do not match".equals(e.getMessage()));
		} catch (RuntimeException e) {
			fail("Threw some other exception besides UnmatchedException");
		}
	}
	/**
	 * Test if the two arguments are equivalent 
	 */
	
	@Test
	public void testComparePasswordsWithReturn() {
		String a = "cccc";
		String b = "cccc";
		String c = "ccbc";
		
		assertTrue(PasswordCheckerUtility.comparePasswordsWithReturn(a, b));
		assertFalse(PasswordCheckerUtility.comparePasswordsWithReturn(a, c));
	}
	
	/**
	 * Test if the password has between six and nine characters
	 */
	@Test
	public void testHasBetweenSixAndNineChars() {
		String a = "aaabbb";
		String b = "ccc";
		String c = "mmmmmmmmmm";
		
		assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars(a));
		assertFalse(PasswordCheckerUtility.hasBetweenSixAndNineChars(b));
		assertFalse(PasswordCheckerUtility.hasBetweenSixAndNineChars(c));
	}
	
	
	
	/**
	 * Test if the password is less than 6 characters long.
	 * 
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		assertTrue(PasswordCheckerUtility.isValidLength("Hello!1234"));
		
		String a = "He@123";
		try {
			PasswordCheckerUtility.isValidPassword(a);
			
		} catch(LengthException e) {
			assertTrue("The password must be at least 6 characters long".equals(e.getMessage()));
		} catch(RuntimeException e) {
			assertTrue("Threw some other exception besides lengthException", false );
		}
		
		
		
		String b = "Hello";
		try {
			PasswordCheckerUtility.isValidPassword(b);
			fail("Expected lengthException to be thrown");
		} catch(LengthException e) {
			assertTrue("The password must be at least 6 characters long".equals(e.getMessage()));
		} catch(RuntimeException e) {
			assertTrue("Threw some other exception besides lengthException", false );
		}

		
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		assertTrue(PasswordCheckerUtility.hasUpperAlpha("Hello!1234"));
		
		String b = "hello@123";
		try {
			PasswordCheckerUtility.isValidPassword(b);
			fail("Expected NoUpperAlphaException to be thrown");
		} catch(NoUpperAlphaException e) {
			assertTrue("The password must contain at least one uppercase alphabetic character".equals(e.getMessage()));
		} catch(RuntimeException e) {
			assertTrue("Threw some other exception besides NoUpperAlphaException", false );
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		assertTrue(PasswordCheckerUtility.hasLowerAlpha("Hello!1234"));
		
		
		String b = "HELLO@123";
		try {
			PasswordCheckerUtility.isValidPassword(b);
			fail("Expected NoLowerAlphaException to be thrown");
		} catch(NoLowerAlphaException e) {
			assertTrue("The password must contain at least one lowercase alphabetic character".equals(e.getMessage()));
		} catch(RuntimeException e) {
			assertTrue("Threw some other exception besides NoLowerAlphaException", false );
		}
	}
	/**
	 * Test if the password is valid but is considered weak (between 6 and 9 characters)
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		assertFalse(PasswordCheckerUtility.isWeakPassword("Hello!1234"));
		
		
		
		String b = "Hi@123";
		try {
			PasswordCheckerUtility.isWeakPassword(b);
			fail("Expected WeakPasswordException to be thrown");
		} catch(WeakPasswordException e) {
			assertTrue("The password is OK but weak - it contains fewer than 10 characters".equals(e.getMessage()));
		} catch(RuntimeException e) {
			assertTrue("Threw some other exception besides WeakPasswordException", false );
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		assertFalse(PasswordCheckerUtility.noSameCharInSequence("Hello!123"));
		
		String b = "Helllo@123";
		try {
			PasswordCheckerUtility.isValidPassword(b);
			fail("Expected InvalidSequenceException to be thrown");
		} catch(InvalidSequenceException e) {
			assertTrue("The password cannot contain more than two of the same characters in sequence".equals(e.getMessage()));
		} catch(RuntimeException e) {
			assertTrue("Threw some other exception besides InvalidSequenceException", false );
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		
		assertTrue(PasswordCheckerUtility.hasDigit("Hello!1"));
		String b = "Hello@abc";
		try {
			PasswordCheckerUtility.isValidPassword(b);
			fail("Expected NoDigitException to be thrown");
		} catch(NoDigitException e) {
			assertTrue("The password must contain at least one digit".equals(e.getMessage()));
		} catch(RuntimeException e) {
			assertTrue("Threw some other exception besides NoDigitException", false );
		}
	}
	
	/**
	 * Test if the password has at least one special character
	 * One test should throw a NoSpecialCharacterException
	 */
	
	@Test
	public void testIsValidPasswordNoSpecialChar() {
		
		assertTrue(PasswordCheckerUtility.hasSpecialChar("Hello!"));
		
		String b = "Hello123";
		try {
			PasswordCheckerUtility.isValidPassword(b);
		} catch(NoSpecialCharacterException e) {
			assertTrue("The password must contain at least one special character".equals(e.getMessage()));
		} catch(RuntimeException e) {
			fail("Threw some other exception besides NoSpecialCharacterException");
		}
		
		
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		String a = "Hello@123";
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(a));
		} catch(RuntimeException e) {
			fail("Not intended to throw an exception");
		}
		
		String b = "Anthony!321";
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(b));
		} catch(RuntimeException e) {
			fail("Not intended to throw an exception");
		}
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		String[] p = {"Safeway", "!anthony12", "4Sal#", "john14", "a2cDe!", 
				"abcAbc1#", "aa11Bbbb!"};
		ArrayList<String> passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
		
		ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertTrue(invalidPasswords.get(0).contains("Safeway"));
		assertTrue(invalidPasswords.get(1).contains("!anthony12"));
		assertTrue(invalidPasswords.get(2).contains("4Sal#"));
		assertTrue(invalidPasswords.get(3).contains("john14"));
		assertTrue(invalidPasswords.get(4).contains("aa11Bbbb!"));
		
		
	}
	
}
