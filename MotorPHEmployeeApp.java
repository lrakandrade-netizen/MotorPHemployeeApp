import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MotorPHEmployeeApp extends JFrame implements ActionListener {

    // Labels
    JLabel lblEmployeeNo, lblEmployeeName, lblPayCoverage;

    // Text Fields
    JTextField txtEmployeeNo, txtEmployeeName, txtPayCoverage;

    // Buttons
    JButton btnSubmit, btnClear;

    public MotorPHEmployeeApp() {

        // Frame Title
        setTitle("MotorPH Employee App");

        // Layout
        setLayout(new GridLayout(4, 2, 10, 10));

        // Labels
        lblEmployeeNo = new JLabel("Employee Number:");
        lblEmployeeName = new JLabel("Employee Name:");
        lblPayCoverage = new JLabel("Pay Coverage:");

        // Text Fields
        txtEmployeeNo = new JTextField();
        txtEmployeeName = new JTextField();
        txtPayCoverage = new JTextField();

        // Buttons
        btnSubmit = new JButton("Submit");
        btnClear = new JButton("Clear");

        // Event Handling
        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);

        // Add Components
        add(lblEmployeeNo);
        add(txtEmployeeNo);

        add(lblEmployeeName);
        add(txtEmployeeName);

        add(lblPayCoverage);
        add(txtPayCoverage);

        add(btnSubmit);
        add(btnClear);

        // Frame Settings
        setSize(450, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Submit Button
        if (e.getSource() == btnSubmit) {

            String employeeNo = txtEmployeeNo.getText().trim();
            String employeeName = txtEmployeeName.getText().trim();
            String payCoverage = txtPayCoverage.getText().trim();

            // Validation
            if (employeeNo.isEmpty() ||
                employeeName.isEmpty() ||
                payCoverage.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill in all fields.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            // Validate Employee Number
            try {
                Integer.parseInt(employeeNo);

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Employee Number must be numeric.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            // Success Message
            JOptionPane.showMessageDialog(
                    this,
                    "Employee Information Submitted Successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            // Console Output
            System.out.println("Employee Number: " + employeeNo);
            System.out.println("Employee Name: " + employeeName);
            System.out.println("Pay Coverage: " + payCoverage);
        }

        // Clear Button
        if (e.getSource() == btnClear) {

            txtEmployeeNo.setText("");
            txtEmployeeName.setText("");
            txtPayCoverage.setText("");

            JOptionPane.showMessageDialog(
                    this,
                    "Fields Cleared Successfully.",
                    "Clear",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Main Method
    public static void main(String[] args) {

        new MotorPHEmployeeApp();
    }
}