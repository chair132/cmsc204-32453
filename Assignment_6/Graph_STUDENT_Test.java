



import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Graph_STUDENT_Test {
	private GraphInterface<Town,Road> graph;
	private Town[] town;
	
	@BeforeEach
	public void setUp() throws Exception{
		graph = new Graph();
		town = new Town[6];
		for(int i = 1; i < 6; i++) {
			town[i] = new Town("Town_"+i);
			graph.addVertex(town[i]);
		}
			
		graph.addEdge(town[1], town[2], 2, "Road_1");
		graph.addEdge(town[5], town[4], 5, "Road_2");
		graph.addEdge(town[1], town[4], 6, "Road_3");

		graph.addEdge(town[2], town[3], 1, "Road_4");
		graph.addEdge(town[4], town[2], 2, "Road_5");

		graph.addEdge(town[4], town[3], 3, "Road_6");
		  
		  
		  
		
	}
	@AfterEach
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(town[1], town[2],2, "Road_1"), graph.getEdge(town[1], town[2]));
		assertEquals(new Road(town[2], town[3],1, "Road_4"), graph.getEdge(town[2], town[3]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graph.containsEdge(town[3], town[5]));
		graph.addEdge(town[3], town[5], 1, "Road_7");
		assertEquals(true, graph.containsEdge(town[3], town[5]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_6");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[3]));
		assertEquals(false, graph.containsEdge(town[1], town[5]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_2")));
		assertEquals(false, graph.containsVertex(new Town("Town_12")));
	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_2", roadArrayList.get(1));
		assertEquals("Road_3", roadArrayList.get(2));
		assertEquals("Road_5", roadArrayList.get(4));
		assertEquals("Road_6", roadArrayList.get(5));
		
	}

	@Test
	public void testEdgesOf() {
		Set<Road> roads = graph.edgesOf(town[2]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1", roadArrayList.get(0));
		assertEquals("Road_4", roadArrayList.get(1));
		assertEquals("Road_5", roadArrayList.get(2));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town[2], town[3]));
		graph.removeEdge(town[2], town[3], 1, "Road_4");
		assertEquals(false, graph.containsEdge(town[2], town[3]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town[2]));
		graph.removeVertex(town[2]);
		assertEquals(false, graph.containsVertex(town[2]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[1]));
		assertEquals(true, roads.contains(town[2]));
		assertEquals(true, roads.contains(town[3]));
		assertEquals(true, roads.contains(town[4]));
		assertEquals(true, roads.contains(town[5]));
	}

	 @Test
	  public void testTown_1ToTown_5() {
		  String beginTown = "Town_1", endTown = "Town_5";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_1 to Town_2 2 mi",path.get(0).trim());
			  assertEquals("Town_2 via Road_5 to Town_4 2 mi",path.get(1).trim());
			  assertEquals("Town_4 via Road_2 to Town_5 5 mi",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	  @Test
	  public void testTown3ToTown_4() {
		  String beginTown = "Town_3", endTown = "Town_4";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_3 via Road_6 to Town_4 3 mi",path.get(0).trim());
			  
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  @Test
	  public void testTown_3ToTown_1() {
		  String beginTown = "Town_3", endTown = "Town_1";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_3 via Road_4 to Town_2 1 mi",path.get(0).trim());
			  assertEquals("Town_2 via Road_1 to Town_1 2 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }

}
