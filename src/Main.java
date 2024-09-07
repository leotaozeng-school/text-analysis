import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    private String userTextInput;
    private String[] words;

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    // User Input: Ask the user to input a paragraph or a lengthy text. Your program should read and store this input.
    public void run() {
        System.out.println("\nWelcome to Text Analysis Tool!");
        System.out.println("Enter a paragraph or a lengthy text:");

        // nextLine() reads a String value from the user
        userTextInput = scanner.nextLine();  // Read user input
        if (userTextInput == null || userTextInput.isEmpty()) {
            throw new IllegalStateException("Please make sure to enter a paragraph or a lengthy text.");
        }

        // Split user input into words
        words = userTextInput.toLowerCase().trim().split("\\s+");

        System.out.println();
        countCharacters();

        System.out.println();
        countWords();
        countUniqueWords();

        System.out.println();
        findMostCommonCharacter(false);
        findMostCommonCharacter(true);

        System.out.println();
        getCharacterFrequency();
        getWordFrequency();

        scanner.close();
    }

    // Character Count: Calculate and display the total number of characters in the input text.
    public void countCharacters() {
        int totalCharacters = userTextInput.length();  // Count characters including spaces
        int totalCharactersWithoutSpaces = userTextInput.replace(" ", "").length();  // Count characters excluding spaces
        System.out.println("Total number of characters (including spaces): " + totalCharacters);
        System.out.println("Total number of characters (excluding spaces): " + totalCharactersWithoutSpaces);
    }

    // Word Count: Calculate and display the total number of words in the input text. Assume that words are separated by spaces.
    public void countWords() {
        int totalWords = 0;

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                totalWords++;
            }
        }

        System.out.println("Total number of words: " + totalWords);
    }

    // Unique Words: Calculate and display the number of unique words in the text (case-insensitive).
    public void countUniqueWords() {
        // Create a new HashSet to store strings
        HashSet<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            // Remove any punctuation from the word
            word = word.replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                uniqueWords.add(word);
            }
        }

        System.out.println("Total number of unique words: " + uniqueWords.size());
    }

    // Most Common Character: Find and display the most common character in the text. In case of a tie, select any of the tied characters.
    public void findMostCommonCharacter(boolean includeSpaces) {
        HashMap<Character, Integer> charFrequency = new HashMap<>();  // Create HashMap to store frequency of every character
        int maxFrequency = 0;  // Frequency counting
        char mostCommonChar = '\0';

        for (int i = 0; i < userTextInput.length(); i++) {
            // Push each character into map and increase its frequency
            char c = userTextInput.charAt(i);
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

    // Character Frequency: Ask the user to input a character. Check and display the frequency of occurrences of this character in the text. Be case-insensitive (e.g., 'a' and 'A' should be considered the same character).
    public void getCharacterFrequency() {
        System.out.print("Enter a character to check its frequency: ");

        char userCharInput = scanner.nextLine().toLowerCase().charAt(0);  // Read user input
        int frequency = 0;

        for (int i = 0; i < userTextInput.length(); i++) {
            char c = userTextInput.toLowerCase().charAt(i);
            if (c == userCharInput) {
                frequency += 1;
            }
        }

        System.out.println("The character '" + userCharInput + "' appears " + frequency + " time(s)");
    }

    // Word Frequency: Ask the user to input a word. Check and display the frequency of occurrences of this word in the text. Be case-insensitive.
    public void getWordFrequency() {
        System.out.print("Enter a word to check its frequency: ");

        String userWordInput = scanner.nextLine().toLowerCase().trim();
        if (!userWordInput.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Invalid word: '" + userWordInput + "'. Words contain only alphabetic characters.");
        }

        int frequency = 0;

        for (String word : words) {
            // Remove any punctuation from the word
            word = word.replaceAll("[^a-zA-Z]", "");
            if (word.equals(userWordInput)) {
                frequency += 1;
            }
        }

        System.out.println("The word '" + userWordInput + "' appears " + frequency + " time(s)");
    }
}

// a character in text can refer to a letter, number, common punctuation marks (such as "." or "-"), and whitespace.