package view.signInForm;

import javax.swing.event.*;
import javax.swing.text.*;


import view.signUpForm.SignUp;

public class SignInDocumentListener implements DocumentListener {

    SignIn eCommerceSignInForm;

    public SignInDocumentListener(SignIn eCommerceSignInForm) {
        this.eCommerceSignInForm = eCommerceSignInForm;
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
        if (eCommerceSignInForm.passwordField.getText().equals("") || eCommerceSignInForm.emailField.getText().equals("")){
            eCommerceSignInForm.signIn.setEnabled(false);
        }
        else {
            eCommerceSignInForm.signIn.setEnabled(true);
        }

    }


}
