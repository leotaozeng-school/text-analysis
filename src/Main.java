import java.util.Scanner;  // Import the Scanner class

public class Main {
    private String userInput;
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    public static void main(String[] args) {
        Main system = new Main();
        system.run();
    }

    public void run() {
        System.out.println("\nWelcome to use the text analysis tool!");
        System.out.println("Please enter a paragraph or a lengthy text:");

        // nextLine() reads a String value from the user
        userInput = scanner.nextLine();  // Read user input

        countCharacter();
    }

    public void countCharacter() {
        // Count characters including spaces
        int totalCharacters = userInput.length();

        // Count characters excluding spaces
        int totalCharactersWithoutSpaces = userInput.replace(" ", "").length();

        System.out.println("Total number of characters (including spaces): " + totalCharacters);
        System.out.println("Total number of characters (excluding spaces): " + totalCharactersWithoutSpaces);
    }
}