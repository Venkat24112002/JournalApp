package net.engineeringdigest.journalApp.Splitwise;

import java.util.*;

public class SplitwiseFile {
    // balances.get(A).get(B) means A owes B this much money
    private final Map<String, Map<String, Double>> balances = new HashMap<>();

    /**
     * Add an expense.
     * @param paidBy         User who paid
     * @param amount         Total amount paid
     * @param participants   List of users who shared the expense (including paidBy)
     */
    public void addExpense(String paidBy, double amount, List<String> participants) {
        int n = participants.size();
        if (n == 0) return;
        double share = amount / n;
        for (String user : participants) {
            if (user.equals(paidBy)) continue; // user doesn't owe to themself
            // user owes paidBy
            balances.putIfAbsent(user, new HashMap<>());
            Map<String, Double> userMap = balances.get(user);
            userMap.put(paidBy, userMap.getOrDefault(paidBy, 0.0) + share);

            // paidBy is owed. (for easier netting out - not strictly needed for showBalances)
            balances.putIfAbsent(paidBy, new HashMap<>());
            Map<String, Double> paidMap = balances.get(paidBy);
            paidMap.put(user, paidMap.getOrDefault(user, 0.0) - share);
        }
    }

    /** Shows all non-zero balances (who owes whom) */
    public void showBalances() {
        boolean noBalances = true;
        for (String from : balances.keySet()) {
            Map<String, Double> map = balances.get(from);
            for (String to : map.keySet()) {
                double amount = map.get(to);
                if (amount > 0.009) { // ignore tiny numbers due to rounding
                    System.out.printf("%s owes %s: $%.2f\n", from, to, amount);
                    noBalances = false;
                }
            }
        }
        if (noBalances) {
            System.out.println("No balances. Everyone is settled up!");
        }
    }

    // --- Demo Driver ---
    public static void main(String[] args) {
        SplitwiseFile app = new SplitwiseFile();

        List<String> users = Arrays.asList("Alice", "Bob", "Cathy", "David");

        // Alice paid $120 for Alice, Bob, Cathy, David (Dinner)
        app.addExpense("Alice", 120, users);

        // Bob paid $80 for Bob, Cathy (Taxi)
        app.addExpense("Bob", 80, Arrays.asList("Bob", "Cathy"));

        // Cathy paid $150 for Alice, Cathy (Tickets)
        app.addExpense("Cathy", 150, Arrays.asList("Alice", "Cathy"));

        app.showBalances();

        // Add another expense to test
        System.out.println("--- After David pays $100 for all ---");
        app.addExpense("David", 100, users);

        app.showBalances();
    }
}
