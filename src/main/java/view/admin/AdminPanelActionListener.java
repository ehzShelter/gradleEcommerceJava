package view.admin;

import view.client.MainFrame;
import view.admin.AdminPanel;
import javax.swing.event.*;
import javax.swing.text.*;

public class AdminPanelActionListener implements DocumentListener {

    AdminPanel adminPanel;

    public AdminPanelActionListener(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;
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
        if (adminPanel.productNameField.getText().equals("") ||
                adminPanel.productPriceField.getText().equals("") ||
                adminPanel.quantityField.getText().equals(""))
        {
            adminPanel.adminOkBtn.setEnabled(false);
        }
        else {
            adminPanel.adminOkBtn.setEnabled(true);
        }
    }
}
