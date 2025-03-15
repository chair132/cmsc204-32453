import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	private Comparator<T> comparable;
	
	public SortedDoubleLinkedList(Comparator<T> comparableObject) {
		super();
		comparable = comparableObject;
	}
	
	
	public void add(T data) {
		Node newNode = new Node(data);
		
		
		//empty list
		if (super.head == null) {
			super.head = newNode;
			super.tail = newNode;
			
		//inserting before the tail
		} else if (comparable.compare(newNode.data, super.head.data) < 0){
			newNode.next = super.head;
			
			super.head.previous = newNode;
			super.head = newNode;
			
		//inserting after the tail
		} else if (comparable.compare(newNode.data, super.tail.data) > 0) {
			newNode.previous = super.tail;
			
			super.tail.next = newNode;
			super.tail = newNode;
			
		//inserting in the middle
		} else {
			Node currNode = super.head;
			while(currNode != null && currNode.next != null && comparable.compare(newNode.data, currNode.data) >= 0) {
				currNode = currNode.next; 
			}
			
			//safety precaution
			if(currNode.previous != null) {
				currNode.previous.next = newNode;
			}
			
			newNode.previous = currNode.previous;
			currNode.previous = newNode;
			
			newNode.next = currNode;
			
		}
		
		
		
		
		super.size++;
		
	}
	
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	public Node remove(T data, Comparator<T> comparator) {
		return super.remove(data, comparator);
	}
	
}
