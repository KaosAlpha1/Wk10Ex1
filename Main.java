import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, Integer> votes = new HashMap<>(); // Create a map to store candidate names and vote counts

    public static void main(String[] args) {
        // Add initial candidates with 0 votes
        votes.put("Alice", 0);
        votes.put("Bob", 0);
        votes.put("Charlie", 0);

        Scanner scanner = new Scanner(System.in); // Scanner to get user input
        String input;

        System.out.println("Voting System");
        System.out.println("Candidates: Alice, Bob, Charlie");

        while (true) {
            // Ask user to vote or perform an action
            System.out.print("\nEnter candidate name to vote (or type 'results', 'reset', or 'exit'): ");
            input = scanner.nextLine().trim(); // Get user input and trim spaces

            // Check input and perform appropriate action
            if (input.equalsIgnoreCase("exit")) break; // Exit loop
            else if (input.equalsIgnoreCase("results")) displayResults(); // Show vote counts
            else if (input.equalsIgnoreCase("reset")) resetVotes(); // Reset all votes
            else castVote(input); // Otherwise try to vote for a candidate
        }

        scanner.close(); // Close scanner
    }

    // Method to cast a vote
    public static void castVote(String candidateName) {
        if (votes.containsKey(candidateName)) {
            votes.put(candidateName, votes.get(candidateName) + 1); // Add 1 vote
            System.out.println("Vote cast for " + candidateName + ".");
        } else {
            System.out.println("Invalid candidate name."); // If name not found
        }
    }

    // Method to display voting results
    public static void displayResults() {
        System.out.println("\n--- Voting Results ---");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes"); // Print each candidate's vote count
        }
    }

    // Method to reset all votes to 0
    public static void resetVotes() {
        for (String key : votes.keySet()) {
            votes.put(key, 0); // Set vote count back to 0
        }
        System.out.println("All votes have been reset.");
    }
}
