import static org.junit.Assert.*;
import org.junit.Test;


// -------------------------------------------------------------------------
/**
 *  Tests all methods of Watcher class.
 *
 *  @author jamied93 domnap
 *  @version Sep 18, 2013
 */
public class WatcherTest
{

    /**
     * String to be used to the Watcher class.
     */
    String data = "0 add -75 85 Riley";
    String data2 = "1 add -95 35 Taylor";
    /**
     * Watcher object to be tested.
     */
    Watcher watcher = new Watcher(data);
    Watcher watcher2 = new Watcher(data2);

    // ----------------------------------------------------------
    /**
     * Test getName method.
     */
    @Test
    public void testGetName()
    {
        assertEquals("Riley", watcher.getName());
        assertEquals("Taylor", watcher2.getName());
    }

 // ----------------------------------------------------------
    /**
     * Test getLat method.
     */
    @Test
    public void testGetLat()
    {
        assertEquals(-75, watcher.getLat());
        assertEquals(-95, watcher2.getLat());
    }

 // ----------------------------------------------------------
    /**
     * Test getLon method.
     */
    @Test
    public void testGetLon()
    {
        assertEquals(85, watcher.getLon());
        assertEquals(35, watcher2.getLon());
    }

}
