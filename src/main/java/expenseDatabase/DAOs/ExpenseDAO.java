package expenseDatabase.DAOs;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ExpenseDAO{
    public static void listExpenses() {
        String sqlQuery = "SELECT * FROM expenses";
        double totalExpenses = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financeDB","root", "");
             Statement statement = connection.createStatement();

             ResultSet rs = statement.executeQuery(sqlQuery)) {
             while (rs.next()) {
                System.out.println(rs.getInt("expenseID")+", "+
                        rs.getString("title")+", "+
                        rs.getString("category")+", €"+
                        rs.getDouble("amount")+", "+
                        rs.getDate("dateIncurred"));
                totalExpenses += rs.getDouble("amount");
             }
            System.out.println("Total expenses: "+totalExpenses);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
