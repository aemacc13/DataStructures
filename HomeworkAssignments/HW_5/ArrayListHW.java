package HomeworkAssignments.HW_5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by almaccrory on 10/12/15.
 */
public class ArrayListHW {
    /**
     * Removes duplicate objects from a list, maintaining the order of the remaining objects.
     * A duplicate is an object that is equivalent to another object that appeared earlier in the list.
     * @param list An ArrayList of any type
     */
    public static void deduplicate(ArrayList list) {
        for (int i= 0; i < list.size(); i++){
            for (int j= 0; j < list.size(); j++){
                if (i != j) {
                    if (list.get(i) == list.get(j))
                        list.remove(j);
                }
            }
        }
    }

    /**
     * Arranges the strings in a list in order from shortest to longest.
     * @param list An ArrayList of Strings.
     */
    public static void sortByLength(ArrayList<String> list) {
        Collections.sort(list, new SortByLengthComparator());
    }

    /*
    //testing
    public static void main(String[] args){
        //test sortByLength
        ArrayList<String> schools= new ArrayList();
        schools.add("St. Lawrence University");
        schools.add("Clarkson University");
        schools.add("SUNY Canton");
        schools.add("SUNY Potsdam");
        //sort normally
        Collections.sort(schools);
        System.out.println(schools);
        //our sort by length
        Collections.sort(schools, new SortByLengthComparator());
        System.out.println(schools);

        //test deDuplicate
        ArrayList<Integer> list= new ArrayList();
        list.add(1);list.add(2);list.add(2);list.add(2);list.add(3);
        list.add(4);list.add(5);list.add(6);list.add(2);list.add(7);
        System.out.println(list);
        //deDuplicate
        deduplicate(list);
        System.out.println(list);
    }*/
}
