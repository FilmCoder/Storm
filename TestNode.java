
// -------------------------------------------------------------------------
/**
 *  Testing the heap with this node.
 *
 *  @author domnap
 *  @version Sep 16, 2013
 */
public class TestNode
    implements HeapAwareNode
{

    private int value = 0;
    private int index = 0;

    public TestNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public int compareTo(Object o)
    {
        TestNode node = (TestNode) o;

        if(value > node.value) {
            return 1;
        } else if(value < node.value) {
            return -1;
        } else {
            return 0;
        }
    }

    public void printIdentity() {
        System.out.println("Hi, I'm a TestNode");
    }

    // ---------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Hello, World!");

        TestNode node1 = new TestNode(27);
        TestNode node2 = new TestNode(27);

        System.out.println(node1.compareTo(node2));




    }
}
