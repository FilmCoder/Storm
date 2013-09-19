import realtimeweb.earthquakeservice.domain.Earthquake;

/**
 *
 *
 *  @author domnap
 *  @version Sep 18, 2013
 */
public class EarthquakeHeapNode implements HeapAwareNode, Identifiable
{
    public Earthquake quake;
    private String ID = "default";
    private int index = -1;

    /**
     * Creates a new earthquake wrapper element
     * @param quake The source earthquake element
     */
    public EarthquakeHeapNode(Earthquake quake) {
        this.quake = quake;
        ID = quake.getId();
    }


    public int compareTo(Object node)
    {
        double this_mag = quake.getMagnitude();
        double other_mag = ((EarthquakeHeapNode) node).quake.getMagnitude();

        if(this_mag > other_mag) {
            return 1;
        } else if(this_mag < other_mag) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public void setIndex(int index)
    {
        this.index = index;
    }

    @Override
    public int getIndex()
    {
        return index;
    }

    @Override
    public String getID()
    {
        return ID;
    }

    @Override
    public int getValue()
    {
        return 123;
    }

    @Override
    public void setValue(int value)
    {
        //whoah, there is nothing here.
    }

}
