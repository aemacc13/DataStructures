package HomeworkAssignments.HW_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A program that request a file and a line width, then changes the line width of that file to the requested length.
 * Created by almaccrory on 9/6/15.
 */
public class Format {
    public static void main(String[] args ) throws FileNotFoundException {

        /** Request a file from the user */
        System.out.println("What file would you like to open? ");
        Scanner promptRead= new Scanner(System.in);
        String fileToOpen= promptRead.nextLine();

        /** Mutable string object */
        StringBuilder text= new StringBuilder();

        /** Move every line from the file into the mutable string obect */
        Scanner file= new Scanner(new File(fileToOpen));
        while (file.hasNextLine()){
            String line= file.nextLine();
            text.append(line);
        }
        file.close();

        /** Ask to change the file */
        System.out.println("Would you like to change the line width? ");
        String confirmChange= promptRead.nextLine();
        /** Proceed with changing the file */
        if (confirmChange.equals("yes") || confirmChange.equals("Yes") || confirmChange.equals("YES")){
            /** Request a new line width */
            System.out.println("Enter new line width: ");
            int width= promptRead.nextInt();
            if (width == 0){
                System.out.println("Please enter a new non-zero line width: ");
                width = promptRead.nextInt();
            }

            /** File out */
            PrintWriter file_out= new PrintWriter(new File(fileToOpen));
            int count= 0;
            /** Print back to the file with the new line width */
            while ((count + width) <= text.length()){
                file_out.println(text.substring(count, count + width));
                count= count + width;
            }
            /** Print whatever charecters where left over back to the file */
            file_out.println(text.substring(count));

            /** Close everything */
            file_out.close();
            promptRead.close();
        }else{
            promptRead.close();

        }

    }
}

/**
 * Tests that I would run to check the quality of the program:
 * Check when requsted width is longer than the total number of characters
 * Check if width requested is zero
 * Check a width in between zero and total number of characters
 * Check so that each line has the same exact width
 * Check so that the last line is shorter
 * check yes
 * check no... no and anything other than yes will end the program without error
 * check file that has no length
 *
 */

