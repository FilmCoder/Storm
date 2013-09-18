public class TestHeap
{

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param args
     */
    public static void main(String[] args)
    {
        HeapAware<TestNode> heap = new HeapAware();

        TestNode a = new TestNode(5);
        TestNode b = new TestNode(7);
        TestNode c = new TestNode(3);
        TestNode d = new TestNode(22);

        heap.add(a);
        heap.add(b);
        heap.add(c);
        heap.add(d);

        heap.print();

        heap.peek().printIdentity();

    }

}
