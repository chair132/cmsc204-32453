
/**
 * You must implement the following test case methods
 */
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicDoubleLinkedListTest_STUDENT {
	BasicDoubleLinkedList<String> list1, list2;
	@BeforeEach
	void setUp() throws Exception {
		list1 = new BasicDoubleLinkedList<>();
		list2 = new BasicDoubleLinkedList<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		list1 = null;
		list2 = null;
	}

	@Test
	void testGetSize() {
		list1.addToFront("abc");
		list1.addToEnd("def");
		assertEquals(list1.getSize(), 2);
		assertEquals(list2.getSize(), 0);
	}

	@Test
	void testAddToEnd() {
		list1.addToEnd("abc");
		assertTrue(list1.tail.data.equals("abc"));
		
		list2.addToEnd("def");
		list2.addToEnd("123");
		list2.addToEnd("456");
		assertTrue(list2.tail.data.equals("456"));
		
		
	}

	@Test
	void testAddToFront() {
		list1.addToFront("abc");
		assertTrue(list1.head.data.equals("abc"));
		
		list2.addToFront("def");
		list2.addToFront("123");
		list2.addToFront("456");
		assertTrue(list2.head.data.equals("456"));
	}

	@Test
	void testGetFirst() {
		list1.addToFront("abc");
		assertTrue(list1.getFirst().equals("abc"));

		
		list2.addToFront("def");
		list2.addToFront("123");
		list2.addToEnd("456");
		assertTrue(list2.getFirst().equals("123"));
	}

	@Test
	void testGetLast() {
		list1.addToEnd("abc");
		assertTrue(list1.getLast().equals("abc"));

		
		list2.addToEnd("def");
		list2.addToEnd("123");
		list2.addToFront("456");
		assertTrue(list2.getLast().equals("123"));
	}

	@Test
	void testIterator() {
		list1.addToFront("abc");
		
		list2.addToFront("def");
		list2.addToFront("123");
		list2.addToFront("456");
		
		ListIterator<String> iterator1 = list1.iterator();
		ListIterator<String> iterator2 = list2.iterator();
		
		
		
		
		assertTrue(iterator1.hasNext());
		assertFalse(iterator1.hasPrevious());
		assertTrue(iterator1.next().equals("abc"));
		assertFalse(iterator1.hasNext());
		assertTrue(iterator1.hasPrevious());
		assertTrue(iterator1.previous().equals("abc"));
		
		
		try {
			iterator2.previous();
			fail("An exception was expected to be thrown");
		} catch (NoSuchElementException e) {
			assertEquals(e.getMessage(),null);
		} catch(RuntimeException e) {
			fail("NoSuchElementException was expected to be thrown");
		}
		
		//reset
		iterator2 = list2.iterator();
		
		try {
			assertTrue(iterator2.next().equals("456"));
			assertTrue(iterator2.next().equals("123"));
			assertTrue(iterator2.next().equals("def"));
			iterator2.next();
			
			
			fail("An exception was expected to be thrown");
		} catch (NoSuchElementException e) {
			assertEquals(e.getMessage(),null);
		} catch(RuntimeException e) {
			fail("NoSuchElementException was expected to be thrown");
		}
		
		
		
	}

	@Test
	void testRemove() {
		list1.addToFront("abc");
		
		list2.addToFront("def");
		list2.addToFront("123");
		list2.addToFront("456");
		
		
		Comparator<String> comparator = (a, b) -> a.compareTo(b);

		
		assertEquals(list1.remove("abcd", comparator), null);
		assertTrue(list1.remove("abc", comparator).data.equals("abc"));
		assertEquals(list1.remove("abc", comparator), null);
		
		BasicDoubleLinkedList<String>.Node newNode = list2.remove("123", comparator);
		
		assertTrue(newNode.data.equals("123"));
		
		//ensuring that the swap of next and previous are correct
		assertTrue(newNode.previous.next.data.equals("def"));
		assertTrue(newNode.next.previous.data.equals("456"));
		
		
		
	}

	@Test
	void testRetrieveFirstElement() {
		list1.addToFront("abc");
		assertTrue(list1.retrieveFirstElement().equals("abc"));
		assertEquals(list1.retrieveFirstElement(), null);
		
		
		list2.addToFront("def");
		list2.addToFront("123");
		list2.addToFront("456");
		assertTrue(list2.retrieveFirstElement().equals("456"));
		assertTrue(list2.retrieveFirstElement().equals("123"));
		assertEquals(list2.getSize(),1);
	}

	@Test
	void testRetrieveLastElement() {
		list1.addToFront("abc");
		assertTrue(list1.retrieveLastElement().equals("abc"));
		assertEquals(list1.retrieveLastElement(), null);
		
		list2.addToFront("def");
		list2.addToFront("123");
		list2.addToFront("456");
		assertTrue(list2.retrieveLastElement().equals("def"));
		assertTrue(list2.retrieveLastElement().equals("123"));
		assertEquals(list2.getSize(),1);
	}

	@Test
	void testToArrayList() {
		list1.addToFront("abc");
		assertTrue(list1.toArrayList().toString().equals("[abc]"));
		
		list2.addToFront("def");
		list2.addToFront("123");
		list2.addToFront("456");
		assertTrue(list2.toArrayList().toString().equals("[456, 123, def]"));
		
		
	}

}
