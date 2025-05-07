
public class Road implements Comparable<Road>{
	
	//instance variables
	private Town firstTown;
	private Town secondTown;
	private int distance;
	private String name;
	
	
	//constructors
	public Road(Town source, Town destination, int degrees, String name) {
		firstTown = source;
		secondTown = destination;
		distance = degrees;
		
		this.name = name;
	}
	
	
	public Road(Town source, Town destination, String name) {
		firstTown = source;
		secondTown = destination;
		distance = 1;
		
		this.name = name;
	}
	
	
	
	//methods
	public boolean contains(Town town) {
		return firstTown.equals(town) || secondTown.equals(town);
	}
	
	public String toString(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setDestination(Town newDestination) {
		this.secondTown = newDestination;
	}
	
	public Town getDestination() {
		return secondTown;
	}
	
	
	public void setSource(Town newSource) {
		this.firstTown = newSource;
	}
	
	public Town getSource() {
		return firstTown;
	}
	
	public int compareTo(Road o) {
		return name.compareTo(o.name);
	}
	
	public void setWeight(int weight) {
		this.distance = weight;
	}
	
	public int getWeight() {
		return distance;
	}
	
	public boolean equals(Object r) {
		if (!(r instanceof Road)) {
			return false;
		}
		
		Road newRoad = (Road) r;
		
		return (firstTown.equals(newRoad.firstTown) && secondTown.equals(newRoad.secondTown)) || (firstTown.equals(newRoad.secondTown) && secondTown.equals(newRoad.firstTown));
	}
	
	
}
