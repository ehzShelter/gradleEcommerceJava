package db;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class ProductData {

    // manages connection
    private PreparedStatement insertNewProduct;

    public ProductData() {

        try {
            Connection conn = DBConnectionProvider.getDBConnection();
            insertNewProduct = conn.prepareStatement(
                "INSERT INTO product " +
                "(name, category, price, quantity)" +
                "VALUES (?, ?, ?, ?)");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int addProduct(String name, String category, double price, int quantity) {
        int result = 0;
        try {
            insertNewProduct.setString(1, name);
            insertNewProduct.setString(2, category);
            insertNewProduct.setDouble(3, price);
            insertNewProduct.setInt(4, quantity);
            result = insertNewProduct.executeUpdate();

            //update category items count here
            int total_items = DBDataProvider.getCategoryItem(category);
            total_items++;

            Connection connection = DBConnectionProvider.getDBConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE category SET category.total_items = ? WHERE category.name = ?");
            statement.setInt(1, total_items);
            statement.setString(2, category);
            int res = statement.executeUpdate();
            

        // insert the new entry, returns # of rows updated
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
