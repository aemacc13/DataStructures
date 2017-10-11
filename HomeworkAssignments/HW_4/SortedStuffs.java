package HomeworkAssignments.HW_4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Implementing sorting methods
 * Created by almaccrory on 10/4/15.
 */
public class SortedStuffs {
    /**
     * Checks if the integers in an array go in non-decreasing order.
     * @param array An array of integers.
     * @return Whether or not it's sorted.
     */
    public static boolean sorted(int[] array) {
        for (int checkTwo= 1; checkTwo < array.length; checkTwo++){
            int checkOne= checkTwo - 1;
            if(array[checkOne]>array[checkTwo])
                return false;
        }
        return true;
    }
    // sorted
    // n= array.length

    /**
     * Rearranges an array so that all the even numbers come before all the odd numbers.
     * Maintains the order of the evens with respect to each other.
     * Maintains the order of the odds with respect to each other.
     * @param array An array of integers.
     */
    public static void evenOddSort(int[] array) {
        ArrayList<Integer> evens= new ArrayList<Integer>();
        ArrayList<Integer> odds= new ArrayList<Integer>();
        ArrayList<Integer> allValues= new ArrayList<Integer>();
        for (int count= 0; count < array.length; count++) {
            if (isEven(array, count))
                evens.add(array[count]);
            else
                odds.add(array[count]);
        }
        for (int i= 0; i < evens.size(); i++)
            allValues.add(evens.get(i));
        for (int j= 0; j < odds.size(); j++)
            allValues.add(odds.get(j));
        for (int k= 0; k < array.length; k++)
            array[k]= allValues.get(k);
    }
    // evenOddSort
    // n= array.length; m= evens.size; p= odds.size; q= allValues.size

    /**
     * Finds one of the values that appears most often in an array.
     * @param array An array of integers.
     * @return Any of its most common values.
     */
    public static int mostCommon(int[] array) {
        int winner= 0;
        int tallyWinning=0;
        for (int checkOne= 0; checkOne < array.length; checkOne++){
            int tallyOne= 0;
            for (int checkTwo= 0; checkTwo < array.length; checkTwo++) {
                if (array[checkOne] == array[checkTwo])
                    tallyOne++;
            }
            if (tallyOne > tallyWinning){
                tallyWinning= tallyOne;
                winner= array[checkOne];
            }
        }return winner;
    }
    // mostCommon
    // n= array.length

    /**
     * Checks if the characters in a word can be found within any row, column, or diagonal of a 2D character array.
     * @param word The word to search for.
     * @param array A 2D character array.
     * @return Whether the word appears somewhere in the array.
     */
    public static boolean search(String word, char[][] array) {
        if (rowWord(word, array) || columnWord(word, array) || diagonalWord(word, array))
            return true;
        else
            return false;
    }
    // search
    // n= array.length; m= array[row].length; p= word.length()

    /**
     * Checks if value within the array is even or odd.
     * @param array An array of integers.
     * @param i An index of array values.
     * @return True if value is even.
     */
    public static boolean isEven(int[] array, int i){
        if(array[i]%2 == 0)
            return true;
        else
            return false;
    }
    /**
     * Checks if word is found along a row.
     * @param word The word to search for.
     * @param array A 2D character array.
     * @return True if the word appears in a row.
     */
    public static boolean rowWord(String word, char[][] array){
        int index= 0;
        for (int row= 0; row < array.length; row++){
            for (int column= 0; column < array[row].length; column++){
                if (array[row][column] == word.charAt(index)) {
                    index++;
                    if (array[row][column] == word.charAt(word.length() -1))
                        return true;
                }
            }
        }return false;
    }
    /**
     * Checks if word is found along a column.
     * @param word The word to search for.
     * @param array A 2D character array.
     * @return True if the word appears in a column.
     */
    public static boolean columnWord(String word, char[][] array){
        int index= 0;
        int row= 0;
        for (int column= 0; column < array[row].length; column++){
            for (row= 0; row < array.length; row++){
                if (array[row][column] == word.charAt(index)) {
                    index++;
                    if (array[row][column] == word.charAt(word.length() - 1))
                        return true;
                }
            }
        }return false;
    }
    /**
     * Checks if word is found along a diagonal.
     * @param word The word to search for.
     * @param array A 2D character array.
     * @return True if the word appears in a diagonal.
     */
    public static boolean diagonalWord(String word, char[][] array){
        int index= 0;
        int row= 0;
        while (row < array.length){
            if (array[row][row] == word.charAt(index)) {
                index++;
                if (array[row][row] == word.charAt(word.length() - 1))
                    return true;
            }row++;
        }return false;
    }

    //testing
    public static void main(String[] args){
        int[] array= {6,5,4,3,2,1,8,8};
        System.out.println(Arrays.toString(array));
        System.out.println(sorted(array));
        evenOddSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(mostCommon(array));
        int[] array2= {1,2,3,4,5,6,7,8,8};
        System.out.println(sorted(array2));
        //row
        char[][] letters= {{'w','o','r','d'},
                {'a','a','a','a'},
                {'a','a','a','a'},
                {'a','a','a','a'}
        };
        System.out.println(search("word", letters));
        //column
        char[][] letters2= {{'w','a','a','a'},
                {'o','a','a','a'},
                {'r','a','a','a'},
                {'d','a','a','a'}
        };
        System.out.println(search("word", letters2));
        //diagonal
        char[][] letters3= {{'w','a','a','a'},
                {'a','o','a','a'},
                {'a','a','r','a'},
                {'a','a','a','d'}
        };
        System.out.println(search("word", letters3));
    }

}