package HomeworkAssignments.HW_1;

import java.util.Scanner;

/**
 * A program to check if a positive integer is also a perfect number
 * Created by almaccrory on 9/4/15.
 */
public class Perfect {
    public static void main(String[] args ){

        /**Recieve an integer from the user*/
        System.out.println("Please enter a positive integer: ");
        Scanner promptRead= new Scanner(System.in);
        int integer= promptRead.nextInt();
        promptRead.close();

        /**Initialize variables that will help check for perfectness*/
        int divisor= 1;
        int zero= 0;
        int sum=0;
        boolean notPerfect= true;


        while (notPerfect){
            /**Check remainder for each divisor*/
            if (integer%divisor == zero){
                sum= sum + divisor;
            }

            /**Re-initialize divisor for next iteration of the loop*/
            divisor++;

            /**End loop if integer is perfect or or equal to the divisor*/
            if (sum == integer || divisor == integer){
                notPerfect= false;
            }
        }

        /**Print the outcome*/
        /**But exclude 1 from perfect numbers*/
        if (sum == integer && sum != 1){
            System.out.println("Congradulations! The integer you've entered is a perfect integer!");
        }
        else{
            System.out.println("Sorry. The integer you've entered is not perfect.");
        }
    }
}

/**
 * Tests that I would run to check the quality of the program:
 * Check input of 6... sum should equal integer
 * Check input of 496... sum should equal integer
 * Check input of 8128... sum should equal integer
 *
 * Check input of 1... should not be perfect
 * Check input of 10... should not be perfect
 * Check input of 10000... should not be perfect
 *
 * Check input of -1... should not be perfect
 * Check input of -6... should not be perfect
 * Check input of -10... should not be perfect
 *
 * Check input of 0... should not be perfect
 */