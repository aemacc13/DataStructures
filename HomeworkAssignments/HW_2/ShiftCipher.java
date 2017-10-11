package HomeworkAssignments.HW_2;

/**
 * A class that implements the Cipher interface and encrypts a message by shifting the alphabet.
 * Created by almaccrory on 9/9/15.
 */
public class ShiftCipher implements Cipher {
    /** The current key (Shift amount). */
    private int key;
    /** The original alphabet. */
    private String alpha= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /** The first substring of the new alphabet. */
    private String partialOne;
    /** The second substring of the new alphabet. */
    private String partialTwo;
    /** The current shifted alphabet. */
    private String newAlpha;

    /** Initializes key to the inputted key. */
    /** Initializes the new alphabet to be shifted by the key. */
    public ShiftCipher(int key){
        this.key= key;
        //Create a new alphabet that is shifted by the key
        if (this.key == 0) {
            newAlpha= alpha;
        } else if (this.key > 0) {
            partialOne = alpha.substring(key);
            partialTwo = alpha.substring(0, (key));
            newAlpha = partialOne + partialTwo;
        } else if (this.key < 0) {
            partialOne = alpha.substring(26 + key);
            partialTwo = alpha.substring(0, (26 + key));
            newAlpha = partialOne + partialTwo;
        }
    }

    /**
     * Overrides the default.
     * @param message A message to be encrypted.
     * @return String newMessage which is the encrypted message.
     */
    @Override
    public String encrypt(String message) {
        String upperCase= message.toUpperCase();
        StringBuilder newMessage= new StringBuilder("");

        //Move through the message
        for (int count= 0; count < upperCase.length(); count++){
            //Find the position of each old message character within the original alphabet
            int upperPosition= alpha.indexOf(upperCase.charAt(count));
            //Tanjona helped me fix an 'index out of range: -1' error
            //by checking for non-alphabet characters
            if (upperPosition < 0) {
                newMessage.append(upperCase.charAt(count));
            }
            //Find the character of that position within the new alphabet
            //then add that character to the new message
            else {
                char newCharacter= newAlpha.charAt(upperPosition);
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
        String upperCase= message.toUpperCase();
        StringBuilder newMessage= new StringBuilder("");

        //Move through the message to decrypt this time
        for (int count= 0; count < upperCase.length(); count++){
            int upperPosition= newAlpha.indexOf(upperCase.charAt(count));
            //Same if statement that Tanjona helped with above
            if (upperPosition < 0) {
                newMessage.append(upperCase.charAt(count));
            }else {
                char newCharacter= alpha.charAt(upperPosition);
                newMessage.append(newCharacter);
            }
        }return newMessage.toString();
    }
}

