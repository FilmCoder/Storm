import static org.junit.Assert.*;
import org.junit.Test;


// -------------------------------------------------------------------------
/**
 *  Tests all methods in LinkedList class.
 *
 *  @author jamied93 domnap
 *  @version Sep 18, 2013
 */
public class LinkedListTest
{
    /**
     * List to be used for testing.
     */
    LinkedList list = new LinkedList();
    /**
     * String needed for testing.
     */
    String mickey = "mickey";
    String donald = "donald";
    String goofy = "goofy";

    // ----------------------------------------------------------
    /**
     * Tests the method that adds an object to end of list.
     */
    @Test
    public void testAdd()
    {
        list.add(mickey);
        assertEquals("mickey", list.get(1));
    }

    // ----------------------------------------------------------
    /**
     * Tests the method that adds an object to a specified index.
     */
    @Test
    public void testAddAtIndex()
    {
        list.add(mickey);
        list.add(donald);
        list.add(goofy, 2);
        assertEquals("goofy", list.get(2));

    }

    // ----------------------------------------------------------
    /**
     * Tests method that gets object from specified index.
     */
    @Test
    public void testGet()
    {
        list.add(goofy);
        list.add(donald);
        assertEquals(donald, list.get(2));
    }

    // ----------------------------------------------------------
    /**
     * Tests the getter method for size.
     */
    @Test
    public void testSize()
    {
        assertEquals(0, list.size());
    }

    // ----------------------------------------------------------
    /**
     * Tests the method that removes object from list.
     */
    @Test
    public void testRemove()
    {
        list.add(donald);
        list.add(mickey);
        list.add(goofy);
        assertTrue(list.remove(2));
    }

}
