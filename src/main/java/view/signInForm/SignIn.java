package view.signInForm;


import view.signInForm.SignInDocumentListener;
import db.LoginData;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.event.*;
import javax.swing.text.*;

public class SignIn extends JFrame {

    private LoginData loginPerson;
    private JLabel email;
    public JTextField emailField;
    private JLabel password;
    public JPasswordField passwordField;
    private JComboBox<String> personSwitchCombo;
    public JButton signIn;

    private String title;

    public SignIn() {}

    public SignIn(String title) {
        super(title);


        loginPerson = new LoginData();

        this.email = new JLabel();
        this.password = new JLabel();
        this.personSwitchCombo = new JComboBox<>();
        this.signIn = new JButton();


        signIn.setEnabled(false);
        this.emailField = new JTextField();

        SignInDocumentListener documentHandler = new SignInDocumentListener(this);

        this.emailField.getDocument().addDocumentListener(documentHandler);

        this.passwordField = new JPasswordField();

        this.passwordField.getDocument().addDocumentListener(documentHandler);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.email.setText("email");

        this.password.setText("password");

        this.personSwitchCombo.setModel(new DefaultComboBoxModel<String>(new String[] { "client", "admin" }));

        this.signIn.setText("SignIn");
        this.signIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                signInActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        // horizontal
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(85, 85, 85)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(email, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(password, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addGap(94, 94, 94)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(personSwitchCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(466, 466, 466))
                        .addComponent(signIn, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(140, Short.MAX_VALUE))
                );

        // Vertical
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(144, 144, 144)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(email, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGap(44, 44, 44)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(password, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGap(77, 77, 77)
                    .addComponent(personSwitchCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(signIn, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE))
                );

        this.setVisible(true);
        this.pack();
    }

    private void signInActionPerformed(ActionEvent evt) {

        int result = loginPerson.addPerson(emailField.getText(), passwordField.getText(), personSwitchCombo.getSelectedItem().toString());

        if (result == 1) {
            JOptionPane.showMessageDialog(this, "Person logged in!",
                    "Person login successfully", JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, "unssuccessful login!",
                    "Error", JOptionPane.PLAIN_MESSAGE);

        }

    }

    private void emailFieldActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

    }


}
