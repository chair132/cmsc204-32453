import java.util.ArrayList;


public class MyStack<T> implements StackInterface<T> {
	private Node topNode;
	private int capacity;
	private static final int DEFAULT_CAPACITY = 10; 
	
	public MyStack() {
		topNode = null;
		capacity = DEFAULT_CAPACITY;
	}
	
	public MyStack(int capacity) {
		
		if(capacity < 1) {
			this.capacity = DEFAULT_CAPACITY;
		} else {
			this.capacity = capacity;
		}
		
		topNode = null;
		
	}
	
	public boolean isEmpty() {
		return topNode == null;
	}
	
	
	public boolean isFull() {
		return size() >= capacity;
	}
	
	public T pop() throws StackUnderflowException{
		if (isEmpty()) {
			throw new StackUnderflowException();
		}
		
		T result = topNode.data;
		topNode = topNode.next;
		
		//if it is a NOT an empty node, assign the next node's previous to null because there's nothing left after
		if (topNode != null) {
			topNode.previous = null;
		}
		
		return result;
		
	}
	
	public T top() throws StackUnderflowException{
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		
		return topNode.data;
	}
	
	public int size() {
		int count = 0;
		Node currNode = topNode;
		while(currNode != null) {
			count++;
			currNode = currNode.next;
		}
		
		return count;
	}
	
	public boolean push(T e) throws StackOverflowException{
		if(isFull()) {
			throw new StackOverflowException();
			
			
		} else if (e == null) {
			return false;
		
		} else if(isEmpty()) {
			topNode = new Node(e);
			return true;
		
		} else {
			Node newNode = new Node(null, e, topNode);
			topNode.previous = newNode;
			topNode = newNode;
			return true;
		}
		
		
		
	}
	
	public String toString() {
		String result = "";
		Node currNode = topNode;
		
		
		
		//this takes care of empty stacks too
		//traversing to the bottom of the stack (bottom node)
		while(currNode != null && currNode.next != null) {
			currNode = currNode.next;
		}
		
		
		//traversing backwards and adding to result string
		while(currNode != null ) {
			result += currNode.data + " ";
			currNode = currNode.previous;
		}
		
		return result;
		
		
		
		
	}
	
	
	public String toString(String delimiter) {
		String result = "";
		Node currNode = topNode;
		
		//this takes care of empty stacks too
		//traversing to the bottom of the stack
		while(currNode != null && currNode.next != null) {
			currNode = currNode.next;
		}
		
		
		//traversing backwards and adding to result string
		while(currNode != null ) {
			result += currNode.data + delimiter;
			currNode = currNode.previous;
		}
		
		return result;
		
		
	}
	
	
	public void fill(ArrayList<T> list) throws StackOverflowException{
		
		ArrayList<T> newList = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			newList.add(list.get(i));
		}
		
		
		
		for(int i = 0; i < newList.size(); i++) {
			push(newList.get(i));
		}
	}
	
	
	private class Node{
		private Node previous;
		private T data;
		private Node next;
		
		private Node(T data) {
			this(null,data, null);
		}
		
		private Node(Node previous, T data, Node next) {
			this.previous = previous;
			this.data = data;
			this.next = next;
		}
	}

}
