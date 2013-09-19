import static org.junit.Assert.*;
import org.junit.Test;


// -------------------------------------------------------------------------
/**
 *  Tests all methods in Node class.
 *
 *  @author jamied93 domnap
 *  @version Sep 18, 2013
 */
public class NodeTest
{

    /**
     * String needed to make a node.
     */
    String minnie = "minnie";
    String daisy = "daisy";
    /**
     * Node needed to test Node class.
     */
    Node node = new Node(minnie);
    Node node2 = new Node(daisy);

    // ----------------------------------------------------------
    /**
     * Tests getData.
     */
    @Test
    public void testGetData()
    {
        assertEquals("minnie", node.getData());
    }

    // ----------------------------------------------------------
    /**
     * Tests setData.
     */
    @Test
    public void testSetData()
    {
        node.setData("clara");
        assertEquals("clara", node.getData());
    }

    // ----------------------------------------------------------
    /**
     * Tests getNext.
     */
    @Test
    public void testGetNext()
    {
        assertNull(node.getNext());
    }

 // ----------------------------------------------------------
    /**
     * Tests setNext.
     */
    @Test
    public void testSetNext()
    {
        node.setNext(node2);
        assertEquals(node2, node.getNext());
    }

}
