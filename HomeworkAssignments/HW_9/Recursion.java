package HomeworkAssignments.HW_9;

import java.util.Iterator;

/**
 * Created by almaccrory on 11/17/15.
 */
public class Recursion {
    /**
     * Computes the number of times you can divide n in half before reaching 1.
     * For example, log(8) and log(9) should both return 3.
     * @param n Must be >= 1
     * @return The log (base 2) of n, rounded down
     */
    public static int log(int n) {
        if (n == 1)
            return 0;
        else{
            return 1 + log(n/2);
        }
    }

    /**
     * Constructs a copy of a string with all appearances of a character deleted.
     * For example, delete("abcabcabc", 'b') should return "acacac".
     * @param s Must be non-null
     * @param c The character to delete
     * @return A new string
     */
    public static String delete(String s, char c) {
        if (s.length() == 0)
            return s;
        else if (s.charAt(0) == c)
            return  delete(s.substring(1), c);
        else
            return s.charAt(0) + delete(s.substring(1), c);
    }

    /**
     * Counts the number of times an object is produced by an iterator.
     * @param iter Must be non-null
     * @param obj The object to look for
     * @return How many times an equivalent object appears
     */
    public static int count(Iterator iter, Object obj) {
        if (!iter.hasNext())
            return 0;
        else if (iter.next().equals(obj))
            return 1 + count(iter, obj);
        else
            return count(iter, obj);
    }

    /**
     * Reverses the order of the elements in the array.
     * @param array Must be non-null
     */
    public static void reverse(Object[] array) {
        reverse(array, 1);
    }

    public static void reverse(Object[] array, int index){
        if (array.length >= 2 && index <= array.length/2){
            Object temp = array[array.length - index];
            array[array.length - index]= array[index-1];
            array[index-1]= temp;
            reverse(array, index + 1);
        }
    }
}
