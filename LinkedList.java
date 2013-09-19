
// -------------------------------------------------------------------------
/**
 *  A data structure consisting of nodes that are linked, so each node knows
 *  what node is in front and what node is behind it.
 *
 *  @author jamied93 domnap
 *  @version Sep 14, 2013
 */
public class LinkedList
{

    //reference to the head node.
    private Node head;
    private int listCount;

    // ----------------------------------------------------------
    /**
     * Create a new LinkedList object.
     */
    public LinkedList() {
        //this is an empty list, so the reference to the head node
        //is set to a new node with no data
        head = new Node(null);
        listCount = 0;
    }

    // ----------------------------------------------------------
    /**
     * Adds the specified element to the end of the list.
     * @param data the object to be added
     */
    public void add(Object data)
    {
        Node temp = new Node(data);
        Node current = head;
        //starting at the head node, crawl to the end of the list
        while (current.getNext() != null) {
            current = current.getNext();
        }
        //the last node's "next" reference set to our new node
        current.setNext(temp);
        listCount++; //increment the number of elements variable
    }

    // ----------------------------------------------------------
    /**
     * Adds the specified element at the specified position in the list.
     * @param data the object to be added
     * @param index the position the object will be added
     */
    public void add(Object data, int index)
    {
        Node temp = new Node(data);
        Node current = head;
        //crawl to the requested index or the last element in the list,
        //whichever comes first
        for (int i = 1; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        //set the new node's next-node reference to this node's next-node
        //reference
        temp.setNext(current.getNext());
        //now set this node's next-node reference to the new node
        current.setNext(temp);
        listCount++; //increment the number of elements variable
    }

    // ----------------------------------------------------------
    /**
     * Returns the element at the specified position in the list.
     * @param index
     * @return the element at the specified position
     */
    public Object get(int index)
    {
        //index must be 1 or higher
        if (index <= 0)
            return null;

        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null)
                return null;

            current = current.getNext();
        }
        return current.getData();
    }

    // ----------------------------------------------------------
    /**
     * Removes the element at the specified position in the list.
     * @param index the position the element will be removed from
     * @return true if element is removed correctly
     */
    public boolean remove(int index) //need to be boolean??
    {
        //if the index is out of range, exit
        if (index < 1 || index > size())
            return false;

        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null)
                return false;

            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--; //decrement the number of elements variable
        return true;
    }

    // ----------------------------------------------------------
    /**
     * Returns the number of elements in the list.
     * @return the size of the list
     */
    public int size()
    {
        return listCount;
    }
}
