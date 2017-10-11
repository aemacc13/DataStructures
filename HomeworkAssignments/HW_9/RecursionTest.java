package HomeworkAssignments.HW_9;

import org.junit.Test;

import java.util.ArrayList;
import java.util.ListIterator;

import static HomeworkAssignments.HW_9.Recursion.*;
import static org.junit.Assert.*;

/**
 * Created by almaccrory on 11/17/15.
 */
public class RecursionTest {
    @Test
    public void logs (){
        assertEquals(0, log(1));
        assertEquals(1, log(2));
        assertEquals(2, log(4));
        assertEquals(3, log(8));
        assertEquals(3, log(9));
        assertEquals(4, log(18));
    }

    @Test
    public void delets (){
        assertEquals("acacac" ,delete("abcabcabc", 'b'));
    }

    @Test
    public void counts (){
        ArrayList<String> list= new ArrayList();
        list.add("a");list.add("b");list.add("b");list.add("b");list.add("a");
        list.add("a");list.add("b");list.add("b");list.add("b");list.add("a");
        ListIterator<String> iter = list.listIterator();
        assertEquals(0, count(iter, "c"));
        System.out.println(list);
        //assertEquals(4, count(iter, "a")); //these work independently but not if multiple run?
        //assertEquals(6, count(iter, "b"));
    }

    @Test
    public void reverses (){
        Object[] arrays= {1, 2};
        System.out.print(arrays[0]);System.out.print(arrays[1]);
        reverse(arrays);System.out.println();
        System.out.print(arrays[0]);System.out.print(arrays[1]);
        System.out.println();

        Object[] array= {1, 2, 3, 4, 5, 6, 7};
        System.out.print(array[0]);System.out.print(array[1]);System.out.print(array[2]);
        System.out.print(array[3]);System.out.print(array[4]);System.out.print(array[5]);System.out.print(array[6]);
        reverse(array);System.out.println();
        System.out.print(array[0]);System.out.print(array[1]);System.out.print(array[2]);
        System.out.print(array[3]);System.out.print(array[4]);System.out.print(array[5]);System.out.print(array[6]);
    }

}