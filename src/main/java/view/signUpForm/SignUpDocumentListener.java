package view.signUpForm;

import view.signUpForm.SignUp;

import javax.swing.event.*;

import javax.swing.text.*;

public class SignUpDocumentListener implements DocumentListener {

    SignUp eCommerceSignUpForm;

    public SignUpDocumentListener(SignUp eCommerceSignUpForm) {
        this.eCommerceSignUpForm = eCommerceSignUpForm;
    }

    public void changedUpdate(DocumentEvent e) {
        changed();
    }
    public void removeUpdate(DocumentEvent e) {
        changed();
    }
    public void insertUpdate(DocumentEvent e) {
        changed();
    }

    public void changed() {
        if (eCommerceSignUpForm.firstNameField.getText().equals("") ||
                eCommerceSignUpForm.lastNameField.getText().equals("") ||
                eCommerceSignUpForm.emailField.getText().equals("") ||
                eCommerceSignUpForm.postalField.getText().equals("") ||
                eCommerceSignUpForm.passField.getText().equals("") ||
                eCommerceSignUpForm.confirmPassField.getText().equals("") )

        {
            eCommerceSignUpForm.signUpBtn.setEnabled(false);
        }
        else {
            eCommerceSignUpForm.signUpBtn.setEnabled(true);
        }
    }
}
