import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	//first in queue
	private Node firstNode;
	//last in queue
	private Node lastNode;	
	private int capacity;
	
	private static final int DEFAULT_CAPACITY = 10;

	//constructors
	public MyQueue() {
		firstNode = null;
		lastNode = null;
		this.capacity = DEFAULT_CAPACITY;
	}
	
	public MyQueue(int capacity) {
		if(capacity < 1) {
			this.capacity = DEFAULT_CAPACITY;
		} else {
			this.capacity = capacity;
		}
		
		firstNode = null;
		lastNode = null;
		
	}
	
	//methods
	public boolean isEmpty() {
		return firstNode == null && lastNode == null;
	}
	
	public T dequeue() throws QueueUnderflowException{
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T result = firstNode.data;
		
		//if it is the only node in the queue, set the last node to null afterwards
		if(firstNode == lastNode) {
			lastNode = null;
		}
		firstNode = firstNode.next;
		
		
		return result;
	}
	
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		
		
		int count = 1;
		Node currNode = firstNode;
		while(currNode != lastNode) {
			count++;
			currNode = currNode.next;
		}
		return count;
	}
	
	public boolean enqueue(T e) throws QueueOverflowException{
		if(isFull()) {
			throw new QueueOverflowException();
		} else if (e == null) {
			return false;
		}
		
		Node newNode = new Node(e);
		
		if(isEmpty()) {
			firstNode = newNode;
		} else {
			lastNode.next = newNode;
		}
		lastNode = newNode;
		return true;
		
	}
	
	
	public boolean isFull() {
		return size() >= capacity;
	}
	
	public String toString() {
		String result = "";
		Node currNode = firstNode;
		//if empty queue, do not go through the loop
		while (currNode != null) {
			result +=currNode.data + " ";
			currNode = currNode.next;
		}
		return result;
	}
	
	public String toString(String delimiter) {
		String result = "";
		Node currNode = firstNode;
		//if empty queue, do not go through the loop
		while (currNode != null) {
			result +=currNode.data + delimiter;
			currNode = currNode.next;
		}
		return result;
	}
	
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		ArrayList<T> newList = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			newList.add(list.get(i));
		}
		
		for(int i = 0; i < newList.size(); i++) {
			enqueue(newList.get(i));
		}
		
	}
	
	
	private class Node{
		private T data;
		private Node next;
		
		private Node(T data) {
			this(data, null);
		}
		
		private Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
