import java.io.File;
import java.util.Scanner;

public class testClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String computerWord = "weeds";
        String userWord = null;
        while (computerWord != userWord) {
            userWord = in.next();
            System.out.println(WordleHelper.wordCompare(userWord, computerWord));
        }
    }
}
