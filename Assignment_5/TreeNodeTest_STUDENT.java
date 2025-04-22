import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeNodeTest_STUDENT {

    @BeforeEach
    void setUp() throws Exception {
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test // Test case for TreeNode(T dataNode) constructor
    void testTreeNodePassingData() {
		TreeNode<Integer> node1 = new TreeNode<>(2);
		TreeNode<Integer> nodeLeft = new TreeNode<>(3);
		
		node1.leftNode = nodeLeft;
		
		assertEquals(node1.leftNode, nodeLeft);
		assertEquals(node1.rightNode, null );
		assertEquals(node1.data, 2);
    }

    @Test // Test case for TreeNode(TreeNode<T> node) constructor
    void testCopyTreeNode() {
    	TreeNode<Integer> node1 = new TreeNode<>(2);
		TreeNode<Integer> nodeLeft = new TreeNode<>(3);
		
		node1.leftNode = nodeLeft;
		
		TreeNode<Integer> copyNode = new TreeNode<>(node1);
		
		
		assertEquals(copyNode.leftNode, nodeLeft);
		assertEquals(copyNode.rightNode, null );
		assertEquals(copyNode.data, 2);
    }

    @Test
    void testGetData() {
    	TreeNode<Integer> node1 = new TreeNode<>(2);
		TreeNode<Integer> node2 = new TreeNode<>(3);
		
		assertEquals(node1.getData(), 2);
		assertEquals(node2.getData(), 3);
    }

}
