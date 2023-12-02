package src.OOP_Task1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

//public class DepositAccount extends Account {
//
//    private LocalDateTime dateTime;
//
//    private final int depositPeroidInMonth;
//
//    public DepositAccount(double amount, int depositPeroidInMonth) {
//        super(amount);
//        this.dateTime = LocalDateTime.now();
//        this.depositPeroidInMonth = depositPeroidInMonth;
//    }
//
//    public DepositAccount(double amount) {
//        super(amount);
//        this.dateTime = LocalDateTime.now();
//        this.depositPeroidInMonth = 1;
//    }
//
//    @Override
//    public boolean take(double amount) {
//        return ChronoUnit.MONTHS.between(dateTime, LocalDateTime.now()) < depositPeroidInMonth;
//        // double amount - DepositAccount.take(double)
//        super.take(amount);
////    :false;
//    }
//
//    @Override
//    public void take(double amount) {
//        super.take((LocalDateTime.now() - dateTime) < depositPeroidInMonth);
//        return 0;
//    }
//}
