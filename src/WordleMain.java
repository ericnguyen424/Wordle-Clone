import java.util.Scanner;

public class WordleMain {
    private String secretWord;
    private String pathFile;
    private GameState gameState;
    private GUI gui;
    private int guessCount;
    private String userGuess;
    private String generatedWord;
    public WordleMain(String sentPathFile, GameState sentGameState, GUI sentGUI) {
        this.gameState = sentGameState;
        this.gui = sentGUI;
        this.pathFile = sentPathFile;
        this.generatedWord = WordleHelper.randomWordSelection(pathFile);
        this.guessCount = 1;
    }

    /**
     * This function will print the welcome message to the terminal
     */
    public void displayWelcomeMessage() {
        System.out.println("Welcome to my Wordle clone.");
        System.out.println("You have six guesses to guess the secret word.");
        System.out.println("Each guess is scored and printed back to you:");
        System.out.println("  Incorrect letters are replaced with -,");
        System.out.println("  Correctly placed letters are capitalized,");
        System.out.println("  Correct but misplaced letters are lowercase.");
    }

    /**
     * This function will take input from the terminal for the user to type in their guess, validate it, store it,
     * then increment the userGuess by 1.
     * TODO: Change this function so that it listens for key presses to type in their guess, validate this as a string,
     * TODO: store it, then increment the userGuess by 1.
     *
     */
    public void enterUserGuess() {
        String uncheckedGuess;
        //This block of code asks the user for their guess, then it validates it. If the guess is not valid,
        //the guess will not be entered and the terminal will ask the user for their guess again.
        do {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter guess #" + guessCount + ": ");
            uncheckedGuess = in.next();

            if (!WordleHelper.validateGuess(uncheckedGuess, pathFile)) {
                System.out.println("Invalid word, try again");
            }
            in.close();
        } while (!WordleHelper.validateGuess(uncheckedGuess, pathFile));
        //Set the current userGuess to the validated guess, and increment the guessCount by 1.
        setUserGuess(uncheckedGuess);
        addGuessCount(1);

        //close the scanner to save resources

    }

    /**
     * This function acts as an accessor, if the userGuess is equivalent to the computerWord, it will return true.
     * @return
     */
    public boolean getHasWon() {
        if (getUserGuess().toUpperCase().equals(getGeneratedWord().toUpperCase())) {
            System.out.println("You guessed it!");
            return true;
        }
        return false;
    }

    /**
     * Mutator for userGuess
     * @param newUserGuess
     */
    public void setUserGuess(String newUserGuess) {
        this.userGuess = newUserGuess;
    }

    /**
     * Mutator for guessCount
     * @param increment
     */
    public void addGuessCount(int increment) {
        this.guessCount += increment;
    }

    /**
     * Mutator for generatedWord
     * @param newGeneratedWord
     */
    public void setGeneratedWord(String newGeneratedWord) {
        this.generatedWord = newGeneratedWord;
    }

    /**
     * Accessor for guessCount
     * @return
     */
    public int getGuessCount() {
        return this.guessCount;
    }

    /**
     * Accessor for userGuess
     * @return
     */
    public String getUserGuess() {
        return this.userGuess;
    }

    /**
     * Accessor for generatedWord
     * @return
     */
    public String getGeneratedWord() {
        return this.generatedWord;
    }



}
