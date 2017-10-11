package HomeworkAssignments.HW_2;

/**
 * A class that implements the Cipher interface and encrypts a message
 * by essentially shuffling (jumping) the letters.
 * Created by almaccrory on 9/9/15.
 */
public class JumpCipher implements Cipher {
    /** The current key (Shift amount). */
    private int key;

    /** Initializes key to the inputted key. */
    public JumpCipher(int key){
        if (key <= 0) {
            throw new IllegalArgumentException("The parameter 'key' can't be negative.");
        }this.key= key;
    }

    /**
     * Overrides the default.
     * @param message A message to be encrypted.
     * @return String newMessage which is the encrypted message.
     */
    @Override
    public String encrypt(String message) {
        StringBuilder newMessage= new StringBuilder("");
        int messageLength= message.length();

        //Taylor helped me with the logic for this if statement
        //It checks the message and 'pads' the message with extra spaces if needed
        if (messageLength%key != 0){
            int i= key;
            while (i >= 0){
                message+= " ";
                i-= 1;
            }
        }
        //Move to the next starting point within the message
        for (int count= 0; count < key; count++){
            //Jump the 'key' amount to the next character
            for (int countAgain=count; countAgain < messageLength; countAgain+= key){
                char newCharacter= message.charAt(countAgain);
                newMessage.append(newCharacter);
            }
        }return newMessage.toString();
    }

    /**
     * Overrides the default.
     * @param message A message to be decrypted.
     * @return String newMessage which is the decrypted message.
     */
    @Override
    public String decrypt(String message) {
        StringBuilder newMessage= new StringBuilder("");
        int messageLength= message.length();

        //Taylor helped me with the logic for this if statement (same as the statement in encrypt)
        //It checks the message and 'pads' the message with extra spaces if needed
        //Just in case there is a new message to be decrypted that hasn't been padded yet
        if (messageLength%key != 0){
            int i= key;
            while (i >= 0){
                message+= " ";
                i-= 1;
            }
        }int newKey= message.length() / key;

        //Move to the next starting point within the message
        for (int count= 0; count < newKey; count++){
            //Jump the 'newkey' amount to the next character
            for (int countAgain=count; countAgain < messageLength; countAgain+= newKey){
                char newCharacter= message.charAt(countAgain);
                newMessage.append(newCharacter);
            }
        }return newMessage.toString();
    }
}
