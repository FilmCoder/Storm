import java.util.ArrayList;


// -------------------------------------------------------------------------
/**
 *  Represents people who are on the watcher list and want to be notified about
 *  earthquakes.
 *
 *  @author jamied93 domnap
 *  @version Sep 18, 2013
 */
public class Watcher
{

    /**
     * Name of the watcher.
     */
    String name;
    /**
     * Latitude of the watcher.
     */
    int latitude;
    /**
     * Longitude of the watcher.
     */
    int longitude;

    // ----------------------------------------------------------
    /**
     * Create a new Watcher object.
     * @param watcher
     */
    public Watcher(String watcher)
    {
        String[] watcherData = watcher.split(" ");
        int lat, lon;
        name = watcherData[4];
        lat = Integer.parseInt(watcherData[2]);
        latitude = lat;
        lon = Integer.parseInt(watcherData[3]);
        longitude = lon;
    }

    // ----------------------------------------------------------
    /**
     * Getter method for the watcher's name.
     * @return the name of the watcher
     */
    public String getName()
    {
        return name;
    }

    // ----------------------------------------------------------
    /**
     * Getter method for latitude of watcher.
     * @return the watchers' latitude
     */
    public int getLat()
    {
        return latitude;
    }

    // ----------------------------------------------------------
    /**
     * Getter method for longitude of watcher.
     * @return the watcher's longitude
     */
    public int getLon()
    {
        return longitude;
    }
}
