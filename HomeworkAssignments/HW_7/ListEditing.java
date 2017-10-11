package HomeworkAssignments.HW_7;

import queues.Stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by almaccrory on 10/28/15.
 */
public class ListEditing {

    /**
     * Deletes all appearances of an object.
     * @param obj The object to remove
     * @param list The list to remove from
     * @param <E> The type of objects in the list
     */
    public static <E> void delete(E obj, LinkedList<E> list) {

        LinkedList<E> newList= new LinkedList();
        //the object to be removed
        HashSet set= new HashSet();
        set.add(obj);

        while (!list.isEmpty()){
            //if the last obj is not in the set, add to the new list
            if (!set.contains(list.getLast()))
                newList.add(list.getLast());
            //remove from the old list
            list.removeLast();
        }

        //move everything back to the old list
        while (!newList.isEmpty()){
            list.add(newList.getLast());
            newList.removeLast();
        }
    }

    /**
     * Replaces all appearances of one object with another.
     * @param source The old object
     * @param target The new object
     * @param list The list to replace in
     * @param <E> The type of objects in the list
     */
    public static <E> void replace(E source, E target, LinkedList<E> list) {

        LinkedList<E> newList= new LinkedList();
        //the old object to be replaced throughout the list
        HashSet set= new HashSet();
        set.add(source);

        while (!list.isEmpty()){
            //if the last obj is not in the set, add to the new list
            if (!set.contains(list.getLast()))
                newList.add(list.getLast());
            //if the last obj is in the set, add the new object in its place
            else
                newList.add(target);
            //remove from the old list
            list.removeLast();
        }

        //move everything back to the old list
        while (!newList.isEmpty()){
            list.add(newList.getLast());
            newList.removeLast();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    //testing
    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args){
        LinkedList<String> pie= new LinkedList();
        pie.add("A");pie.add("B");pie.add("C");
        pie.add("D");pie.add("A");pie.add("E");
        pie.add("F");pie.add("G");pie.add("A");
        System.out.println(pie);

        replace("A", "X", pie);
        System.out.println(pie);

        delete("X", pie);
        System.out.println(pie);
    }

}
