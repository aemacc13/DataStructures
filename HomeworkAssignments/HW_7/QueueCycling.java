package HomeworkAssignments.HW_7;

import queues.Queue;

import java.util.LinkedList;

/**
 * Created by almaccrory on 10/28/15.
 */
public class QueueCycling {

    /**
     * Solves the Queue Cycling problem.
     * @param q Non-empty queue
     * @param k Positive integer
     * @param <E> Type of objects in the queue
     * @throws IllegalArgumentException if k <= 0 or q is empty
     * @return The last item removed when removing every kth item.
     */
    public static <E> E lastItem(Queue<E> q, int k) {
        //check for a valid k
        if (k <= 0)
            throw new IllegalArgumentException();

        //what the answer will be
        LinkedList<E> ans= new LinkedList();

        while (!q.empty()){
            //move non-kth terms to the end
            for (int i= 1; i < k; i++)
                q.enqueue(q.dequeue());
            //clear old answer and add the new one
            ans.clear();
            ans.add(q.dequeue());
        }return ans.getFirst();
    }

    //------------------------------------------------------------------------------------------------------------------
    //testing
    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args){
        Queue<String> q = new Queue();
        q.enqueue("A");q.enqueue("B");q.enqueue("C");
        q.enqueue("D");q.enqueue("E");q.enqueue("F");
        q.enqueue("G");
        //System.out.println(q.dequeue());

        System.out.println(lastItem(q, 2));
    }
}