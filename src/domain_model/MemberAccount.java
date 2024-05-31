package domain_model;

import java.time.LocalDate;
import java.time.Period;

public class MemberAccount {

    private Member member;
    private double balance;

    public MemberAccount(Member member) {
        this.member = member;
        this.balance = addDues();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double addDues() {
        int age = Period.between(member.getDateOfBirth(), LocalDate.now()).getYears();
        double price = 0.0;

        if (age >= 15 && age < 18) {
            price -= 149;
            } else if (age >= 18 && age < 60) {
                price -= 299;
                } else {
                    price -= 199;
                    }
            return price;
        }

}
