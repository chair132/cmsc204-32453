import java.util.*;


public class Graph implements GraphInterface <Town, Road>{

	private Set<Road> roads;
	private Map<Town, Set<Road>> adjacencyMap;
	
	public Graph() {
		roads = new HashSet<>();
		adjacencyMap = new HashMap<>();
	}
	
	
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		if(sourceVertex == null || destinationVertex == null) {
			return null;
		}
		
		
		//checks if there are any roads from source to destination
		for (Road road : adjacencyMap.get(sourceVertex)) {
			if(road.getDestination().equals(destinationVertex)) {
				return road;
			}
		}
		
		//checks if there are any roads from destination to source
		for (Road road : adjacencyMap.get(destinationVertex)) {
			if(road.getDestination().equals(sourceVertex)) {
				return road;
			}
		}
		
		return null;
		
		

	}
	
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws IllegalArgumentException, NullPointerException{
		if(sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		
		if (!(containsVertex(sourceVertex) && containsVertex(destinationVertex))) {
			throw new IllegalArgumentException();
		}
		
		Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
		
		roads.add(newRoad);
		
		adjacencyMap.get(sourceVertex).add(newRoad);
		adjacencyMap.get(destinationVertex).add(newRoad);
		
		
		
		
		return newRoad;
		
		}
	
	
	public boolean addVertex(Town v) throws NullPointerException{
		if (v == null) {
			throw new NullPointerException();
		}
		
		if (!containsVertex(v)) {
			adjacencyMap.put(v, new HashSet<>());
			
			return true;
		}
		return false;
	}
	
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		return getEdge(sourceVertex,destinationVertex) != null;
	}
	
	
	public boolean containsVertex(Town v) {
		for(Town town : adjacencyMap.keySet()) {
			if(town.equals(v)) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public Set<Road> edgeSet(){
		return roads;
	}
	
	public Set<Road> edgesOf(Town vertex) throws IllegalArgumentException, NullPointerException{
		if(vertex == null) {
			throw new NullPointerException();
		}
		
		if(!containsVertex(vertex)) {
			throw new IllegalArgumentException();
		}
		
		return adjacencyMap.get(vertex);
		
	}
	
	
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		//4 cases
		
		//case 1, weight >= 1 description != null
		if (weight >= 1 && description != null) {
			for(Road road : roads) {
				if(road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex) && road.getWeight() == weight && road.getName().equals(description)) {
					
					roads.remove(road);
					adjacencyMap.get(sourceVertex).remove(road);
					adjacencyMap.get(destinationVertex).remove(road);
					
					
					
					return road;
				}
			}
		}
		
		
		//case 2, weight >= 1 description == null
		else if (weight >= 1 && description == null) {
			for(Road road : roads) {
				if(road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex) && road.getWeight() == weight) {
					roads.remove(road);
					adjacencyMap.get(sourceVertex).remove(road);
					adjacencyMap.get(destinationVertex).remove(road);
					
					
					
					return road;
				}
			}
		}
		
		
		//case 3, weight < 1 description != null
		else if (weight < 1 && description != null) {
			for(Road road : roads) {
				if(road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex) && road.getName().equals(description)) {
					roads.remove(road);
					adjacencyMap.get(sourceVertex).remove(road);
					adjacencyMap.get(destinationVertex).remove(road);
					
					
					//if there are no more edges connecting the two vertices, remove each other from the adjacent towns arraylist
					
					
					return road;
				}
			}
		}
		
		//case 4, weight < 1 description == null
		else {
			for(Road road : roads) {
				if(road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex)) {
					roads.remove(road);
					adjacencyMap.get(sourceVertex).remove(road);
					adjacencyMap.get(destinationVertex).remove(road);
					
					
					//if there are no more edges connecting the two vertices, remove each other from the adjacent towns arraylist
					
					
					return road;
				}
			}
		}
		
		return null;
	}
	
	public boolean removeVertex(Town v) {
		for(Town town : adjacencyMap.keySet()) {
			
			//if the town is found
			if(town.equals(v)) {
				//remove the roads associated with the town
				for(Road road : adjacencyMap.remove(v)) {
					roads.remove(road);
					
				}
				return true;
			}
		}
		
		
		return false;
	}
	
	public Set<Town> vertexSet(){
		return adjacencyMap.keySet();
	}
	
	//paths
	private Map<Town, Town> previous;
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex){
		
		dijkstraShortestPath(sourceVertex);
		
	    ArrayList<String> path = new ArrayList<>();
	    LinkedList<Town> stack = new LinkedList<>();

	    Town step = destinationVertex;
	    if (previous.get(step) == null) {return path;} // No path

	    while (step != null) {
	        stack.push(step);
	        step = previous.get(step);
	    }

	    while (stack.size() > 1) {
	        Town from = stack.pop();
	        Town to = stack.peek();
	        for (Road edge : edgesOf(from)) {
	            if ((edge.getSource().equals(from) && edge.getDestination().equals(to)) ||
	                (edge.getSource().equals(to) && edge.getDestination().equals(from))) {
	                path.add(from + " via " + edge + " to " + to + " " + edge.getWeight() + " mi");
	                break;
	            }
	        }
	    }

	    return path;
	}
	
	public void dijkstraShortestPath(Town sourceVertex) {
	    Map<Town, Integer> distances = new HashMap<>();
	    previous = new HashMap<>();
	    Set<Town> visited = new HashSet<>();

	    for (Town town : vertexSet()) {
	        distances.put(town, Integer.MAX_VALUE);
	        previous.put(town, null);
	    }

	    distances.put(sourceVertex, 0);
	    PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
	    pq.add(sourceVertex);

	    while (!pq.isEmpty()) {
	        Town current = pq.poll();
	        if (visited.contains(current)) continue;
	        visited.add(current);

	        for (Road edge : edgesOf(current)) {
	            Town neighbor = edge.getDestination().equals(current) ? edge.getSource() : edge.getDestination();
	            if (visited.contains(neighbor)) continue;

	            int newDist = distances.get(current) + edge.getWeight();
	            if (newDist < distances.get(neighbor)) {
	                distances.put(neighbor, newDist);
	                previous.put(neighbor, current);
	                pq.add(neighbor);
	            }
	        }
	    }
	}
	
	
	
	
	
	
}
