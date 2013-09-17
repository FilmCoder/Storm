
public class HeapAware<T extends HeapAwareNode>
{
    private static final int CAPACITY = 1000;
    private T[] array = (T[]) new HeapAwareNode[CAPACITY];
    private int size = 0;

    /**
     * Add a node to the heap
     */
    public void add(T node) {
        //System.out.println("adding");
        array[size] = node;
        node.setIndex(size);

        bubbleUp();
        size++;
    }

    public void remove(int index) {
        T node = array[index];

        //bubble node at index to the root, then pop it off
        while(node.getIndex() != 0) {
            swap(node, getParent(node));
        }

        pop();
    }

    /**
     * When a new node put at the end of the heap, shift it upward
     * until the heap property is achieved.
     */
    private void bubbleUp() {
        bubbleUp(size);
    }

    /**
     * Bubble up a node at a specific index.  (perhaps a node's
     * value has changed within the heap, and the heap property
     * is no longer satisfied.
     *
     * @param index Positon of the node in the array, that needs
     * to possibly be shifted up.
     */
    private void bubbleUp(int index) {
        System.out.println("bubbling up");
        T node = array[index];

        while(isParentLarger(node)) {
            swap(node, getParent(node));
        }
    }

    /**
     * Return the largest element in the heap, but do not remove it.
     */
    public T peek() {
        return array[0];
    }

    /**
     * Return and remove the largest element in the heap.
     */
    public T pop() {
        T root_node = array[0];
        T last_node = array[size - 1];

        swap(root_node, last_node); //replace root node with last node
        size--;

        bubbleDown(); //maintain heap property

        return root_node;
    }

    /**
     * Once an element is removed, swap it downward until it
     * is larger than the elements beneath it.
     */
    private void bubbleDown() {
        System.out.println("bubbling down");

        T node = array[0];

        while(isLessThanChild(node)) {
            swap(node, getLargestChild(node));
        }

        //while()


    }

    /**
     * Return the largest of a node's two children.  If
     * there is only 1 child, then return that child.  If
     * there are no children, return null.
     */
    private T getLargestChild(T node) {
        T left  = getLeftChild(node);
        T right = getRightChild(node);

        if(left == null && right == null) {
            return null;
        } else if(left == null) {
            return right;
        } else if(right == null) {
            return left;
        } else if(left.compareTo(right) > 0) {
            return left;
        } else {
            return right;
        }

    }

    /**
     * Return true if node is smaller than one of its children,
     * false otherwise
     */
    private boolean isLessThanChild(T node) {
        T left  = getLeftChild(node);
        T right = getRightChild(node);

        if(left != null && node.compareTo(left) < 0) {
            return true;
        }

        if(right != null && node.compareTo(right) < 0) {
            return true;
        }

        return false;
    }

    /**
     * Return the left child node, null if node does not have a left child
     */
    private T getLeftChild(T node) {
        int index = 2 * node.getIndex() + 1;

        if(index < size) {
            return array[index];
        } else {
            return null;
        }
    }

    /**
     * Return right child of node, null if node does not have a right child
     */
    private T getRightChild(T node) {
        int index = 2 * node.getIndex() + 2;

        if(index < size) {
            return array[index];
        } else {
            return null;
        }
    }

    ///TODO: delete these function if unused
    /*
    private boolean hasRightChild(T node) {
        return 2 * node.getIndex() + 2 < size;
    }

    private boolean hasLeftChild(T node) {
        System.out.println("2 * " + node.getIndex() + " + 1 < " + size);
        return 2 * node.getIndex() + 1 < size;
    }*/


    /**
     * Swap the positions of two nodes on the heap
     */
    private void swap(T a, T b) {


        System.out.println("----Swapping----");
        System.out.print("a: "); print(a);
        System.out.print("b: "); print(b);

        //swap the node in the heap array
        array[a.getIndex()] = b;
        array[b.getIndex()] = a;

        //update the new indexs of the swapped node objects
        int tmp_index;
        tmp_index = a.getIndex();
        a.setIndex(b.getIndex());
        b.setIndex(tmp_index);

        //print();

    }

    /**
     * True if a node has a parent larger than itself
     */
    private boolean isParentLarger(T node) {

        if(!hasParent(node)) {
            return false;
        }

        T parent = getParent(node);

        return (node.compareTo(parent) == 1);
    }

    /**
     * returns the parent of node
     */
    private T getParent(T node) {
        return array[(node.getIndex() - 1) / 2];
    }

    /**
     * True if node has a parent
     */
    private boolean hasParent(T node) {
        return(node.getIndex() > 0);
    }

    /**
     * print out information about node
     */
    public void print(T node) {
        System.out.println("Value: " + node.getValue() +
            ", Index: " + node.getIndex());
    }

    /**
     * print the values of the heap, from the internal array
     */
    public void print() {
        for(int i=0; i < size; i++) {
            System.out.print(array[i].getValue() + ", ");
        }
        System.out.println();
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param args
     */
    public static void main(String[] args)
    {
        TestNode a = new TestNode(8);
        TestNode b = new TestNode(6);
        TestNode c = new TestNode(20);
        TestNode d = new TestNode(3);
        TestNode e = new TestNode(14);


        HeapAware heap = new HeapAware();

        heap.add(a);
        heap.print();

        heap.add(b);
        heap.print();

        heap.add(c);
        heap.print();

        heap.add(d);
        //heap.add(e);

        heap.print();
        heap.remove(1);
        heap.print();

        System.out.println("Size: " + heap.size);

    }

}
