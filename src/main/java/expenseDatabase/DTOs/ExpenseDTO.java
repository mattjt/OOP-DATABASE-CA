package expenseDatabase.DTOs;

public class ExpenseDTO {
    private int expenseID;
    private String title;
    private String category;
    private double amount;
    private String dateIncurred;

    public ExpenseDTO(String title, String category, double amount, String dateIncurred) {
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }
    //getters
    public int getExpenseID() {
        return expenseID;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public double getAmount() {
        return amount;
    }
    public String getDateIncurred() {
        return dateIncurred;
    }
    //setters
    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDateIncurred(String dateIncurred) {
        this.dateIncurred = dateIncurred;
    }
}
