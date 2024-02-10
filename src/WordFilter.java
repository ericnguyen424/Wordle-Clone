import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This will create a new file, "five.txt" and sort all of the five letter words into that file
 *
 * @author Eric Nguyen
 * @version Fall 2023
 */
public class WordFilter {
    public static void main(String[] args) {
        String sourceFile = "words.txt";
        String destWord = "five.txt";
        //This try and catch block will scan through every word in the sourceFile file and determine if they are a
        //five-letter word, if they are, it will write the word into destWord
        try (Scanner in = new Scanner(new File(sourceFile));
             PrintWriter out = new PrintWriter(destWord)) {
            while (in.hasNext()) {
                String currentWord = in.next();
                if (currentWord.length() == 5) {
                    out.println(currentWord);

                }
            }
        }
         catch (IOException e) {
            System.out.println("Error!" + e);
        }
    }
}
