import javax.swing.*;
import java.awt.event.*;

public class ATM_GUI {
    private static int balance = 10000;
    private static int pin = 1234;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple ATM");

        JLabel pinLabel = new JLabel("Enter PIN:");
        pinLabel.setBounds(30, 30, 80, 25);
        JTextField pinField = new JPasswordField();
        pinField.setBounds(120, 30, 100, 25);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(90, 70, 80, 25);

        JLabel msgLabel = new JLabel("");
        msgLabel.setBounds(30, 110, 300, 25);

        frame.add(pinLabel);
        frame.add(pinField);
        frame.add(loginBtn);
        frame.add(msgLabel);

        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int enteredPin = Integer.parseInt(pinField.getText());
                if (enteredPin == pin) {
                    frame.dispose();
                    showATMMenu();
                } else {
                    msgLabel.setText("Incorrect PIN. Try again.");
                }
            }
        });
    }

    static void showATMMenu() {
        JFrame frame = new JFrame("ATM Menu");

        JButton checkBtn = new JButton("Check Balance");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton exitBtn = new JButton("Exit");

        JLabel msgLabel = new JLabel("Welcome! Choose an action.");
        msgLabel.setBounds(30, 20, 250, 25);

        checkBtn.setBounds(50, 60, 150, 25);
        depositBtn.setBounds(50, 100, 150, 25);
        withdrawBtn.setBounds(50, 140, 150, 25);
        exitBtn.setBounds(50, 180, 150, 25);

        frame.add(msgLabel);
        frame.add(checkBtn);
        frame.add(depositBtn);
        frame.add(withdrawBtn);
        frame.add(exitBtn);

        frame.setSize(280, 280);
        frame.setLayout(null);
        frame.setVisible(true);

        checkBtn.addActionListener(e -> msgLabel.setText("Balance: ₹" + balance));

        depositBtn.addActionListener(e -> {
            String amt = JOptionPane.showInputDialog("Enter amount to deposit:");
            balance += Integer.parseInt(amt);
            msgLabel.setText("Deposited ₹" + amt);
        });

        withdrawBtn.addActionListener(e -> {
            String amt = JOptionPane.showInputDialog("Enter amount to withdraw:");
            int w = Integer.parseInt(amt);
            if (w <= balance) {
                balance -= w;
                msgLabel.setText("Withdrawn ₹" + amt);
            } else {
                msgLabel.setText("Insufficient balance!");
            }
        });

        exitBtn.addActionListener(e -> {
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Thanks for using Simple ATM");
        });
    }
}