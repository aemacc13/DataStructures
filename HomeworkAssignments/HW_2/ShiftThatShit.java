package HomeworkAssignments.HW_2;

import java.util.InputMismatchException;

/**
 * Created by almaccrory on 9/16/15.
 */
public class ShiftThatShit implements Cipher {
    /** The current key (Shift amount). */
    private int key;
    /** The current alphabet. */
    private String alpha= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /** The first substring of the new alphabet. */
    private String partialOne;
    /** The second substring of the new alphabet. */
    private String partialTwo;
    /** The current shifted alphabet. */
    private String newAlpha;

    /** Initializes key to the inputted key. */
    public ShiftThatShit(int key){
        this.key= key;
    }

    /** Initializes the new alphabet to be shifted by the key. */
    public String shiftAlpha() {
        try {
            if (key == 0) {
                System.out.println("A key of zero will not shift your message. " +
                        "Your key must be a positive or negative integer.");
                System.exit(0);
            } else if (key > 0) {
                partialOne = alpha.substring(key);
                partialTwo = alpha.substring(0, (key));
                newAlpha = partialOne + partialTwo;
            } else if (key < 0) {
                partialOne = alpha.substring(26 + key);
                partialTwo = alpha.substring(0, (26 + key));
                newAlpha = partialOne + partialTwo;
            }
        } catch (InputMismatchException exception) {
            System.out.println("Your key must be a positive or negative integer.");
            System.exit(0);
        }return newAlpha;
    }
    @Override
    public String encrypt(String message) {
        String newAlpha= shiftAlpha();
        String upperCase= message.toUpperCase();
        StringBuilder newMessage= new StringBuilder("");
        for (int count= 0; count < upperCase.length(); count++){
            int upperPosition= alpha.indexOf(upperCase.charAt(count)); // upperPosition= 7 = h
            if (upperPosition < 0) {
                newMessage.append(upperCase.charAt(count));
            }else {
                char newCharacter= newAlpha.charAt(upperPosition); //newCharacter = j... if key is 2
                System.out.println(newCharacter);
                newMessage.append(newCharacter);
            }
            System.out.println(newMessage);
        }return newMessage.toString();
    }

    @Override
    public String decrypt(String message) {
        String upperCase= message.toUpperCase();
        StringBuilder newMessage= new StringBuilder("");
        for (int count= 0; count < upperCase.length(); count++){
            int upperPosition= newAlpha.indexOf(upperCase.charAt(count)); // upperPosition= 7 = h
            if (upperPosition < 0) {
                newMessage.append(upperCase.charAt(count));
            }else {
                char newCharacter= alpha.charAt(upperPosition); //newCharacter = j... if key is 2
                System.out.println(newCharacter);
                newMessage.append(newCharacter);
            }
            System.out.println(newMessage);
        }return newMessage.toString().toLowerCase();
    }
}
//everything works but it wont actually return to the console//---------------------------------------------------------