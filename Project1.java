import java.io.FileNotFoundException;
import realtimeweb.earthquakeservice.exceptions.EarthquakeException;
import java.util.ArrayList;
import realtimeweb.earthquakeservice.domain.Report;
import realtimeweb.earthquakeservice.domain.History;
import realtimeweb.earthquakeservice.domain.Threshold;
import java.io.FileInputStream;
import java.io.InputStream;
import realtimeweb.earthquakewatchers.WatcherService;
import realtimeweb.earthquakeservice.regular.EarthquakeService;

// -------------------------------------------------------------------------
/**
 *  Earthquake notification system that contains a list of earthquakes and a
 *  list of "watchers", people who want to be notified of earthquakes in their
 *  area. It prints out when people are added to the list and deleted from the
 *  list. It also notifies watchers of any earthquakes near them. It can, if
 *  need be, notifies all watchers of all earthquakes.
 *
 *  @author jamied93
 *  @author domnap
 *  @version September 15, 2013
 */
public class Project1
{
    /**
     * List of watchers.
     */
    LinkedList watchers = new LinkedList();
    //Queue recordsByTime = new Queue();
    boolean allSwitch = false;
    /**
     * List of earthquakes by magnitude.
     */
    HeapAware<TestNode> recordsByMagnitude = new HeapAware<TestNode>();

    // ----------------------------------------------------------
    /**
     * Calls all methods necessary for program to run.
     * @param args
     * @throws FileNotFoundException exception thrown if no file is found
     * @throws EarthquakeException exception thrown for earthquakes
     * @throws InterruptedException exception thrown in case of interruption
     */
    public static void main(String[] args) throws FileNotFoundException, EarthquakeException, InterruptedException
    {
        // On my honor:
        //
        // - I have not used source code obtained from another student,
        // or any other unauthorized source, either modified or
        // unmodified.
        //
        // - All source code and documentation used in my program is
        // either my original work, or was derived by me from the
        // source code published in the textbook for this course.
        //
        // - I have not discussed coding details about this project with
        // anyone other than my partner (in the case of a joint
        // submission), instructor, ACM/UPE tutors or the TAs assigned
        // to this course. I understand that I may discuss the concepts
        // of this program with other students, and that another student
        // may help me debug my program so long as neither of us writes
        // anything during the discussion or modifies any computer file
        // during the discussion. I have violated neither the spirit nor
        // letter of this restriction.

        //OFFLINE
        // Load the data files
        InputStream normalEarthquakes = new FileInputStream("normal.earthquakes");
        InputStream watcherCommandFile = new FileInputStream("watcher.txt");
        // Connect to the services
        earthquakeService = EarthquakeService.getInstance(normalEarthquakes);
        watcherService = WatcherService.getInstance(watcherCommandFile);
        // Poll the services while there are still commands
        while (watcherService.hasCommands()) {
            ArrayList<String> newCommands = watcherService.getNextCommands();
            // Process commands...
            Report latestEarthquakeData = earthquakeService.getEarthquakes(Threshold.ALL, History.HOUR);
            // Check if there are new Earthquakes and process them...
        }
    }

    // ----------------------------------------------------------
    /**
     * Reads the input and processes the watchers. Adds and deletes watchers.
     * Reports earthquakes to all watchers.
     * @param newCommands
     */
    public void processWatchers(ArrayList<String> newCommands)
    {
        WatcherService watcherService = WatcherService.getInstance();
        String[] commands;
        //check if there are commands
        if(watcherService.hasCommands())
        {
            //parse String
            for (String command: newCommands)
            {
                commands = command.split(" "); //split into an array of the words
                for (int i = 0; i < commands.length; i++)
                {
                    Watcher w = new Watcher(commands[i]);
                    if (commands[i].equals("add")) //if 'add', add to list
                    {
                        watchers.add(w);
                        System.out.print(w.getName() + " was added to the list");
                    }

                    if (commands[i].equals("delete")) //if 'delete' then delete from LinkedList
                    {
                        watchers.remove(i);
                        System.out.print(w.getName() + " was deleted from the list");
                    }

                    if (commands[i].equals("query"))
                    {
                        System.out.print("Magnitude: " +
                            recordsByMagnitude.peek().getValue() + " at "); //magnitude
                                //+ recordsByMagnitude.peek().getLocationDescription());
                    }
                }
            }

        }
    }

    // ----------------------------------------------------------
    /**
     * Prints out any earthquakes that are close to the specified watcher.
     * @param watcher a watcher with potential earthquakes nearby
     */
    public void nearBy(Watcher watcher)
    {
        //"close" = distance < 2 * magnitude^3
        //distance formula = sqrt(a^2 + b^2)
        /**
         * sum = latitude^2 + longitude^2
         */
        double sum = Math.pow(watcher.getLat(),2) + Math.pow(watcher.getLon(), 2);
        /**
         * distance formula, distance = square root (latitude^2 + longitude^2)
         */
        double distance = Math.sqrt(sum);
        for (int i = 0; i < recordsByTime.size(); i++)
        {
            double magnitudeCubed = Math.pow(recordsByTime.get(i).getMagnitude(), 3);
            double magnitude = 2*manitudeCubed;
            if (distance < magnitude)
            {
                System.out.print("Earthquake" +
                    recordsByTime.get(i).getMagnitude() + " of "
                        + recordsByTime.get(i).getLocation()
                            + ", is close to" + watcher.getName());
            }
        }
    }
}
