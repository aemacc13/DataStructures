package HomeworkAssignments.HW_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Represents an original text that can be sampled.
 * Created by almaccrory on 11/11/15.
 */
public class Text {

    private Random random= new Random();/** For use throughout */
    private ArrayList<String> words= new ArrayList();/** Sequence of original words */
    private HashMap<String,ArrayList<String>> bi= new HashMap();/** the bigram HashMap */
    private HashMap<String,ArrayList<String>> tri= new HashMap();/** the trigram HashMap */

    /**
     * Reads text from a file and prepares for sampling.
     * @param filename The file to read
     */
    public Text(String filename){
        try{
            Scanner file= new Scanner(new File(filename));

            while (file.hasNext())
                words.add(file.next());
            file.close();

        }catch (FileNotFoundException e){
            System.out.println("Cant find:" + filename);
            System.exit(0);
        }

        // Build your data structures
        //--------------------------------------------------------------------------------------------------------------
        //Kaiden (Kanye) Weaver gave me a hint that I need to check if an ArrayList already exists at a key or not
        //rather than using a nested for loop(which is what I was trying before)
        //--------------------------------------------------------------------------------------------------------------

        //fill the Bigram HashMap
        for (int count= 0; count < words.size()-1; count++){
            //add a value to an existing ArrayList
            if (bi.containsKey(words.get(count)))
                (bi.get(words.get(count))).add(words.get(count+1));
            //create an ArrayList for the new key and add the value to it
            else{
                ArrayList<String> biList= new ArrayList();
                biList.add(words.get(count+1));
                bi.put(words.get(count), biList);
            }
        }
        //fill the Trigram HashMap
        for (int count= 0; count < words.size()-2; count++) {
            //add a value to an existing ArrayList
            if (tri.containsKey(words.get(count)+ " " +words.get(count+1)))
                (tri.get(words.get(count)+ " " +words.get(count+1))).add(words.get(count+2));
            //create an ArrayList for the new key and add the value to it
            else{
                ArrayList<String> triList= new ArrayList();
                triList.add(words.get(count+2));
                tri.put((words.get(count) + " " + words.get(count + 1)), triList);
            }
        }
        //--------------------------------------------------------------------------------------------------------------
    }

    /** @return An iterator that produces an original sample */
    public Iterator<String> originalSampler(){
        return new OriginalSampler();
    }

    /** Nested class defining an iterator that provides original samples. */
    private class OriginalSampler implements Iterator<String> {

        private int index;/** Index of the next word this sampler will return */

        /** Chooses a random index to start at. */
        public OriginalSampler(){
            index= random.nextInt(words.size());
        }

        /** @return Whether this sampler can provide more words */
        public boolean hasNext() {
            return index < words.size();
        }

        /**
         * @return The next word in the sample
         * @throws NoSuchElementException If there are no more words
         */
        public String next() {
            if (!this.hasNext())
                throw new NoSuchElementException();

            index++;
            return words.get(index-1);
        }
    }

    /** @return An iterator that produces a unigram sample */
    public Iterator<String> unigramSampler(){
        return new UnigramSampler();
    }

    /** Nested class defining an iterator that provides unigram samples. */
    private class UnigramSampler implements Iterator<String> {

        /** @return Whether this sampler can provide more words */
        public boolean hasNext() {
            return true;
        }

        /** @return The next word in the sample */
        public String next() {
            int index= random.nextInt(words.size());
            return words.get(index);
        }
    }

    /** @return An iterator that produces a bigram sample */
    public Iterator<String> bigramSampler(){
        return new BigramSampler();
    }

    /** Nested class defining an iterator that provides bigram samples. */
    private class BigramSampler implements Iterator<String> {

        private String mem;/** the word for the next key */
        private int index;/** the index of the random word in a list */
        private int count;/** for keeping track of how to handel the next word */
        private ArrayList<String> list= new ArrayList();/** Sequence of words to pick from */

        /**
         * sets the index of the first word to be random
         * sets the count to zero
         */
        public BigramSampler(){
            index= random.nextInt(words.size());
            mem= words.get(index);
            count= 0;
        }

        /** @return Whether this sampler can provide more words */
        public boolean hasNext() {
            return true;
        }

        /** @return The next word in the sample */
        public String next() {
            if (count == 0) { //return the first word from a completely random index
                count++;
                return mem;
            } else{ //return the rest of the words randomly from a list of words that follow the previous word
                list=(bi.get(mem));
                index= random.nextInt(list.size());
                String word= list.get(index);
                mem= word;
                return word;
            }
        }
    }
    /** @return An iterator that produces a trigram sample */
    public Iterator<String> trigramSampler(){
        return new TrigramSampler();
    }

    /** Nested class defining an iterator that provides trigram samples. */
    private class TrigramSampler implements Iterator<String> {

        private String mem0;/** the first word of the key */
        private String mem1;/** the second word of the key */
        private int index;/** the index of the random word in a list */
        private int count;/** for keeping track of how to handel the next word */
        private ArrayList<String> list= new ArrayList();/** Sequence of words to pick from */

        /**
         * sets the index of the first word to be random
         * sets the count to zero
         */
        public TrigramSampler(){
            index= random.nextInt(words.size());
            mem0= words.get(index);
            count= 0;
        }

        /** @return Whether this sampler can provide more words */
        public boolean hasNext() {
            return true;
        }

        /** @return The next word in the sample */
        public String next() {
            if (count == 0) { //return the first word from a completely random index
                count++;
                return mem0;
            }else if (count == 1){ //return the next word randomly from a list of words that follow the first word
                list=(bi.get(mem0));
                count++;
                index= random.nextInt(list.size());
                String word= list.get(index);
                mem1= word;
                return word;
            }else{ //return the rest of the words randomly from a list of words that follow the two previous words
                list=(tri.get(mem0+ " " +mem1));
                index= random.nextInt(list.size());
                String word= list.get(index);
                mem0= mem1;
                mem1= word;
                return word;
            }
        }
    }

    /** Tests the samplers. */
    public static void main(String[] args){

        Text text= new Text("austen.txt");

        System.out.print("Original Sample: ");
        sample(text.originalSampler());

        System.out.print("Unigram Sample: ");
        sample(text.unigramSampler());

        //bigram
        System.out.print("Bigram Sample: ");
        sample(text.bigramSampler());

        //trigram
        System.out.print("Trigram Sample: ");
        sample(text.trigramSampler());
    }

    /**
     * Prints the next 20 strings from an iterator.
     * @param iter An Iterator over strings.
     */
    private static void sample(Iterator<String> iter){
        for (int i=0; i<20; i++)
            if (iter.hasNext())
                System.out.print(iter.next() + " ");
        System.out.println();System.out.println();
    }
}
