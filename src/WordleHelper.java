import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordleHelper {

    /**
     * Given a filename, will return amount of words in that file
     *
     * @param filename
     * @return int - amount of words
     */
    public static int countWords(String filename) {
        int amount = 0;
        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNext()) {
                amount += 1;
                in.next();
            }
        } catch (IOException e) {
            System.out.println("Error! " + e);
        }
        return amount;

    }

    /**
     * This method returns a copy of the input String, but with the
     * character at the specified position changed to the given letter.
     * Position must be a valid position in the String or the results
     * are undefined.
     * <p>
     * Note that this function does not alter the original String, it
     * just returns a copy with a letter replaced.  Here is an example
     * of how this method can be used.
     * <p>
     * word = replaceLetter(word, 1, 'a');
     * <p>
     * If word originally contained "put", the word would now contain
     * "pat".
     *
     * @param s        any non-empty string
     * @param position a valid position in the string
     * @param letter   a letter to put in the string
     * @return a copy of the original string, with a letter replaced
     */
    public static String replaceLetter(String s, int position, char letter) {
        return s.substring(0, position) + letter + s.substring(position + 1);
    }

    /**
     * This method will make sure that the userInput is a five-letter word that is included in the text file
     * @param userInput
     * @param textFile
     * @return boolean
     */
    public static boolean validateGuess(String userInput, String textFile) {
        userInput = userInput.toLowerCase();
        try (Scanner in = new Scanner(new File(textFile))){
            while (in.hasNext()){
                String currentWord = in.next();
                if (userInput.equals(currentWord)) {
                    return true;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Invalid! " + e);
        }
        return false;
    }
    /**
     * This function will comptue the amount of words in a file
     * @param textFile
     * @return integer
     */
    public static int fileLength(String textFile) {
        int i = 0;
        try (Scanner in = new Scanner(new File(textFile)))
        {
            while (in.hasNext()) {
                i += 1;
                in.next();
            }
        }
        catch (IOException e) {
            System.out.println("Invalid! " + e);
        }
        return i;
    }

    /**
     * This function will randomly choose a word from a given text file
     * @param textFile
     * @return String
     */
    public static String randomWordSelection(String textFile) {
        String randString = null;
        try (Scanner in = new Scanner(new File(textFile)))
        {
                int randIndex = (int) (Math.random() * fileLength(textFile) + 1);
                for (int i = 1; i <= randIndex; i++) {
                    randString = in.next();
                }
            }
        catch (IOException e) {
            System.out.println("Invalid! " + e);
        }
        return randString;
    }

    /**
     * This function, given a userString and a computerString will compare the two. Letters in userString that are in
     * computerString but are in the wrong place will return as a lowercase. Letters that are in the correct place will
     * return as an uppercase. See example:
     * userString - cause
     * computerString - plane
     *
     * returned word: -a--E
     *
     * @param userString
     * @param computerString
     *
     * return String
     */
    public static String wordCompare(String userString, String computerString) {
        userString = userString.toLowerCase();
        computerString = computerString.toLowerCase();
        String returnString = "-----";

        //Check if the letters are matching first, and if they are, skip to the next letter
        //Compare each letter in both words and see if either of them have matching letters
            //for every letter in the userString, iterate through every letter in the computerString
            //If they do, mark with a lowercase in the return string on the index of the userString, and mark
            //computerString with a 0
        for (int i = 0; i < userString.length(); i++) {
            if (userString.charAt(i) == computerString.charAt(i)) {
                returnString = replaceLetter(returnString, i, userString.toUpperCase().charAt(i));
                computerString = replaceLetter(computerString, i, '1');
                continue;
            }
            for (int n = 0; n < computerString.length(); n++) {
                if (userString.charAt(i) == computerString.charAt(n)) {
                    returnString = replaceLetter(returnString, i, userString.charAt(i));
                    computerString = replaceLetter(computerString, n, '0');
                    break;
                }
            }

        }

        return returnString;
    }
}
