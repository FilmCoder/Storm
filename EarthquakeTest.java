import java.util.LinkedList;
import java.io.IOException;
import realtimeweb.earthquakeservice.exceptions.EarthquakeException;
import realtimeweb.earthquakeservice.domain.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import realtimeweb.earthquakeservice.regular.EarthquakeService;


public class EarthquakeTest
{
    static InputStream normalEarthquakes = null;
    static EarthquakeService service;
    static Report report;
    static ListSyncher syncher;

    static LinkedList<EarthquakeHeapNode> quakeList = new LinkedList();

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        //start getting data from earthquakes
        init();
        System.out.println(report);
    }

    static private void init() {
        //get earthquake data
        try {
            File inFile = new File("normal.earthquakes.json");
            normalEarthquakes = new FileInputStream(inFile);
        } catch (FileNotFoundException e) {
            System.out.println("Failed to create earthquake file stream!");
        }

        // start earthquake service
        try
        {
            service = EarthquakeService.getInstance(normalEarthquakes);
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }

        updateReport();

    }

    static void updateReport() {
        // get earthquake data
        try {
            report = service.getEarthquakes(Threshold.ALL, History.HOUR);
        } catch (EarthquakeException e) {
            e.printStackTrace();
        }
    }

    static void addNewQuakes() {
        updateReport();

    }




}
