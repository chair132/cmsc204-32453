
/**
 * GAF Test class for SortedDoubleLinkedList
 * 
 * @author Farnaz Eivazi
 * @version 1/29/2024
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortedDoubleLinkedList_GFA_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	StringComparator comparator = new StringComparator();

	@BeforeEach
	public void setUp() throws Exception {
		sortedLinkedString = new SortedDoubleLinkedList<>(comparator);
	}

	@AfterEach
	public void tearDown() throws Exception {
		sortedLinkedString = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("Hello");
		} catch (UnsupportedOperationException e) {
			assertEquals(e.getMessage(), "Invalid operation for sorted list");
		}
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
	}

}
