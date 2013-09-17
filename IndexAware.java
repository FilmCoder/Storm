
/**
 *  Ensures that it has an index.  For example, if the object
 *  is in some sort of data structure, it might be useful if that
 *  object knows where it is in that structure.
 *
 *
 *  @author domnap
 *  @version Sep 16, 2013
 */
public interface IndexAware {
    public void setIndex(int index);
    public int getIndex();
}
