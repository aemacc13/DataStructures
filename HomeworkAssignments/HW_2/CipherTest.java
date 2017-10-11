package HomeworkAssignments.HW_2;

/**
 * Created by almaccrory on 9/16/15.
 */
public class CipherTest {
    public static void main(String[] args){
        Cipher cipher = new ShiftCipher(2); // Creates a shift cipher with a key of 2
        System.out.println(cipher.encrypt("Hello world!")); // Returns "JGNNQ YQTNF!"
        System.out.println(cipher.decrypt("JGNNQ YQTNF!"));

        Cipher cipherTwo = new JumpCipher(2); // Creates a jump cipher with a key of 2
        System.out.println(cipherTwo.encrypt("Hello!")); // Returns "Hloel!"
        System.out.println(cipherTwo.decrypt("Hloel!"));
    }
}
