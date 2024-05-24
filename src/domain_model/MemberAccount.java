package domain_model;

import java.time.Period;

public class MemberAccount {

    private Member member;
    private double balance;

    public MemberAccount(Member member) {
        this.member = member;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void addDues() {


    }

}
