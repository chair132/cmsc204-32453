


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Road_STUDENT_Test {
	Road road1, road2;
	@BeforeEach
	public void setUp() throws Exception{
		road1 = new Road(new Town("1"),new Town("2"), 10, "First Road");
		road2 = new Road(new Town("2"),new Town("3"), "Second Road");
	}
	
	@AfterEach
	public void tearDown() throws Exception{
		road1 = road2 = null;
	}
	
	@Test
	public void testContains() {
		assertTrue(road1.contains(new Town("1")));
		assertTrue(road2.contains(new Town("2")));
		assertFalse(road1.contains(new Town("3")));
	}
	
	@Test
	public void testToString() {
		assertTrue(road1.toString().equals("First Road"));
		assertTrue(road2.toString().equals("Second Road"));
	}
	
	@Test
	public void testSetName() {
		road1.setName("3");
		road2.setName("4");
		assertTrue(road1.getName().equals("3"));
		assertTrue(road2.getName().equals("4"));
	}
	
	@Test
	public void testGetName() {
		assertTrue(road1.toString().equals("First Road"));
		assertTrue(road2.toString().equals("Second Road"));
	}
	
	@Test
	public void testSetDestination(){
		road1.setDestination(new Town("4"));
		road2.setDestination(new Town("5"));
		assertTrue(road1.getDestination().equals(new Town("4")));
		assertTrue(road2.getDestination().equals(new Town("5")));
	}
	
	@Test
	public void testGetDestination() {
		assertTrue(road1.getDestination().equals(new Town("2")));
		assertTrue(road2.getDestination().equals(new Town("3")));
	}
	
	@Test
	public void testSetSource() {
		road1.setSource(new Town("4"));
		road2.setSource(new Town("5"));
		assertTrue(road1.getSource().equals(new Town("4")));
		assertTrue(road2.getSource().equals(new Town("5")));
	}
	
	@Test
	public void testgetSource() {
		assertTrue(road1.getSource().equals(new Town("1")));
		assertTrue(road2.getSource().equals(new Town("2")));
	}
	
	@Test
	public void testCompareTo() {
		assertTrue(road1.compareTo(road2) < 0);
		road2 = road1;
		assertTrue(road1.compareTo(road2) == 0);
	}
	
	@Test
	public void testSetWeight() {
		road1.setWeight(4);
		road2.setWeight(5);
		assertTrue(road1.getWeight() == 4);
		assertTrue(road2.getWeight() == 5);
	}
	
	@Test
	public void testGetWeight() {
		assertTrue(road1.getWeight() == 10);
		assertTrue(road2.getWeight() == 1);
	}
	
	@Test
	public void testEquals() {
		assertFalse(road1.equals(new Integer(2)));
		assertTrue(road1.equals(new Road(new Town("1"), new Town("2"), 1, "hi")));
		assertTrue(road1.equals(new Road(new Town("2"), new Town("1"), 1, "hi")));
		assertFalse(road1.equals(road2));
	}
}
