package expenseDatabase.DAOs;

import expenseDatabase.DTOs.ExpenseDTO;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ExpenseDAO{
    public static void listExpenses() {
        String sqlQuery = "SELECT * FROM expenses";
        double totalExpenses = 0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOPCADB","root", "");

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
            System.out.println("Total expenses: €"+totalExpenses);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  static void addExpense(ExpenseDTO expense) {
        String sqlQuery = "INSERT INTO expenses (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOPCADB", "root", "");
             PreparedStatement ps = connection.prepareStatement(sqlQuery)) {

             ps.setString(1,expense.getTitle());
             ps.setString(2,expense.getCategory());
             ps.setDouble(3,expense.getAmount());
             ps.setString(4,expense.getDateIncurred());
             ps.executeUpdate();

             System.out.println("Expense added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteExpense(int expenseID) {//id passed in from user input
        String sqlQuery = "DELETE FROM expenses WHERE expenseID = ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOPCADB", "root", "");
             PreparedStatement ps = connection.prepareStatement(sqlQuery)) {

             ps.setInt(1, expenseID);
             ps.executeUpdate();

             System.out.println("Expense deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void monthExpense(String month) {
        String sqlQuery = "SELECT * FROM expenses WHERE dateIncurred LIKE ?";

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOPCADB", "root", "");
             PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
             ps.setString(1, month + "%");//add the month + remaining date
             ResultSet rs =  ps.executeQuery();

            System.out.println("Month expenses:");
             while (rs.next()) {
                System.out.println(rs.getInt("expenseID")+", "+
                        rs.getString("title")+", "+
                        rs.getString("category")+", €"+
                        rs.getDouble("amount")+", "+
                        rs.getDate("dateIncurred"));

             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double monthTotalExpense(String month) {
        String sqlQuery = "SELECT amount FROM expenses WHERE dateIncurred LIKE ?";
        double total =0;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOPCADB", "root", "");
             PreparedStatement ps = connection.prepareStatement(sqlQuery)) {
            ps.setString(1, month + "%");//add the month + remaining date
            ResultSet rs =  ps.executeQuery();

            while (rs.next()) {
                total += rs.getDouble("amount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}

