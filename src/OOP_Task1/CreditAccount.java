package src.OOP_Task1;


public class CreditAccount extends Account {
    public CreditAccount (double amount) {
        super(amount);
    }

    @Override
    public void take(double amount) {
        super.take(amount + (amount*0.01));
    }
}
