import java.io.File;
import java.io.IOException;
import java.util.*;


public class TownGraphManager implements TownGraphManagerInterface {
	private Graph graph;
	
	public TownGraphManager() {
		graph = new Graph();
	}
	
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Road newRoad = graph.addEdge(new Town(town1), new Town(town2), weight, roadName);
		
		return newRoad != null;
	}
	
	public String getRoad(String town1, String town2) {
		return (graph.getEdge(new Town(town1), new Town(town2))).toString();
	}
	
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}
	
	public Town getTown(String name) {
		if(containsTown(name)) {
			for(Town town : graph.vertexSet()) {
				if(town.toString().equals(name)) {
					return town;
				}
			}
		}
		
		
		return null;
	}
	
	
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}
	
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
	}
	
	public ArrayList<String> allRoads(){
		Set<Road> roadSet = graph.edgeSet();
		ArrayList<String> newList = new ArrayList<>();
		
		
		for(Road road : roadSet) {
			newList.add(road.toString());
		}
		
		Collections.sort(newList);
		return newList;
	}
	
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		return graph.removeEdge(new Town(town1), new Town(town2), 0, road) != null;
	}
	
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}
	
	public ArrayList<String> allTowns(){
		Set<Town> townSet = graph.vertexSet();
		ArrayList<String> newList = new ArrayList<>();
		
		
		for(Town town : townSet) {
			newList.add(town.toString());
		}
		
		Collections.sort(newList);
		return newList;
	}
	
	public ArrayList<String> getPath(String town1, String town2){
		return graph.shortestPath(new Town(town1), new Town(town2));
	}

	public void populateTownGraph(File selectedFile) throws IOException{
		try (Scanner inputFile = new Scanner(selectedFile)){
			
			while(inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				
				String[] splitLine = line.split(";");
				
				String roadName = line.substring(0, line.indexOf(','));
				int distance = Integer.parseInt(line.substring(line.indexOf(',')+1, line.indexOf(';')));
				
				String town1 = splitLine[1];
				String town2 = splitLine[2];
				
				
				if(!containsTown(town1)) {
					addTown(town1);
				}
				if(!containsTown(town2)) {
					addTown(town2);
				}
				
				addRoad(town1,town2,distance,roadName);
				
				
			}
			
		} catch(IOException e) {
			throw new IOException();
		}
		
		
	}
}
