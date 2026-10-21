import javax.swing.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame implements ActionListener {

    JLabel lblName, lblRoll, lblGender, lblBranch;
    JTextField txtName, txtRoll, txtBranch;
    JRadioButton male, female;
    ButtonGroup genderGroup;
    JCheckBox terms;
    JButton submit, reset;

    public StudentRegistration() {

        setTitle("Student Registration Form");
        setSize(450, 420);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name
        lblName = new JLabel("Student Name");
        lblName.setBounds(30, 30, 120, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(170, 30, 180, 25);
        add(txtName);

        // Roll Number
        lblRoll = new JLabel("Roll Number");
        lblRoll.setBounds(30, 70, 120, 25);
        add(lblRoll);

        txtRoll = new JTextField();
        txtRoll.setBounds(170, 70, 180, 25);
        add(txtRoll);

        // Gender
        lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 110, 120, 25);
        add(lblGender);

        male = new JRadioButton("Male");
        male.setBounds(170, 110, 70, 25);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(250, 110, 80, 25);
        add(female);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        // Branch
        lblBranch = new JLabel("Branch");
        lblBranch.setBounds(30, 150, 120, 25);
        add(lblBranch);

        txtBranch = new JTextField();
        txtBranch.setBounds(170, 150, 180, 25);
        add(txtBranch);

        // Terms
        terms = new JCheckBox("I accept Terms & Conditions");
        terms.setBounds(30, 200, 250, 25);
        add(terms);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(80, 260, 100, 30);
        submit.addActionListener(this);
        add(submit);

        // Reset Button
        reset = new JButton("Reset");
        reset.setBounds(220, 260, 100, 30);
        reset.addActionListener(this);
        add(reset);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {

            if (txtName.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter Student Name");
                return;
            }

            if (txtRoll.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter Roll Number");
                return;
            }

            if (!male.isSelected() && !female.isSelected()) {
                JOptionPane.showMessageDialog(this, "Select Gender");
                return;
            }

            if (txtBranch.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter Branch");
                return;
            }

            if (!terms.isSelected()) {
                JOptionPane.showMessageDialog(this, "Accept Terms & Conditions");
                return;
            }

            String gender = male.isSelected() ? "Male" : "Female";

            JOptionPane.showMessageDialog(this,
                    "Registration Successful\n\n"
                    + "Name : " + txtName.getText()
                    + "\nRoll No : " + txtRoll.getText()
                    + "\nGender : " + gender
                    + "\nBranch : " + txtBranch.getText());
        }

        if (e.getSource() == reset) {
            txtName.setText("");
            txtRoll.setText("");
            txtBranch.setText("");
            genderGroup.clearSelection();
            terms.setSelected(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistration());
    }
}
