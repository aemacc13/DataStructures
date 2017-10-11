package HomeworkAssignments.HW_6;

/**
 * Created by almaccrory on 10/14/15.
 */
public class CircularDoubleLinkedListHW<E> {

    /** Number of objects in this list. */
    private int size;

    /** Reference to the first node. */
    private Node<E> head;

    /**
     * Return the number of items in this list.
     * @return The list size
     */
    public int size() {
        return size;
    }


    public void add(E obj) {

        // To an empty list
        if (head == null) {
            head = new Node(obj);
            head.next = head;
            head.previous = head;
        }

        // To a non-empty list
        else {
            Node<E> tail = new Node(obj);
            tail.next = head;
            tail.previous = head.previous;
            head.previous.next = tail;
            head.previous = tail;
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
        for (int i=0; i < size; i++) {
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
        for (int i=0; i < size; i++) {
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

        // Forwards
        if (index < size/2) {
            for (int i = 0; i < index; i++)
                current = current.next;
        }

        // Backwards
        else {
            for (int i = 0; i < size-index; i++)
                current = current.previous;
        }

        return current.data;
    }

    /**
     * Adds an object at a specified index in this list.
     * @param index The insertion index
     * @param obj The object to add
     * @throws IndexOutOfBoundsException If index < 0 or index > size
     */
    public void add(int index, E obj){
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
            //set new node pointers
            newNode.next= current;
            newNode.previous= current.previous;
            //adjust the current pointers to point to the new node
            current.previous.next=newNode;
            current.previous= newNode;
            //set the head to the new node
            head= newNode;
            //adjust the size
            size++;
        }

        //add anywhere else in the list
        else{
            // Forwards
            if (index < size/2) {
                for (int i = 0; i < index-1; i++)
                    current = current.next;
                newNode.next= current.next;
                current.next= newNode;

                //reset current
                current= head;

                for (int i = 0; i < index; i++)
                    current = current.next;
                newNode.previous= current.previous;
                current.previous= newNode;
            }

            // Backwards
            else {
                for (int i = 0; i < size-index; i++)
                    current = current.previous;

                newNode.next= current.next.previous;
                current.previous.next= newNode;

                newNode.previous= current.previous;
                current.previous= newNode;
            }size++;
        }
    }

    /**
     * Remove an object from this list. If it's not there, nothing happens.
     * If there are duplicates, only the first one gets removed.
     * @param obj The object to remove
     */
    public void remove(E obj) {

        Node<E> current = head;
        for (int i=0; i < size; i++) {
            if (current.data.equals(obj))
                break;
            else
                current = current.next;
        }

        // Data isn't there
        if (current == head && !current.data.equals(obj))
            return;

            // Removing the head
        else if (current == head) {

            // Removing the last item
        }

        // Removing any other item
        else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }

        size--;
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

        /** Reference to the node before this one in the list. */
        private Node<E> previous;

        /**
         * Create a node with next = null and previous = null.
         * @param data Contents for this node
         */
        public Node(E data) {
            this.data = data;
        }
    }
}
