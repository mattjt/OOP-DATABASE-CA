package expenseDatabase.BusinessObjects;

import expenseDatabase.DAOs.ExpenseDAO;
import expenseDatabase.DTOs.ExpenseDTO;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        while (cont) {//menu
            System.out.println("(1) List all expenses");
            System.out.println("(2) Add new expense");
            System.out.println("(3) Delete expense");
            System.out.println("(4) List all income");
            System.out.println("(5) Add new income");
            System.out.println("(6) Delete income");
            System.out.println("(7) Summary for a month");
            System.out.println("(8) Exit");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1://list expenses and show total
                    ExpenseDAO.listExpenses();
                    break;
                case 2://add a new expense
                    System.out.println("Enter title:");
                    String title = scan.nextLine();
                    System.out.println("Enter category:");
                    String category = scan.nextLine();
                    System.out.println("Enter amount:");
                    double amount = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Enter date (YYYY-MM-DD):");//maybe change date format
                    String date = scan.nextLine();
                    ExpenseDAO.addExpense(new ExpenseDTO(title, category, amount, date));
                    break;
                case 3://Delete Expense by id
                    System.out.println("Enter expense ID to delete:");
                    int eId = scan.nextInt();
                    ExpenseDAO.deleteExpense(eId);
                    break;
                case 4:
                    //list all income
                    break;
                case 5:
                    //add new income
                    break;
                case 6:
                    //delete income
                    break;
                case 7:
                    //month summary
                    break;
                case 8:
                    System.out.println("Exiting Program");
                    return;
                default:
                    System.out.println("Invalid input, try again please.");

            }
        }
    }
}
