import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Comparator;

public class BasicDoubleLinkedList <T> implements Iterable<T> {

	protected Node head;
	protected Node tail;
	protected int size;
	
	
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	
	public int getSize() {
		return size;
	}
	
	public void addToEnd(T data) {
		Node newNode = new Node(data);
		
		if(getSize() == 0) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		
		tail = newNode;
		size++;
		
	}
	
	public void addToFront(T data) {
		
		Node newNode = new Node(data);
		
		if(getSize() == 0) {
			
			tail = newNode;
		} else {
			head.previous = newNode;
			newNode.next = head;
		}
		
		head = newNode;
		size++;
	}
	
	public T getFirst() {
		if (head == null) {
			return null;
		}
		return head.data;
	}
	
	public T getLast() {
		if (tail == null) {
			return null;
		}
		return tail.data;
	}
	
	
	
	public ListIterator<T> iterator(){
		return new DoubleLinkedListIterator();
	}
	
	
	public Node remove (T targetData, Comparator<T> comparator){
		Node currentNode = head;
		while(currentNode != null) {
			
			// if the target and the current node's data are equal
			if (comparator.compare(targetData, currentNode.data) != 0) {
				currentNode = currentNode.next;
			}
			
			//if they are equal then remove the node
			else {
				if (getSize() == 1) {
					head = null;
					tail = null;
				}else {
					//if there is a previous node, set the previous node's next to the removed node's next
					if (currentNode.previous != null) {
						currentNode.previous.next = currentNode.next;
					} else {
						head = currentNode.next;
						head.previous= null;
					}
					
					//if there is a next node, set the next node's previous to the removed node's previous
					if (currentNode.next != null) {
						currentNode.next.previous = currentNode.previous;
					} else {
						
						tail = currentNode.previous;
						tail.next = null;
					}
				}
				
				
				//if it is the last node, set head and tail to null
				
				
				size--;
				return currentNode;
			}
			
		}
		
		
		//in case nothing matches, it returns null;
		return null;
		
		
		
	}
	
	public T retrieveFirstElement() {
		if (head == null) {
			return null;
		}
		Node newHead = head.next;
		T firstElement = head.data;
		
		if(newHead !=null) {
			newHead.previous = null;
		}
		
		if(getSize() == 1) {
			head = null;
			tail = null;
		}else {
			head = newHead;
		}
		
		
		
		size--;
		
		return firstElement;
		
	}

	public T retrieveLastElement() {
		if (tail == null) {
			return null;
		}
		Node newTail = tail.previous;
		T lastElement = tail.data;
		
		if(newTail !=null) {
			newTail.next = null;
		}
		
		if(getSize() == 1) {
			head = null;
			tail = null;
		}else {
			tail = newTail;
		}
		size--;
		
		return lastElement;
	}
	
	public ArrayList<T> toArrayList() {
		ArrayList<T> newArrayList = new ArrayList<>();
		Node currNode = head;
		
		while (currNode != null) {
			newArrayList.add(currNode.data);
			currNode = currNode.next;
		}
		return newArrayList;
		
	}
	
	
	protected class Node{
		protected T data;
		protected Node previous;
		protected Node next;
		
		public Node(T dataNode) {
			previous = null;
			next = null;
			data = dataNode;
		}
		
		
	}
	
	protected class DoubleLinkedListIterator implements ListIterator<T> {
		//this node is to prevent "hasPrevious" and "previous" logic errors
		protected Node before;
		protected Node current;
		
		
		public DoubleLinkedListIterator() {
			before = head.previous;
			current = head;
		}
		
		public boolean hasNext() {
			return current != null;
		}
		
		public T next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T data = current.data;
			before = current;
			current = current.next;
			return data;
			
		}
		
		public boolean hasPrevious() {
			return before != null;
		}
		
		public T previous() throws NoSuchElementException {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			T data = before.data;
			
			current = before;
			before = before.previous;
			
			return data;
		}
		
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public void add (T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public void set(T arg0) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
		
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}
}
