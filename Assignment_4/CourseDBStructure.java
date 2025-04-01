import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {
	private LinkedList<CourseDBElement>[] hashTable;
	private int tableSize;
	
	public CourseDBStructure(int num) {
		int estimatedSize = (int) (num / 1.5);
		tableSize = get4KPrime(estimatedSize);
		hashTable = new LinkedList[tableSize];
		
		
		
		
	}
	
	public CourseDBStructure(String numElements, int size) {
		tableSize = size;
		hashTable = new LinkedList[tableSize];
	}
	
	
	//methods
	public void add(CourseDBElement element) {
		int hashIndex = element.hashCode() % tableSize;
		
		if(hashTable[hashIndex] == null) {
			hashTable[hashIndex] = new LinkedList<>();
		}
		hashTable[hashIndex].add(element);
		
	}
	
	public ArrayList<String> showAll() {
		ArrayList<String> result = new ArrayList<>();
		
		for(int i = 0; i < hashTable.length; i++) {
			if(hashTable[i] != null) {
				for(int j = 0; j < hashTable[i].size(); j++) {
					result.add(hashTable[i].get(j).toString() + "\n");
				}
			}
		}
		return result;
	}
	
	public CourseDBElement get(int crn) throws IOException {
		String crnHash = Integer.toString(crn);
		int hashIndex = crnHash.hashCode() % tableSize;
		
		LinkedList<CourseDBElement> currentBucket = hashTable[hashIndex];
		
		if(currentBucket == null) {
			throw new IOException("CRN "+ crn + " was not found.");
		}
		
		for(int i = 0; i < currentBucket.size(); i++) {
			if (currentBucket.get(i).getCRN() == crn) {
				return currentBucket.get(i);
			}
		}
		throw new IOException("CRN "+ crn + " was not found.");
		
	}
	
	public int getTableSize() {
		return tableSize;
	}
	
	public static int get4KPrime(int num) {
		num +=1;
		while(true) {
			if((num % 4 == 3) && (isPrime(num))) {
				return num;
			}
			num++;
		}
	}
	
	
	//utility method
	private static boolean isPrime(int num) {
		if (num <=1) {
			return false;
		}
		for(int i = 2; i <= num/2; i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
