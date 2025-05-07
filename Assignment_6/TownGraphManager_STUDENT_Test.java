


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@BeforeEach
	public void setUp() throws Exception {
		graph = new TownGraphManager();
		town = new String[6];

		for (int i = 1; i < 6; i++) {
			town[i] = "Town_" + i;
			graph.addTown(town[i]);
		}

		graph.addRoad(town[1], town[2], 2, "Road_1");
		graph.addRoad(town[5], town[4], 5, "Road_2");
		graph.addRoad(town[1], town[4], 6, "Road_3");

		graph.addRoad(town[2], town[3], 1, "Road_4");
		graph.addRoad(town[4], town[2], 2, "Road_5");

		graph.addRoad(town[4], town[3], 3, "Road_6");
			  
		 
	}

	@AfterEach
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		assertEquals("Road_4", roads.get(3));
		graph.addRoad(town[1], town[2], 1,"Road_7");
		roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		assertEquals("Road_4", roads.get(3));
		assertEquals("Road_7", roads.get(6));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_1", graph.getRoad(town[1], town[2]));
		assertEquals("Road_4", graph.getRoad(town[2], town[3]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_9"));
		graph.addTown("Town_9");
		assertEquals(true, graph.containsTown("Town_9"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, graph.containsTown("Town_9"));
		graph.addTown("Town_9");
		ArrayList<String> path = graph.getPath(town[1],"Town_9");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		assertEquals(false, graph.containsTown("Town_9"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[3]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[5]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1", roads.get(0));
		assertEquals("Road_2", roads.get(1));
		assertEquals("Road_3", roads.get(2));
		assertEquals("Road_4", roads.get(3));
		assertEquals("Road_5", roads.get(4));
		assertEquals("Road_6", roads.get(5));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[4], town[2]));
		graph.deleteRoadConnection(town[4], town[2], "Road_5");
		assertEquals(false, graph.containsRoadConnection(town[4], town[2]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_3"));
		graph.deleteTown(town[3]);
		assertEquals(false, graph.containsTown("Town_3"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> towns = graph.allTowns();
		assertEquals("Town_1", towns.get(0));
		assertEquals("Town_2", towns.get(1));
		assertEquals("Town_3", towns.get(2));
		assertEquals("Town_4", towns.get(3));
		assertEquals("Town_5", towns.get(4));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1],town[5]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_1 to Town_2 2 mi",path.get(0).trim());
		  assertEquals("Town_2 via Road_5 to Town_4 2 mi",path.get(1).trim());
		  assertEquals("Town_4 via Road_2 to Town_5 5 mi",path.get(2).trim());

	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = graph.getPath(town[3],town[4]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_3 via Road_6 to Town_4 3 mi",path.get(0).trim());
	}
	
	@Test
	public void testGetPathB() {
		ArrayList<String> path = graph.getPath(town[3],town[1]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_3 via Road_4 to Town_2 1 mi",path.get(0).trim());
		  assertEquals("Town_2 via Road_1 to Town_1 2 mi",path.get(1).trim());

	}

}
