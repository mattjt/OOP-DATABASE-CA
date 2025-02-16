package expenseDatabase.DTOs;

public class IncomeDTO {
    private int incomeID;
    private String title;
    private double amount;
    private String dateEarned;

    public IncomeDTO(String title, double amount, String dateEarned) {
        this.title = title;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }
    //getters
    public int getIncomeID() {
        return incomeID;
    }
    public String getTitle() {
        return title;
    }
    public double getAmount() {
        return amount;
    }
    public String getDateEarned() {
        return dateEarned;
    }
    //setters
    public void setIncomeID(int incomeID) {
        this.incomeID = incomeID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDateEarned(String dateEarned) {
        this.dateEarned = dateEarned;
    }
}
