package controller;
import java.awt.event.*;
import javax.swing.*;
import db.DBDataProvider;

public class CategoryController implements ActionListener {
    JComboBox<String> categoryGUI;
    JPanel categoryPanel;
    JLabel selected;
    JTable productTable;
    JPanel productPanel;
    JScrollPane sp;

    public CategoryController(JComboBox<String> categoryGUI,JPanel categoryPanel,JLabel selected,JTable productTable,JPanel productPanel,JScrollPane sp){
        this.categoryGUI = categoryGUI;
        this.categoryPanel = categoryPanel;
        this.selected = selected;
        this.productTable = productTable;
        this.productPanel = productPanel;
        this.sp = sp;
    }

    public void actionPerformed(ActionEvent e){

        String selectedCategory = (String)this.categoryGUI.getSelectedItem();
        int total_items = DBDataProvider.getCategoryItem(selectedCategory);

        //updating product table
        this.productTable = DBDataProvider.getSpecificProduct(selectedCategory);
        this.productPanel.remove(this.productTable);

        this.sp = new JScrollPane(this.productTable);
        this.sp.setBounds(0, 0, 700, 300);
        this.sp.repaint();
        this.sp.revalidate();

        this.productPanel.add(sp);

        this.productTable.repaint();

        this.selected.setText("Selected Category: " + selectedCategory + "  Available Products: " + total_items);
        this.categoryPanel.revalidate();
        this.categoryPanel.repaint();

        this.productPanel.revalidate();
        this.productPanel.repaint();


    }
}
