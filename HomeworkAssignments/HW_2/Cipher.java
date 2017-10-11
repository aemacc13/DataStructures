package HomeworkAssignments.HW_2;

/**
 * Created by almaccrory on 9/9/15.
 */
public interface Cipher {
    /**
     * Disguises a message according to the implementing object's encryption algorithm.
     * @param message The original string
     * @return The encrypted message
     */
    public String encrypt(String message);

    /**
     * Reveals a message that was disguised according to the implementing object's encryption algorithm.
     * @param message The encrypted string
     * @return The original message
     */
    public String decrypt(String message);
}
