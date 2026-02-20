package com.security;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private JTextField nameInput;
    private JTextField amountInput;
    private JLabel statusResult;

    public Main() {
        setTitle("Fraud Detector v1.0");
        setSize(350, 450); // Made it slightly taller
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Using a 6-row grid so everything has its own space
        setLayout(new GridLayout(6, 1, 5, 5));

        // 1. Name Input
        add(new JLabel("  Enter Username:"));
        nameInput = new JTextField();
        add(nameInput);

        // 2. Amount Input
        add(new JLabel("  Enter Transaction Amount ($):"));
        amountInput = new JTextField();
        add(amountInput);

        // 3. The Button - Now with clear text so it's not an "empty row"
        JButton checkButton = new JButton("CLICK TO RUN AUDIT");
        checkButton.setFont(new Font("Arial", Font.BOLD, 14));
        add(checkButton);

        // 4. The Result Label
        statusResult = new JLabel("System Ready", SwingConstants.CENTER);
        statusResult.setOpaque(true);
        statusResult.setBackground(Color.WHITE);
        add(statusResult);

        // Logic
        checkButton.addActionListener(e -> runFraudCheck());

        setVisible(true);
    }

    private void runFraudCheck() {
        String name = nameInput.getText().trim();
        String amountText = amountInput.getText().trim();

        // FIX: Specifically handling empty rows
        if (name.isEmpty() || amountText.isEmpty()) {
            statusResult.setText("ERROR: Input fields cannot be empty!");
            statusResult.setBackground(Color.ORANGE);
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);

            if (name.toLowerCase().contains("hacker") || amount > 50000) {
                statusResult.setText("RESULT: REJECTED (High Risk)");
                statusResult.setBackground(new Color(255, 200, 200)); // Light Red
            } else {
                statusResult.setText("RESULT: AUTHORIZED (Safe)");
                statusResult.setBackground(new Color(200, 255, 200)); // Light Green
            }

        } catch (NumberFormatException error) {
            statusResult.setText("ERROR: Amount must be a number!");
            statusResult.setBackground(Color.YELLOW);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
// cd /Users/shanu/Downloads/Proj3/fraud-detector && mvn compile exec:java -Dexec.mainClass="com.security.Main"