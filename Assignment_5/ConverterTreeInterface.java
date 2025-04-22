
import java.util.ArrayList;

/**
 * This is a generic ConverterTreeInterface used by MorseCodeTree
 * 
 * @author Farnaz Eivazi
 * @version 4/1/2024
 */

public interface ConverterTreeInterface<T> {

    /**
     * Returns a reference to the root of the MorseCodeTree
     * 
     * @return reference to root of the MorseCodeTree
     */
    TreeNode<T> getRoot();

    /**
     * Sets the root of the MorseCodeTree
     * 
     * @param newNode the new node that will be the new root of the MorseCodeTree
     */
    void setRoot(TreeNode<T> newNode);

    /**
     * This is a recursive method that adds nodes to the correct position in the
     * tree based on the code.
     * 
     * @param root   the root of the tree
     * @param code   the code
     * @param letter the data of the new TreeNode to be added
     */
    void addNode(TreeNode<T> root, T code, T letter);

    /**
     * This is the recursive method that fetches the data/letter of the TreeNode
     * that corresponds with the code.
     * 
     * @param root the root of the tree
     * @param code the code
     * @return the data corresponding to the code
     */
    T fetchLetter(TreeNode<T> root, T code);

    /**
     * This method builds the MorseCodeTree by inserting nodes and their data into
     * their proper locations
     * 
     */
    void buildTree();

    /**
     * Returns an ArrayList of the data/letters in the MorseCodeTree in LNR
     * (Inorder) Traversal order.
     * 
     * @return an ArrayList of the data in the MorseCodeTree
     */
    ArrayList<T> toArrayList();

    /**
     * Returns a string with all the data in the tree in in-order with an space in
     * between them. Uses the toArrayList method in MorseCodeTree to get the data.
     * 
     * @return the data in the tree in LNR order separated by a space.
     */
    String printTree();

    /**
     * The recursive method to traverse the contents of the MorseCodeTree in an
     * ArrayList<T> LNR (Inorder)
     * 
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR
     *             order
     */
    void traverseInOrder(TreeNode<T> root, ArrayList<T> list);

}
