import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class ListSyncher
{

    public static <T extends Identifiable>
    void sync(List<T> dest, List<T> src) { ///TODO: change from List to jamieList

        if(dest.isEmpty()) {
            for(int i = 0; i < src.size(); i++) {
                dest.add(src.get(i));
            }
            return;
        }

        int last_added_id = dest.get(0).getID();

        int i=0;
        //copy from src to dest up until last_added in dest

        T next_elem = src.get(i);

        while(next_elem.getID() != last_added_id) {
            dest.add(i, next_elem);
            i++;

            next_elem = src.get(i);
        }
    }


    public static void main(String[] args)
    {

        //testing purposes
        /*DataStreamGen gen = new DataStreamGen();
        gen.init();



        ArrayList<Integer> dest = new ArrayList<Integer>();
        List recent;

        for(int i = 0; i < 10; i++) {
            recent = gen.getRecent();
            ListSyncher.sync(dest, recent);
            System.out.println("Dest: " + dest.toString());
            System.out.println("Gen: " + recent.toString());
            System.out.println("--------------");
        }*/

    }

}
