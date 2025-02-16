package expenseDatabase.DAOs;

import expenseDatabase.DTOs.IncomeDTO;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class IncomeDAO {
    public static void listIncome() {
        String sqlQuery = "SELECT * FROM income";
        double total = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financeDB","root", "");

             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sqlQuery)) {

            while (rs.next()) {
                System.out.println(rs.getInt("incomeID")+", "+
                        rs.getString("title")+", €"+
                        rs.getDouble("amount")+", "+
                        rs.getString("dateEarned"));
                total += rs.getDouble("amount");
            }
            System.out.println("Total income: €"+total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addIncome(IncomeDTO income) {
        String sqlQuery = "INSERT INTO income (title, amount, dateEarned) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financeDB", "root", "");
             PreparedStatement ps = connection.prepareStatement(sqlQuery)) {

            ps.setString(1, income.getTitle());
            ps.setDouble(2, income.getAmount());
            ps.setString(3, income.getDateEarned());
            ps.executeUpdate();

            System.out.println("Income added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteIncome(int incomeID) {
        String sqlQuery = "DELETE FROM income WHERE incomeID = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financeDB", "root", "");
             PreparedStatement ps = connection.prepareStatement(sqlQuery)) {

             ps.setInt(1, incomeID);
             ps.executeUpdate();

             System.out.println("Income deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
