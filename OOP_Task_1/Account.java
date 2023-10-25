
public class Account {
        
    private double amount;

    public Account (double amount) {
        this.amount = amount;
    }
    
    public void add (double amount) {
        amount += amount;

    }
    public void take (double amount) {
        amount -= amount;
    }

    public double getAmount() {
        return amount;
    }
}
