package db;

import model.User;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class UserData {

    // manages connection
    private PreparedStatement insertNewPerson;
    public UserData() {

        try {
            // connection = DBConnectionProvider.getDBConnection();

            Connection conn = DBConnectionProvider.getDBConnection();
            insertNewPerson = conn.prepareStatement(
                    "INSERT INTO user " +
                    "(firstname, lastname, email, country, postal_code, password, status)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


    public int addPerson(String firstname, String lastname, String email, String country, String postal_code, String password, String status) {
        int result = 0;
        try {
            insertNewPerson.setString(1, firstname);
            insertNewPerson.setString(2, lastname);
            insertNewPerson.setString(3, email);
            insertNewPerson.setString(4, country);
            insertNewPerson.setString(5, postal_code);
            insertNewPerson.setString(6, password);
            insertNewPerson.setString(7, status);

	    result = insertNewPerson.executeUpdate();

            // insert the new entry, returns # of rows updated
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
