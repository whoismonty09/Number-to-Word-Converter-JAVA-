import java.awt.*;
import javax.swing.*;

public class NumberWordConverter extends JFrame {

    JTextField numberField;
    JLabel resultLabel;

    NumberWordConverter() {
        setTitle("Number to Word Converter developed by Monty");
        setSize(500, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Number to Word Converter ");
        title.setFont(new Font("Times New Roman", Font.BOLD, 25));

        numberField = new JTextField(15);
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Enter a number");
        resultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        convertButton.addActionListener(e -> convertNumber());

        add(title);
        add(numberField);
        add(convertButton);
        add(resultLabel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void convertNumber() {
        try {
            int num = Integer.parseInt(numberField.getText());
            resultLabel.setText(convertToWords(num));
        } catch (Exception e) {
            resultLabel.setText("Invalid number!");
        }
    }

    String convertToWords(int num) {
        if (num == 0)
            return "Zero";

        String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"};

        if (num < 20)
            return units[num];

        if (num < 100)
            return tens[num / 10] + " " + units[num % 10];

        if (num < 1000)
            return units[num / 100] + " Hundred " + convertToWords(num % 100);

        if (num < 1000000)
            return convertToWords(num / 1000) + " Thousand " + convertToWords(num % 1000);

        return "Number too large";
    }

    public static void main(String[] args) {
        new NumberWordConverter();
    }
}
