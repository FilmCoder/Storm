/**
 *  Comparable and has an index.  This is to satisfy the requirements
 *  of the HeapAware.  To maintain the heap property, it needs to be
 *  able to do comparisons, as well as keep the indexes of all the nodes
 *  updated after every node movement.
 *
 *  @author domnap
 *  @version Sep 16, 2013
 * @param <T>
 */
public interface HeapAwareNode<T>
    extends Comparable, IndexAware
{
    ///for testing purposes.
    int getValue();
    void setValue(int value);
}
