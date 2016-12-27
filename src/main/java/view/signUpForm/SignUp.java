package view.signUpForm;

import view.signUpForm.SignUpDocumentListener;
import db.UserData;

import javax.swing.JFrame;
import javax.swing.*;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {
    private String signUpFormTitle;

    private UserData newPerson;

    public JPasswordField confirmPassField;
    private JLabel confirmPassword;
    private JLabel country;
    private JComboBox<String> countryNameCombo;
    private JLabel email;
    public JTextField emailField;
    private JLabel firstName;
    public JTextField firstNameField;
    private JLabel lastName;
    public JTextField lastNameField;
    public JPasswordField passField;
    private JLabel password;
    private JLabel postalCode;
    public JTextField postalField;
    public JButton signUpBtn;
    private JComboBox<String> toggleOne;

    public SignUp() {}

    public SignUp(String signUpFormTitle) {
        super("SignUp Form");

        newPerson = new UserData();

        this.firstName = new JLabel();
        this.lastName = new JLabel();
        this.email = new JLabel();
        this.country = new JLabel();
        this.postalCode = new JLabel();
        this.password = new JLabel();
        this.confirmPassword = new JLabel();
        this.signUpBtn = new JButton();

        this.firstNameField = new JTextField();
        this.lastNameField = new javax.swing.JTextField();
        this.emailField = new javax.swing.JTextField();
        this.postalField = new javax.swing.JTextField();
        this.passField = new javax.swing.JPasswordField();
        this.confirmPassField = new javax.swing.JPasswordField();
        this.countryNameCombo = new JComboBox<String>();
        this.toggleOne = new JComboBox<String>();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        firstName.setText("First Name");

        lastName.setText("Last Name");

        email.setText("Email");

        country.setText("Country");

        postalCode.setText("Postal Code");

        password.setText("Password");

        confirmPassword.setText("Confirm Password");

        signUpBtn.setEnabled(false);

        signUpBtn.setText("SignUp");
        signUpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });


        confirmPassField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                confirmPassFieldActionPerformed(evt);
            }
        });

        countryNameCombo.setModel(new DefaultComboBoxModel<String>(new String[] { "Bangladesh", "India", "UK", "USA" }));

        toggleOne.setModel(new DefaultComboBoxModel<String>(new String[] { "Client", "Admin" }));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);


        SignUpDocumentListener documentHandler = new SignUpDocumentListener(this);


        this.firstNameField.getDocument().addDocumentListener(documentHandler);
        this.lastNameField.getDocument().addDocumentListener(documentHandler);
        this.emailField.getDocument().addDocumentListener(documentHandler);
        this.postalField.getDocument().addDocumentListener(documentHandler);
        this.passField.getDocument().addDocumentListener(documentHandler);
        this.confirmPassField.getDocument().addDocumentListener(documentHandler);

        // horizontal
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(confirmPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(firstName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lastName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(email, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(country, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(postalCode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(password, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(toggleOne, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(106, 106, 106)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(postalField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(confirmPassField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                .addComponent(countryNameCombo, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(123, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(signUpBtn, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72))))
                            );
        // vertical
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(firstName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lastName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(email, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(country, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addComponent(countryNameCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addComponent(postalCode, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addComponent(postalField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(password, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(confirmPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmPassField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(signUpBtn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addComponent(toggleOne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27))
                    );
        this.setVisible(true);
        pack();

    }


    private void signUpBtnActionPerformed(ActionEvent evt) {
        int result = newPerson.addPerson(firstNameField.getText(), lastNameField.getText(), emailField.getText(), countryNameCombo.getSelectedItem().toString(), postalField.getText(), passField.getText(), toggleOne.getSelectedItem().toString());

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Person added!",
                    "Person added", JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, "Person not added!",
                    "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void confirmPassFieldActionPerformed(ActionEvent evt) {
        // TODO handling code here:
    }

}
