
/**
 * This class contains the test case methods that students must implement
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest_STUDENT {

	MyQueue<String> queue1, queue2;
	
	@BeforeEach
	void setUp() throws Exception {
		queue1 = new MyQueue<>();
		queue2 = new MyQueue<>(4);
	}

	@AfterEach
	void tearDown() throws Exception {
		queue1 = null;
		queue2 = null;
	}

	@Test
	void testIsEmpty() {
		assertTrue(queue1.isEmpty());
		assertTrue(queue2.isEmpty());
		
		queue1.enqueue("Hi");
		assertFalse(queue1.isEmpty());
		queue1.dequeue();
		assertTrue(queue1.isEmpty());
	}

	@Test
	void testDequeue() {
		try {
			queue1.dequeue();
			fail("An exception was expected to be thrown");
		} catch (QueueUnderflowException e) {
			assertTrue(e.getMessage().equals("Queue is empty"));
		} catch (RuntimeException e) {
			fail("QueueUnderflowException was expected to be thrown");
		}
		
		
		queue2.enqueue("Hi");
		queue2.enqueue("Hello");
		
		try {
			assertTrue(queue2.dequeue().equals("Hi"));
		} catch (QueueUnderflowException e) {
			assertTrue(e.getMessage().equals("Queue is empty"));
		} catch (RuntimeException e) {
			fail("QueueUnderflowException was expected to be thrown");
		}
	}

	@Test
	void testSize() {
		assertEquals(queue1.size(),0);
		queue1.enqueue("111");
		assertEquals(queue1.size(), 1);
		
		assertEquals(queue2.size(),0);
		
	}

	@Test
	void testEnqueue() {
		assertTrue(queue1.enqueue("A"));
		assertTrue(queue1.enqueue("B"));
		assertTrue(queue1.enqueue("C"));
		assertFalse(queue1.enqueue(null));
		
		try {
			assertTrue(queue2.enqueue("1"));
			assertTrue(queue2.enqueue("2"));
			assertTrue(queue2.enqueue("3"));
			assertTrue(queue2.enqueue("4"));
			
			//error
			assertFalse(queue2.enqueue("5"));
		} catch (QueueOverflowException e) {
			assertTrue(e.getMessage().equals("Queue is full"));
		} catch (RuntimeException e) {
			fail("QueueOverflowException was expected to be thrown");
		}
	}

	@Test
	void testIsFull() {
		assertFalse(queue1.isFull());
		assertFalse(queue2.isFull());
		
		queue2.enqueue("1");
		queue2.enqueue("2");
		queue2.enqueue("3");
		queue2.enqueue("4");
		assertTrue(queue2.isFull());
	}

	@Test
	void testToString() {
		//first in queue
		queue1.enqueue("A");
		queue1.enqueue("B");
		queue1.enqueue("C");
		queue1.enqueue("D");
		queue1.enqueue("A");
		//last in queue
		
	
		assertTrue(queue1.toString().equals("A B C D A "));
		
		assertTrue(queue2.toString().equals(""));
	}

	@Test
	void testToStringString() {
		//first in queue
		queue1.enqueue("1");
		queue1.enqueue("2");
		queue1.enqueue("3");
		queue1.enqueue("4");
		queue1.enqueue("5");
		//last in queue
		
		
		assertTrue(queue1.toString("!!").equals("1!!2!!3!!4!!5!!"));
		
		assertTrue(queue2.toString("    ").equals(""));
	}

	@Test
	void testFill() {
		ArrayList<String> a = new ArrayList<>();
		a.add("124");
		a.add("hello");
		a.add("hi");
		a.add("732");
		a.add("ty");
		
		queue1.fill(a);
		assertTrue(queue1.toString().equals("124 hello hi 732 ty "));
		queue1.dequeue();
		assertTrue(queue1.toString().equals("hello hi 732 ty "));
		
		
		try {
			queue2.fill(a);
			fail("An exception was expected to be thrown");
		} catch (QueueOverflowException e) {
			assertTrue(e.getMessage().equals("Queue is full"));
		} catch (RuntimeException e) {
			fail("QueueOverflowException was expected to be thrown");
		}
	}

}
