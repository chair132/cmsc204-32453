
/**
 * GAF Test class for BasicDoubleLinkedList
 * 
 * @author Farnaz Eivazi
 * @version 1/29/2024
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicDoubleLinkedList_GFA_Test {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;


	@BeforeEach
	public void setUp() throws Exception {
		linkedString = new BasicDoubleLinkedList<>();
		linkedString.addToEnd("Hello");
	}

	@AfterEach
	public void tearDown() throws Exception {
		linkedString = null;
	}

	@Test
	public void testGetSize() {
		assertEquals(1,linkedString.getSize());
	}	
}
