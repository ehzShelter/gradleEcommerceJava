package db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class LoginData {

    // manages connection
    private PreparedStatement loginPerson;
    public LoginData() {

        try {
            // connection = DBConnectionProvider.getDBConnection();


            Connection conn = DBConnectionProvider.getDBConnection();

            loginPerson = conn.prepareStatement(
                    "INSERT INTO login" +
                    "(email, password, status)" +
                    "VALUES (?, ?, ?)");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


    public int addPerson( String email, String password, String status) {
        int result = 0;
        try {
            loginPerson.setString(1, email);
            loginPerson.setString(2, password);
            loginPerson.setString(3, status);

        result = loginPerson.executeUpdate();
            // insert the new entry, returns # of rows updated
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
