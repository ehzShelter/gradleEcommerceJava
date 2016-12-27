/*
   This is the main frame of the client side application
   product selection will be done here
   */
package view.client;
import java.util.Vector;
import view.admin.AdminPanel;
import view.admin.AdminPanelActionListener;
import javax.swing.*;
import controller.*;
import view.signUpForm.SignUp;
import view.signInForm.SignIn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import db.DBDataProvider;

public class MainFrame{
    public JFrame frame;
    private  JComboBox<String> productCombo;
    private JPanel categoryPanel;

    private JPanel productPanel;
    private JTable productTable;

    private JLabel heading;
    private JLabel label;
    private JLabel selected;
    private JButton login;
    private JButton register;
    private JButton adminBtn;

    private JScrollPane sp;

    public MainFrame(){
        this.frame = new JFrame("E-Commerce Desktop Application");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setBounds(300, 100, 750, 500);
        this.frame.setLayout(null);

        //JPanel for product category
        this.categoryPanel = new JPanel();
        this.heading = new JLabel("  Choose any product category from below and start shopping  ",JLabel.CENTER);
        this.label = new JLabel("Product Category: ",JLabel.CENTER);
        this.selected = new JLabel("Selected Category: --  Available Products: -- ",JLabel.CENTER);
        this.productCombo = new JComboBox<String>();
        this.productCombo.setBounds(20,10,700,200);

        //login/signup buttons
        this.login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        this.register = new JButton("Sign Up");
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        //admin panel entry point (for test now)
        this.adminBtn = new JButton("Admin");
        adminBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                adminBtnActionPerformed(evt);
            }
        });

        //add category into combo box
        this.productCombo.addItem(" -- ");
        this.productCombo.addItem("Electronics");
        this.productCombo.addItem("Books");
        this.productCombo.addItem("Cars");
        this.productCombo.addItem("Fashion");
        this.productCombo.addItem("Sports");
        this.productCombo.addItem("Movies");
        this.productCombo.addItem("Music");

        this.categoryPanel.setBounds(150,10,400,100);
        this.categoryPanel.add(this.adminBtn);
        this.categoryPanel.add(this.login);
        this.categoryPanel.add(this.register);
        this.categoryPanel.add(heading);
        this.categoryPanel.add(label);
        this.categoryPanel.add(this.productCombo);
        this.categoryPanel.add(this.selected);

        //show all product data------------------
        this.productPanel = new JPanel();
        this.productPanel.setBounds(10,150,700,300);
        this.productPanel.setLayout(null);

        this.productTable = DBDataProvider.getAllProduct();
        this.sp = new JScrollPane(this.productTable);
        this.sp.setBounds(0, 0, 700, 300);


        // this is important, otherwise selection will not work
        productTable.setCellSelectionEnabled(true);

        ListSelectionModel cellSelectionModel = productTable.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // ListSelectionListener only interface in java Swing to select from a table
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            // https://docs.oracle.com/javase/8/docs/api/javax/swing/event/ListSelectionListener.html#valueChanged-javax.swing.ListSelectionEvent-
            //
            // http://stackoverflow.com/questions/20327005/jtable-actionlistener-for-select-a-row

            public void valueChanged(ListSelectionEvent e) {
                String selectedData = null;

                int[] selectedRow = productTable.getSelectedRows();
                int[] selectedColumns = productTable.getSelectedColumns();

                if (productTable.getSelectedRow() > -1) {
                    // print first column value from selected row

                    selectedData = productTable.getValueAt(productTable.getSelectedRow(), 0).toString();
                    // System.out.println(selectedData);

                    if (selectedData != null) {
                        JOptionPane.showMessageDialog(frame,"cart updated for " + selectedData,
                                "selected product added to cart successfully", JOptionPane.PLAIN_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"unssuccessful cart updated!",
                                "cart not updated", JOptionPane.PLAIN_MESSAGE);

                    }

                }
            }


        });


        JScrollPane sp = new JScrollPane(this.productTable);
        sp.setBounds(0, 0, 700, 300);

        this.productPanel.add(sp);
        this.frame.add(this.categoryPanel);
        this.frame.add(this.productPanel);
        this.frame.setVisible(true);
        this.frame.repaint();

        //registering event handler of the JComboBox + JTable
        CategoryController categoryController = new CategoryController(this.productCombo,this.categoryPanel,this.selected,this.productTable,this.productPanel,this.sp);
        this.productCombo.addActionListener(categoryController);




    }

    private void registerBtnActionPerformed(ActionEvent evt) {
        SignUp sampleSignUp = new SignUp("Sign Up Form");
    }

    private void loginBtnActionPerformed(ActionEvent evt) {
        SignIn sampleSignIn = new SignIn("Sign In Form");
    }

    //method for admin panel entry (for test now)
    private void adminBtnActionPerformed(ActionEvent evt) {
        AdminPanel admin = new AdminPanel();
    }


}
