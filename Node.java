
// -------------------------------------------------------------------------
/**
 *  Node necessary for LinkedList class.
 *
 *  @author jamied93 domnap
 *  @version Sep 15, 2013
 */
public class Node
{
    /**
     * Reference to the next node in the chain, or null if there isn't one.
     */
    Node next;
    /**
     * Data carried by this node.
     */
    Object data;

    // ----------------------------------------------------------
    /**
     * Create a new Node object.
     * @param dataValue the object the node is set to
     */
    public Node(Object dataValue) {
        next = null;
        data = dataValue;
    }

    // ----------------------------------------------------------
    /**
     * Create a new Node object specifying the node to point to.
     * @param dataValue the object the node is set to
     * @param nextValue the node being pointed to
     */
    public Node(Object dataValue, Node nextValue) {
        next = nextValue;
        data = dataValue;
    }

    // ----------------------------------------------------------
    /**
     * Getter method for the object.
     * @return data
     */
    public Object getData() {
        return data;
    }

    // ----------------------------------------------------------
    /**
     * Setter method for the object.
     * @param dataValue the object the data is set to
     */
    public void setData(Object dataValue) {
        data = dataValue;
    }

    // ----------------------------------------------------------
    /**
     * Get the next node in the chain.
     * @return the next node in the chain
     */
    public Node getNext() {
        return next;
    }

    // ----------------------------------------------------------
    /**
     * Set the next node in the chain.
     * @param nextValue the node next is set to
     */
    public void setNext(Node nextValue) {
        next = nextValue;
    }

}
