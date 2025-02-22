
/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationTest_STUDENT {

	String exp1,exp2,exp3;
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		exp1 = null;
		exp2 = null;
		exp3 = null;
	}

	@Test
	void testEvaluatePostfixExpression() {
		exp1 = "342/+";
		exp2 = "3911+^-";
		exp3 = "11199+++++";
		
		assertEquals(Notation.evaluatePostfixExpression(exp1), 5.0   , 0.001);
		
		assertEquals(Notation.evaluatePostfixExpression(exp2), -78.0 , 0.001);
		
		try {
			Notation.evaluatePostfixExpression(exp3);
		} catch (InvalidNotationFormatException e) {
			assertTrue(e.getMessage().equals("Notation format is incorrect"));
		} catch (RuntimeException e) {
			fail("InvalidNotationFormatException was expected to be thrown");
		}

	}

	@Test
	void testConvertPostfixToInfix() {
		exp1 = "342/+";
		exp2 = "3911+^-";
		exp3 = "11199+++++";
		
		assertTrue(Notation.convertPostfixToInfix(exp1).equals("(3 + (4 / 2))"));
		
		assertTrue(Notation.convertPostfixToInfix(exp2).equals("(3 - (9 ^ (1 + 1)))"));
		
		try {
			Notation.convertPostfixToInfix(exp3);
		} catch (InvalidNotationFormatException e) {
			assertTrue(e.getMessage().equals("Notation format is incorrect"));
		} catch (RuntimeException e) {
			fail("InvalidNotationFormatException was expected to be thrown");
		}
	}

	@Test
	void testConvertInfixToPostfix() {
		exp1 = "7 + 9 / 2 ^ 1";
		exp2 = "9+(1+3)/4";
		exp3 = "12345-^2";
		assertTrue(Notation.convertInfixToPostfix(exp1).equals("7 9 2 1 ^ / + "));
		
		assertTrue(Notation.convertInfixToPostfix(exp2).equals("9 1 3 + 4 / + "));
		
		try {
			Notation.convertInfixToPostfix(exp3);
		} catch (InvalidNotationFormatException e) {
			assertTrue(e.getMessage().equals("Notation format is incorrect"));
		} catch (RuntimeException e) {
			fail("InvalidNotationFormatException was expected to be thrown");
		}
		
	}

}
