//package HomeworkAssignments.HW_2;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// * Yay testing!!!
// * Created by almaccrory on 9/16/15.
// */
//public class ShiftCipherTest {
//    @Test
//    public void message0 (){
//        ShiftCipher cipher= new ShiftCipher(2);
//        assertEquals("JGNNQ", cipher.encrypt("Hello"));//alphabet only characters
//    }
//    @Test
//    public void message1 (){
//        ShiftCipher cipher= new ShiftCipher(2);
//        assertEquals("JGNNQ YQTNF!", cipher.encrypt("Hello World!"));//with non-alphabet characters
//    }
//    @Test
//    public void message2 (){
//        ShiftCipher cipher= new ShiftCipher(0);
//        assertEquals("ABCD", cipher.encrypt("abcd"));//key of zero
//    }
//    @Test
//    public void message3 (){
//        ShiftCipher cipher= new ShiftCipher(-2);
//        assertEquals("YZAB", cipher.encrypt("abcd"));//negative key
//    }
//    @Test
//    public void message00 (){
//        ShiftCipher cipher= new ShiftCipher(2);
//        assertEquals("HELLO", cipher.decrypt("JGNNQ"));//alphabet only characters
//    }
//    @Test
//    public void message01 () {
//        ShiftCipher cipher = new ShiftCipher(2);
//        assertEquals("HELLO WORLD!", cipher.decrypt("JGNNQ YQTNF!"));//with non-alphabet characters
//    }
//    @Test
//    public void message02 (){
//        ShiftCipher cipher= new ShiftCipher(0);
//        assertEquals("ABCD", cipher.decrypt("ABCD"));//key of zero
//    }
//    @Test
//    public void message03 (){
//        ShiftCipher cipher= new ShiftCipher(-2);
//        assertEquals("ABCD", cipher.decrypt("YZAB"));//negative key
//    }
//}