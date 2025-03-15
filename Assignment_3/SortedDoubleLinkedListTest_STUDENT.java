
/**
 * You must implement the following test case methods
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedDoubleLinkedListTest_STUDENT {
	
	Comparator<String> comparator = (a, b) -> a.compareTo(b);
	SortedDoubleLinkedList<String> list1;
	SortedDoubleLinkedList<String> list2;
	@BeforeEach
	void setUp() throws Exception {
		list1 = new SortedDoubleLinkedList<>(comparator);
		list2 = new SortedDoubleLinkedList<>(comparator);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		list1 = null;
		list2 = null;
	}

	@Test
	void testIterator() {
		list1.add("abc");
		
		list2.add("321");
		list2.add("123");
		list2.add("331");
		list2.add("456");
		
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
			assertTrue(iterator2.next().equals("123"));
			assertTrue(iterator2.next().equals("321"));
			assertTrue(iterator2.next().equals("331"));
			assertTrue(iterator2.next().equals("456"));
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
		list1.add("abc");
		
		list2.add("123");
		list2.add("789");
		list2.add("456");
		list2.add("321");
		
		
		
		
		assertEquals(list1.remove("abcd", comparator), null);
		assertTrue(list1.remove("abc", comparator).data.equals("abc"));
		assertEquals(list1.remove("abc", comparator), null);
		
		BasicDoubleLinkedList<String>.Node newNode = list2.remove("321", comparator);
		
		
		assertTrue(newNode.data.equals("321"));
		
		//ensuring that the swap of next and previous are correct
		assertTrue(newNode.previous.next.data.equals("456"));
		assertTrue(newNode.next.previous.data.equals("123"));
	}

	@Test
	void testAdd() {
		
		list1.add("abc");

		list2.add("123");
		list2.add("789");
		list2.add("456");
		list2.add("113");
		
		assertTrue(list1.toArrayList().toString().equals("[abc]"));
		assertTrue(list2.toArrayList().toString().equals("[113, 123, 456, 789]"));
		
	}

}
