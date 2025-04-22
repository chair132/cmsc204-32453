
public class TreeNode<T> {
	public T data;
	public TreeNode<T> leftNode;
	public TreeNode<T> rightNode;
	
	public TreeNode (T dataNode) {
		data = dataNode;
		leftNode = null;
		rightNode = null;
	}
	
	public TreeNode (TreeNode<T> node) {
		data = node.data;
		leftNode = node.leftNode;
		rightNode = node.rightNode;
	}
	
	public T getData() {
		return data;
	}
	
	
	
	
	
}
