package HomeworkAssignments.HW_5;

import java.util.Comparator;

/**
 * Created by almaccrory on 10/12/15.
 */
public class SortByLengthComparator implements Comparator<String> {
    public int compare(String first, String second){
        int one= first.length();
        int two= second.length();

        if (one < two)
            return -1;
        else if (two < one)
            return 1;
        else
            return 0;


        //return (first.length() - second.length());
    }
}
