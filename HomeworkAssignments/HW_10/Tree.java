package HomeworkAssignments.HW_10;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by almaccrory on 12/4/15.
 */
public class Tree<E> {

    /** Root data */
    private E data;
    private ArrayList<Tree<E>> children= new ArrayList();

    /**
     * Constructor.
     * @param data Root data
     * @param children Subtrees beneath the root
     */
    public Tree(E data, Tree<E> ... children) {
        this.data= data;
        for (Tree<E> child : children)
            this.children.add(child);
    }

    /** @return The number of children the root of this tree has. */
    public int branches() {
        return children.size();
    }

    /** @return The total number of nodes in this tree. */
    public int size() {
        int sum= 1;
        for (Tree<E> child : children)
            sum+= child.size();
        return sum;
    }

    /** @return The (max) height of this tree. */
    public int height() {
        int max= 1;
        int maximum= 1;
        for (Tree<E> child : children)
            if (children.size() != 0) {
                maximum += child.height();
                if (maximum > max)
                    max= maximum;
                maximum= 1;
            }
        return max;
    }

    /** Fill up the list with all the nodes in this tree, in preorder. */
    public void preorderFill(LinkedList<E> list) {
        list.add(data);
        for (Tree<E> child : children)
            child.preorderFill(list);
    }

    /** Fill up the list with all the nodes in this tree, in postorder. */
    public void postorderFill(LinkedList<E> list) {
        for (Tree<E> child : children)
            child.postorderFill(list);
        list.add(data);
    }

    /** construct a tree */
    /*public static void main(String[] args) {
        //leaves
        Tree<String> D = new Tree("D");Tree<String> E = new Tree("E");
        Tree<String> F = new Tree("F");Tree<String> G = new Tree("G");
        //middle level
        Tree<String> B = new Tree("B", D, E);Tree<String> C = new Tree("C", F, G);
        //root node
        Tree<String> A = new Tree("A", B, C);
        //branch
        System.out.println("branches of A: " + A.branches());//2
        System.out.println("branches of B: " + B.branches());//2
        System.out.println("branches of C: " + C.branches());//2
        //size
        System.out.println("size of A: " + A.size());//8
        //height
        System.out.println("height of A: " + A.height());//3
        //ordering
        LinkedList list= new LinkedList();LinkedList list2= new LinkedList();
        A.preorderFill(list);A.postorderFill(list2);
        System.out.println(list);System.out.println(list2);

        //a non-compact tree
        Tree<Integer> V = new Tree(5);Tree<Integer> W = new Tree(4, V);
        Tree<Integer> X = new Tree(3, W);Tree<Integer> Y = new Tree(2, X);
        Tree<Integer> Z = new Tree(1, Y);
        System.out.println("size of Z: " + Z.size());//5
        System.out.println("height of Z: " + Z.height());//5
    }*/
}