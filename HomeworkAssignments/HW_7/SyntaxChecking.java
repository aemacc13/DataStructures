package HomeworkAssignments.HW_7;

import queues.Queue;
import queues.Stack;

/**
 * Created by almaccrory on 10/29/15.
 */
public class SyntaxChecking {

    /**
     * Solves the Syntax Checking problem.
     * @param openers String containing all the characters that are openers (e.g. "([{")
     * @param closers String containing the corresponding closer characters (e.g. ")]}")
     * @param expression String of arbitrary characters to check for valid syntax
     * @return Whether the openers and closers in the expression are properly matched
     */
    public static boolean isValid(String openers, String closers, String expression) {
        //since we need to compare the last opener with the first closer
        Stack<Character> openStack= new Stack();
        Queue<Character> closeQueue = new Queue();

        for (int i= 0; i < expression.length(); i++){
            //put found openers in a stack
            for (int j= 0; j < openers.length(); j++)
                if (expression.charAt(i) == openers.charAt(j))
                    openStack.push(expression.charAt(i));
            //put found closers in a queue
            for (int j= 0; j < closers.length(); j++)
                if (expression.charAt(i) == closers.charAt(j))
                    closeQueue.enqueue(expression.charAt(i));

        }
        //there were no openers or closers
        if (openStack.empty() && closeQueue.empty())
            return true;
        //there were either openers or closers but not both
        else if ((openStack.empty() && !closeQueue.empty()) || (!openStack.empty() && closeQueue.empty()))
            return false;
        //there were both openers and closers
        else{
            while (!openStack.empty() || !closeQueue.empty()){
                //the last opener in the expression
                Character opener= openStack.pop();
                //the first closer in the expression
                Character closer= closeQueue.dequeue();

                //there were more openers than closers or visa versa
                if ((openStack.empty() && !closeQueue.empty()) || (!openStack.empty() && closeQueue.empty()))
                    return false;
                //the opener does not match the closer
                else if (openers.indexOf(opener) != closers.indexOf(closer))
                    return false;
                //all openers and closers matched
                else if (openStack.empty() && closeQueue.empty())
                    break;
            }
        }return true;
    }

    //------------------------------------------------------------------------------------------------------------------
    //testing
    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args){
        System.out.println(isValid("([{", ")]}", "[{Hello World]}"));//i changed this to check different possibilities
    }
}