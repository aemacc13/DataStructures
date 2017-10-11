package HomeworkAssignments.HW_6;

/**
 * Created by almaccrory on 10/14/15.
 */
public class OurLinkedListHW<E> {

    /** Number of objects in this list. */
    private int size;

    /** Reference to the first node. */
    private Node<E> head;

    /** Reference to the last node. */
    private Node<E> tail;

    /**
     * Return the number of objects in this list.
     * @return The list size
     */
    public int size() {
        return size;
    }

    /**
     * Adds an object to the end of this list.
     * @param obj The object to add
     */
    public void add(E obj) {

        // To an empty list
        if (tail == null) {
            tail = new Node(obj);
            head = tail;
        }

        // To a non-empty list
        else {
            tail.next = new Node(obj);
            tail = tail.next;
        }

        size++;
    }

    /**
     * Describes this list in string form.
     * @return A string like [x,y,z,...]
     */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            result.append(current.data+",");
            current = current.next;
        }
        return result.toString()+"]";
    }

    /**
     * Search for an object in this list.
     * @param obj The object to find
     * @return Whether it was found
     */
    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(obj))
                return true;
            else
                current = current.next;
        }
        return false;
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

        Node<E> current = head;
        for (int i=0; i < index; i++)
            current = current.next;

        return current.data;
    }

    /**
     * Adds an object at a specified index in this list.
     * @param index The insertion index
     * @param obj The object to add
     * @throws IndexOutOfBoundsException If index < 0 or index > size
     */
    public void add(int index, E obj) {
        //the current node and the new node
        Node<E> current = head;
        Node<E> newNode= new Node(obj);

        //check for legal index
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        //add to the last valid index
        //or add to the first valid index IF THE LIST IS EMPTY
        else if (index == size)
            add(obj);

        //add to the first valid index OF A NON EMPTY LIST
        else if (index == 0){
            newNode.next= current;
            head= newNode;
            size++;
        }

        //add anywhere else in the list
        else{
            //find the desired index and put the new node there
            for (int i= 0; i < index; i++)
                current = current.next;
            //make the new node point to the next index
            newNode.next= current;

            //reset current
            current= head;

            //find the index before the desired one
            for (int i= 0; i < index-1; i++)
                current = current.next;
            //make it point to the new node
            current.next= newNode;

            //adjust the size
            size++;
        }
    }

    /**
     * Removes an object from this list. If the object isn't in this list, nothing happens.
     * If there are duplicates, only the first one gets removed.
     * @param obj The object to remove (or an equivalent one)
     */
    public void remove(E obj) {
        //the current node and the node after
        Node<E> current = head;
        int count= 0;
        //check if obj is in the list
        while (current != null) {
            //if it is then move on
            if (current.data.equals(obj))
                break;
            //if it's not then check the next and add to the count
            current = current.next;
            count++;
        }
        //if the obj was the first one
        if (count == 0){
            current = head;
            head= current.next;
            size--;
        }
        //if the obj was somewhere else in the list
        else if (count < size){
            current = head;
            //point the index before to the index after
            for (int i= 0; i < count-1; i++)
                current = current.next;
            current.next= current.next.next;
            //adjust the size
            size--;
        }//if obj is in the list than count will be less than size
    }

    /**
     * Represents a node in this list. (Nested class for internal use only.)
     * @param <E> The data type of list contents
     */
    private static class Node<E> {

        /** Contents of this node. */
        private E data;

        /** Reference to the node after this one in the list. */
        private Node<E> next;

        /**
         * Create a node with next = null.
         * @param data Contents for this node
         */
        public Node(E data) {
            this.data = data;
        }
    }
}