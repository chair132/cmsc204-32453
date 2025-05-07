
public class Town implements Comparable<Town> {
	private String name;
	
	
	public Town(String name) {
		this.name = name;
	
	}
	
	
	public Town (Town templateTown) {
		this.name = templateTown.name;
		
	}
	
	
	//methods
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	public int compareTo(Town o) {
		return this.name.compareTo(o.name);
	}
	
	
	public String toString() {
		return name;
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Town)) {
			return false;
		}
		Town newObj = (Town) obj;
		
		return this.name.equals(newObj.name);
	}
}
