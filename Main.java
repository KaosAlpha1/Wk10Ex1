import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{

    static Map<String, Integer> votes = new HashMap<>();

    public static void main(String[] args) {
        votes.put("Alice", 0);
        votes.put("Bob", 0);
        votes.put("Charlie", 0);

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Voting System");
        System.out.println("Candidates: Alice, Bob, Charlie");

        while (true) {
            System.out.print("\nEnter candidate name to vote (or type 'results', 'reset', or 'exit'): ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) break;
            else if (input.equalsIgnoreCase("results")) displayResults();
            else if (input.equalsIgnoreCase("reset")) resetVotes();
            else castVote(input);
        }

        scanner.close();
    }

    public static void castVote(String candidateName) {
        if (votes.containsKey(candidateName)) {
            votes.put(candidateName, votes.get(candidateName) + 1);
            System.out.println("Vote cast for " + candidateName + ".");
        } else {
            System.out.println("Invalid candidate name.");
        }
    }

    public static void displayResults() {
        System.out.println("\n--- Voting Results ---");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void resetVotes() {
        for (String key : votes.keySet()) {
            votes.put(key, 0);
        }
        System.out.println("All votes have been reset.");
    }
}
