import java.util.Scanner;  // Import the Scanner class
import java.util.HashMap;

public class Main {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    private String userInput;

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    public void run() {
        System.out.println("\nWelcome to Text Analysis Tool!");
        System.out.println("Please enter a paragraph or a lengthy text:");

        // nextLine() reads a String value from the user
        userInput = scanner.nextLine();  // Read user input

        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalStateException("Please make sure to enter a paragraph or a lengthy text");
        }

        countCharacters();
        countWords();
        findMostCommonCharacter(false);
        findMostCommonCharacter(true);
    }

    public void countCharacters() {
        int totalCharacters = userInput.length();  // Count characters including spaces
        int totalCharactersWithoutSpaces = userInput.replace(" ", "").length();  // Count characters excluding spaces
        System.out.println("Total number of characters (including spaces): " + totalCharacters);
        System.out.println("Total number of characters (excluding spaces): " + totalCharactersWithoutSpaces);
    }

    public void countWords() {
        String[] words = userInput.trim().split("\\s+");
        System.out.println("Total number of words: " + words.length);
    }

    public void findMostCommonCharacter(boolean includeSpaces) {
        HashMap<Character, Integer> charFrequency = new HashMap<>();  // Create HashMap to store frequency of every character
        int maxFrequency = 0;  // The frequency counting
        char mostCommonChar = '\0';

        for (int i = 0; i < userInput.length(); i++) {
            // Push each character into map and increase its frequency
            char c = userInput.charAt(i);

            if (includeSpaces || !Character.isWhitespace(c)) {
                charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);

                if(charFrequency.get(c) > maxFrequency) {
                    maxFrequency = charFrequency.get(c);
                    mostCommonChar = c;
                }
            }
        }

        System.out.println("The most common character " + (includeSpaces ? "(including spaces): " : "(excluding spaces): ") + "'" + mostCommonChar + "'");
    }
}