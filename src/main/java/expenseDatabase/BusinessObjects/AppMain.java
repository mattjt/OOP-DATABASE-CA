package expenseDatabase.BusinessObjects;

import expenseDatabase.DAOs.ExpenseDAO;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
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
                case 1:
                    ExpenseDAO.listExpenses();
                    break;
                case 2:
                    //add new expense
                    break;
                case 3:
                    //DeleteExpense
                    break;
                case 4:
                    //list all income
                    break;
                case 5:
                    //addnewincome
                    break;
                case 6:
                    //deleteincome
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
