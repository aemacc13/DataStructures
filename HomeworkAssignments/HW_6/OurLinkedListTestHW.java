package HomeworkAssignments.HW_6;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by almaccrory on 10/15/15.
 */
public class OurLinkedListTestHW {

    @Test
    public void addToEmptyList() {
        OurLinkedListHW list = new OurLinkedListHW();
        list.add(0, "A");
        list.add(1, "C");
        list.add(1, "B");
        assertEquals("[A,B,C,]", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    public void addToEmptyCircularList() {
        CircularDoubleLinkedListHW list = new CircularDoubleLinkedListHW();
        list.add(0, "A");
        list.add(1, "C");
        list.add(1, "B");
        assertEquals("[A,B,C,]", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    public void addToNonEmptyList() {
        //make a list to start with
        OurLinkedListHW list = new OurLinkedListHW();
        list.add("A");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        assertEquals("[A,C,D,E,F,G,]", list.toString());
        assertEquals(6, list.size());
        //add to a specific index
        list.add(1, "B");
        list.add(5, "B");
        assertEquals("[A,B,C,D,E,B,F,G,]", list.toString());
        assertEquals(8, list.size());
        //add to the first index
        list.add(0, "B");
        assertEquals("[B,A,B,C,D,E,B,F,G,]", list.toString());
        assertEquals(9, list.size());
        //remove if at first index
        list.remove("B");
        assertEquals("[A,B,C,D,E,B,F,G,]", list.toString());
        assertEquals(8, list.size());
        //remove if at last index
        list.remove("G");
        assertEquals("[A,B,C,D,E,B,F,]", list.toString());
        assertEquals(7, list.size());
        //remove if elsewhere
        list.remove("C");
        assertEquals("[A,B,D,E,B,F,]", list.toString());
        assertEquals(6, list.size());
    }

    @Test
    public void addToNonEmptyCircularList() {
        //make a list to start with
        CircularDoubleLinkedListHW list= new CircularDoubleLinkedListHW();
        list.add("A");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        assertEquals("[A,C,D,E,F,G,]", list.toString());
        assertEquals(6, list.size());
        //add to a specific index
        list.add(1, "B");
        list.add(5, "B");
        assertEquals("[A,B,C,D,E,B,F,G,]", list.toString());
        assertEquals(8, list.size());
        //add to the first index
        list.add(0, "B");
        assertEquals("[B,A,B,C,D,E,B,F,G,]", list.toString());
        assertEquals(9, list.size());
        //add to second half
        list.add(7, "B");
        assertEquals("[B,A,B,C,D,E,B,B,F,G,]", list.toString());
        assertEquals(10, list.size());
        //add to last index
        list.add(10, "B");
        assertEquals("[B,A,B,C,D,E,B,B,F,G,B,]", list.toString());
        assertEquals(11, list.size());
    }

}