import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class InvestmentCalculator extends JFrame {
    private JTextField amountField;
    private JTextField yearField;
    private JTextField interestRateField;
    private JButton calculateButton;

    public InvestmentCalculator() {
        setTitle("Investment Value Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JPanel buttonPanel = new JPanel();
        JLabel amountLabel = new JLabel("Investment Amount:");
        amountField = new JTextField();

        JLabel yearLabel = new JLabel("Number of Years:");
        yearField = new JTextField();

        JLabel interestRateLabel = new JLabel("Annual Interest Rate (%):");
        interestRateField = new JTextField();

        calculateButton = new JButton("Calculate");

        inputPanel.add(amountLabel);
        inputPanel.add(amountField);
        inputPanel.add(yearLabel);
        inputPanel.add(yearField);
        inputPanel.add(interestRateLabel);
        inputPanel.add(interestRateField);

        buttonPanel.add(calculateButton);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateFutureValue();
            }
        });
        setVisible(true);
    }
    private void calculateFutureValue() {
        double amount = Double.parseDouble(amountField.getText());
        int years = Integer.parseInt(yearField.getText());
        double annualInterestRate = Double.parseDouble(interestRateField.getText());

        // Calculate future value
        double futureValue = amount * Math.pow(1 + (annualInterestRate / 100), years);

        // Format and display the result
        DecimalFormat df = new DecimalFormat("#.##");
        String result = "Future Value: " + df.format(futureValue);
        JOptionPane.showMessageDialog(this, result, "Calculation Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new InvestmentCalculator();
    }
}
