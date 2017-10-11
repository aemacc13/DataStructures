package HomeworkAssignments.HW_5;

import linkedlists.OurLinkedList;

import java.util.Arrays;

/**
 * Our own version of the ArrayList class.
 * Created by almaccraory on 10/12/2015.
 */
public class OurArrayList<E> {

    /** The internal array. Capacity of this list = length of this array. */
    private E[] array;

    /** Number of values currently being stored in this list. */
    private int size;

    /**
     * Creates a list with capacity 10 and size 0.
     */
    public OurArrayList() {
        array = (E[]) new Object[10];
        size = 0;
    }

    /**
     * Return the number of items in this list.
     * @return The list size
     */
    public int size() {
        return size;
    }

    /**
     * Describes this list in string form.
     * @return The internal array converted to a string
     */
    @Override
    public String toString() {
        //hides all of the nulls at the end of the list
        //basically works just like expand but keeps the size rather than size*2
        E[] newArray = (E[]) new Object[size];
        for (int i=0; i < size; i++)
            newArray[i] = array[i];
        array = newArray;
        //returns the list
        return Arrays.toString(array);
    }

    /**
     * Retrieve an item from this list.
     * @param index The index of the item
     * @return The item at that index
     * @throws IndexOutOfBoundsException If index < 0 or index >= size
     */
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return array[index];
    }

    /**
     * Search for an object in this list.
     * @param obj The object to find
     * @return Whether it was found
     */
    public boolean contains(E obj) {
        for (int i=0; i < size; i++)
            if (array[i].equals(obj))
                return true;
        return false;
    }

    /**
     * Append an object to the end of this list, expanding the capacity if necessary.
     * @param obj The object to add
     */
    public void add(E obj) {
        if (size == array.length)
            expand();
        array[size] = obj;
        size++;
    }

    /**
     * Double the capacity of the internal array.
     */
    private void expand() {
        E[] newArray = (E[]) new Object[size*2];
        for (int i=0; i < size; i++)
            newArray[i] = array[i];
        array = newArray;
    }

    /**
     * Adds an object at a specified index in this list, expanding the capacity to make room if necessary.
     * The object that used to be at that index moves over, and so on down the list.
     * @param index The insertion index
     * @param obj The object to add
     * @throws IndexOutOfBoundsException If index < 0 or index > size
     */
    public void add(int index, E obj) {
        //expand the capacity if necessary
        if (size == array.length)
            expand();
        //check for legal index
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        //add the object and shift the list
        for (int i= size; i >= index; i--){
            if (i != index) {
                array[i + 1] = array[i];
            }else{
                array[i + 1] = array[i];
                array[i]= obj;
            }
        }
        size++;
    }

    /**
     * Removes an object from this list. The next object moves back to fill the empty spot, and so on down the list.
     * If the object isn't in this list, nothing happens. If there are duplicates, only the first one gets removed.
     * @param obj The object to remove (or an equivalent one)
     */
    public void remove(E obj) {
        int count= 0;
        //check if obj is in the list
        for (int i= 0; i < size; i++){
            if (array[i].equals(obj)){
                break;
            }
            count++;
        }

        //if obj is in the list than count will be less than size
        if (count < size){
            //adjust the size
            size--;
            //shift the list to remove the obj
            for (int j= count; j < size; j++){
                array[j]= array[j+1];
            }array[size]= null;
        }
        //if its not do nothing
    }
    //***************************************************************************************
    //I adjusted the toString method so that it does not print the "nulls"
    //***************************************************************************************

    /*
    //testing
    public static void main(String[] args) {
        //make a list and add a bunch of stuff
        OurArrayList list= new OurArrayList();
        list.add('a');list.add('b');list.add('b');list.add('c');list.add('e');
        list.add('f');list.add('g');list.add('h');list.add('i');list.add('j');
        System.out.println(list);
        System.out.println(list.size());
        //test the new add and remove methods now
        list.add(0, 'a');list.remove('a');list.remove('b');
        list.add(3, 'd');list.remove('j');
        System.out.println(list);
        System.out.println(list.size());
        //try removing things that are not in the list
        //the last two lists should be the same
        list.remove('k');list.remove(6);list.remove("words");
        System.out.println(list);
        System.out.println(list.size());
    }*/
}