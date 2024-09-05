import java.util.Scanner;  // Import the Scanner class

public class Main {
    static Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    public static void main(String[] args) {
        Main system = new Main();
        system.run();
    }

    public void run() {
        System.out.println("\nWelcome to the Library!\nHere are the options:");
        System.out.println("Please enter a paragraph or a lengthy text");

        // Get the user's input
        // nextInt() reads a String value from the user
        String userInput = scanner.nextLine();
        System.out.println(userInput);
    }
}