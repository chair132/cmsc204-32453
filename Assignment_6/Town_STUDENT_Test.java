


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Town_STUDENT_Test {
	Town town1, town2;
	@BeforeEach
	public void setUp() throws Exception{
		town1 = new Town("Clarksburg");
		town2 = new Town("Germantown");
	}
	
	@AfterEach
	public void tearDown() throws Exception{
		town1 = town2 = null;
	}
	
	@Test
	public void testSetName() {
		town1.setName("Potomac");
		town2.setName("Middletown");
		assertTrue(town1.getName().equals("Potomac"));
		assertTrue(town2.getName().equals("Middletown"));
		
	}
	
	
	@Test
	public void testGetName() {
		assertTrue(town1.getName().equals("Clarksburg"));
		assertTrue(town2.getName().equals("Germantown"));
		
	}
	
	
	
	@Test
	public void testCompareTo() {
		assertTrue(town1.compareTo(town2) < 0);
		town2 = town1;
		assertTrue(town1.compareTo(town2) == 0);
	}
	
	@Test
	public void testToString() {
		assertTrue(town1.toString().equals("Clarksburg"));
		assertTrue(town2.toString().equals("Germantown"));
	}
	
	@Test
	public void testHashCode() {
		
		
		assertEquals(town1.hashCode(),   604585514);
		assertEquals(town2.hashCode(), -1284114120);
	}
	
	@Test
	public void testEquals() {
		assertFalse(town1.equals(town2));
		town2.setName("Clarksburg");
		assertTrue(town1.equals(town2));
		
	}
	
}
