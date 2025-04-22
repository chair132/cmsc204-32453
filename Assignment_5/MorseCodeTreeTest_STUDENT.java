import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest_STUDENT {

	MorseCodeTree tree;
    @BeforeEach
    void setUp() throws Exception {
    	tree = new MorseCodeTree();
    	tree.buildTree();
    }

    @AfterEach
    void tearDown() throws Exception {
    	tree = null;
    }

    @Test
    void testGetRoot() {
		assertTrue(tree.getRoot().data.equals(""));
    }

    @Test
    void testSetRoot() {
		tree.setRoot(new TreeNode<String>("john"));
		assertTrue(tree.getRoot().data.equals("john"));
		
		
    }

    @Test // Test case for method addNode(TreeNode<String> root, String code, String
	  // letter)
    void testAddNodePassingRoot() {

    	TreeNode<String> root = tree.getRoot();
    	
    	//converts to an uppercase P
        tree.addNode(root, ".--.", "P");
        
        //tests if the conversion worked
        assertTrue("P".equals(tree.fetchLetter(tree.getRoot(), ".--.")));
    }

    @Test
    void testBuildTree() {
    	assertTrue("p".equals(tree.fetchLetter(tree.getRoot(), ".--.")));
    	assertTrue("z".equals(tree.fetchLetter(tree.getRoot(), "--..")));
    }

    @Test
    void testFetchLetter() {
    	//same test as buildTree
    	assertTrue("v".equals(tree.fetchLetter(tree.getRoot(), "...-")));
    	assertTrue("l".equals(tree.fetchLetter(tree.getRoot(), ".-..")));
    }

    @Test
    void testToArrayList() {
    	ArrayList<String> list = tree.toArrayList();
    	
    	//has a space for the empty string as the root
    	assertTrue(list.toString().equals("[h, s, v, i, f, u, e, l, r, a, p, w, j, , b, d, x, n, c, k, y, t, z, g, q, m, o]"));
    	
    }

    @Test
    void testPrintTree() {
    	
    	//has a space for the empty string as the root
    	assertTrue(tree.printTree().equals("h s v i f u e l r a p w j  b d x n c k y t z g q m o "));
		
    }

}
