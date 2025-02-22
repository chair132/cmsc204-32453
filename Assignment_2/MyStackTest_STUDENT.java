
/**
 * This class contains the test case methods that students must implement
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyStackTest_STUDENT {

	MyStack<String> stack1, stack2;
	@BeforeEach
	void setUp() throws Exception {
		stack1 = new MyStack<>();
		stack2 = new MyStack<>(4);
	}

	@AfterEach
	void tearDown() throws Exception {
		stack1 = null;
		stack2 = null;
	}

	@Test
	void testIsEmpty() {
		assertTrue(stack1.isEmpty());
		assertTrue(stack2.isEmpty());
		
		stack1.push("Hi");
		assertFalse(stack1.isEmpty());
		stack1.pop();
		assertTrue(stack1.isEmpty());
		
	}

	@Test
	void testIsFull() {
		assertFalse(stack1.isFull());
		assertFalse(stack2.isFull());
		
		stack2.push("1");
		stack2.push("2");
		stack2.push("3");
		stack2.push("4");
		
		assertTrue(stack2.isFull());
	}

	@Test
	void testPop() {
		
		
		try {
			stack1.pop();
			fail("An exception was expected to be thrown");
		} catch (StackUnderflowException e) {
			assertTrue(e.getMessage().equals("Stack is empty"));
		} catch (RuntimeException e) {
			fail("StackUnderflowException was expected to be thrown");
		}
		
		
		
		
		
		
		try {
			
			stack2.push("12");
			
			assertTrue(stack2.pop().equals("12"));
			 
		} catch (StackUnderflowException e) {
			assertTrue(e.getMessage().equals("Stack is empty"));
			
		} catch(RuntimeException e) {
			
			fail("StackUnderflowException was expected to be thrown");
		}
	}

	@Test
	void testTop() {
		
		try {
			stack1.top();
			fail("An exception was expected to be thrown");
		} catch (StackUnderflowException e) {
			assertTrue(e.getMessage().equals("Stack is empty"));
		} catch (RuntimeException e) {
			fail("StackUnderflowException was expected to be thrown");
		}
		
		stack2.push("1");
		stack2.push("2");
		assertTrue(stack2.top().equals("2"));
		assertFalse(stack2.top().equals("1"));
	}

	@Test
	void testSize() {
		stack1.push("1");
		stack1.push("2");
		assertEquals(stack1.size(), 2);
		
		stack1.push("3");
		stack1.push("4");
		assertEquals(stack1.size(), 4);
		
		assertEquals(stack2.size(),0);
		
		
	}

	@Test
	void testPush() {
		assertTrue(stack1.push("A"));
		assertTrue(stack1.push("B"));
		assertTrue(stack1.push("C"));
		assertFalse(stack1.push(null));
		
		try {
			assertTrue(stack2.push("1"));
			assertTrue(stack2.push("2"));
			assertTrue(stack2.push("3"));
			assertTrue(stack2.push("4"));
			
			//error
			assertFalse(stack2.push("5"));
		} catch (StackOverflowException e) {
			assertTrue(e.getMessage().equals("Stack is full"));
		} catch (RuntimeException e) {
			fail("StackOverflowException was expected to be thrown");
		}
	}

	@Test
	void testToString() {
		//bottom of stack
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		stack1.push("D");
		stack1.push("A");
		//top of stack
		
	
		assertTrue(stack1.toString().equals("A B C D A "));
		
		assertTrue(stack2.toString().equals(""));
	}

	@Test
	void testToStringString() {
		//bottom of stack
		stack1.push("1");
		stack1.push("2");
		stack1.push("3");
		stack1.push("4");
		stack1.push("5");
		//top of stack
		
		
		assertTrue(stack1.toString("!!").equals("1!!2!!3!!4!!5!!"));
		
		assertTrue(stack2.toString("    ").equals(""));
	}

	@Test
	void testFill() {
		ArrayList<String> a = new ArrayList<>();
		a.add("124");
		a.add("hello");
		a.add("hi");
		a.add("732");
		a.add("ty");
		
		stack1.fill(a);
		assertTrue(stack1.toString().equals("124 hello hi 732 ty "));
		stack1.pop();
		assertTrue(stack1.toString().equals("124 hello hi 732 "));
		
		
		try {
			stack2.fill(a);
			fail("An exception was expected to be thrown");
		} catch (StackOverflowException e) {
			assertTrue(e.getMessage().equals("Stack is full"));
		} catch (RuntimeException e) {
			fail("StackOverflowException was expected to be thrown");
		}
		
		
	}

}
