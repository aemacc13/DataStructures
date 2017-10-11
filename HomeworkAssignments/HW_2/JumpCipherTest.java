package HomeworkAssignments.HW_2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Yay testing!!!
 * Created by almaccrory on 9/16/15.
 */
public class JumpCipherTest {
    @Test(expected=IllegalArgumentException.class)
    public void message0() {
        JumpCipher cipher = new JumpCipher(-1);//negative key
    }
    @Test(expected=IllegalArgumentException.class)
    public void message1() {
        JumpCipher cipher = new JumpCipher(0);//zero key
    }
    @Test
    public void message2 (){
        JumpCipher cipher= new JumpCipher(2);
        assertEquals("Hloel!", cipher.encrypt("Hello!"));//positive key
    }
    @Test
    public void message3 (){
        JumpCipher cipher= new JumpCipher(2);
        assertEquals("acebd", cipher.encrypt("abcde"));//message that needs padding
    }
    @Test
    public void message02 (){
        JumpCipher cipher= new JumpCipher(2);
        assertEquals("Hello!", cipher.decrypt("Hloel!"));//positive key
    }
    @Test
    public void message03 (){
        JumpCipher cipher= new JumpCipher(3);//key must be the length/original key
        assertEquals("abcde", cipher.decrypt("acebd"));//message that needs padding
    }
}