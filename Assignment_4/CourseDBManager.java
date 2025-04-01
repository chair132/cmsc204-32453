import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure structure;
	
	
	//default size of 10
	public CourseDBManager() {
		structure = new CourseDBStructure(10);
	}
	
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		structure.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
	}
	
	public ArrayList<String> showAll() {
		return structure.showAll();
	}
	
	public void readFile(File input) throws FileNotFoundException{
		try (Scanner inputFile = new Scanner(input)){
			while(inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				
				
				//if it isn't empty
				if (line.length() != 0) {
					int index = line.indexOf(" ");
					int nextIndex;
					
					//change this code
					
					String id = line.substring(0, index);
					index++;
					line = line.substring(index);
					nextIndex = line.indexOf(" ");
					
					
					
					
					
					int crn = Integer.parseInt(line.substring(0, nextIndex));
					index = nextIndex + 1;
					line = line.substring(index);
					
					nextIndex = line.indexOf(" ");
					
					
					
					int credits = Integer.parseInt(line.substring(0, nextIndex));
					index = nextIndex + 1;
					line = line.substring(index);
					nextIndex = line.indexOf(" ");
					
					
					
					String roomNum = line.substring(0, nextIndex);
					index = nextIndex + 1;
					line = line.substring(index);
					
					String instructor = line.substring(0);
					
					
					add(id, crn, credits, roomNum, instructor);
				}
				
			}
			
			
		} catch(FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}
	
	public CourseDBElement get(int crn) {
		try {
			return structure.get(crn);
		} catch (IOException e) {
			return null;
		}
	}
	
}
