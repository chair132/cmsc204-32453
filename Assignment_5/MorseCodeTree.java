import java.util.*;


public class MorseCodeTree implements ConverterTreeInterface<String> {
	private TreeNode<String> root;
	
	
	public MorseCodeTree() {
		root = null;
	}
	
	public TreeNode<String> getRoot() {
		return root;
	}
	
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		//base case
		if(code.length() == 1) {
			//left
			if (code.equals(".")) {
				root.leftNode = new TreeNode<>(letter);
			} else if(code.equals("-")) {
				root.rightNode = new TreeNode<>(letter);
			}
			return;
		}
		
		
		char newLetter = code.charAt(0);
		String newCode = code.substring(1);
		
		if(newLetter == '.') {
			addNode(root.leftNode, newCode, letter);
		} else if (newLetter == '-') {
			addNode(root.rightNode, newCode, letter);
		}
		
	}
	
	public void addNode(String code, String letter) {
		addNode(root, code, letter);
	}
	
	public void buildTree() {
		root = new TreeNode<>("");
		
		//level by level
		addNode(".", "e");
		addNode("-", "t");
		
		addNode("..", "i");
		addNode(".-", "a");
		addNode("-.", "n");
		addNode("--", "m");
		
		addNode("...", "s");
	    addNode("..-", "u");
	    addNode(".-.", "r");
	    addNode(".--", "w");
	    addNode("-..", "d");
	    addNode("-.-", "k");
	    addNode("--.", "g");
	    addNode("---", "o");
		
		addNode("....", "h");
	    addNode("...-", "v");
	    addNode("..-.", "f");
	    addNode(".-..", "l");
	    addNode(".--.", "p");
	    addNode(".---", "j");
	    addNode("-...", "b");
	    addNode("-..-", "x");
	    addNode("-.-.", "c");
	    addNode("-.--", "y");
	    addNode("--..", "z");
	    addNode("--.-", "q");
		
		
		
	}
	
	public String fetchLetter(TreeNode<String> root, String code) {
		if(code.length() ==0) {
			return root.getData();
		}
		
		char newLetter = code.charAt(0);
		String newCode = code.substring(1);
		
		if(newLetter == '.') {
			return fetchLetter(root.leftNode, newCode);
		} else {
			return fetchLetter(root.rightNode, newCode);
		}
		
		
	}
	
	public ArrayList<String> toArrayList() {
		ArrayList<String> result = new ArrayList<>();
		traverseInOrder(root, result);
		return result;
	}
	
	public String printTree() {
		ArrayList<String> result = toArrayList();
		String finalString = "";
		
		for(int i = 0; i < result.size(); i++) {
			finalString += result.get(i) + " ";
		}
		return finalString;
	}
	
	public void traverseInOrder(TreeNode<String> root, ArrayList<String> list) {
		//goes back if it is null
		if (root == null) {
			return;
		}
		
		traverseInOrder(root.leftNode, list);
		list.add(root.getData());
		traverseInOrder(root.rightNode, list);
		
	}
}
