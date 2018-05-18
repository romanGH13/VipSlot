package com.example.roma.vipslots;

/**
 * Created by Roma on 18.05.2018.
 */

public class User {
    private int balance;
    private boolean firstLine;
    private boolean secondLine;
    private boolean thirdLine;
    private int bet;

    public User()
    {
        this.balance = 1000;
        this.firstLine = true;
        this.secondLine = true;
        this.thirdLine = true;
        this.bet = 5;
    }

    public User getFromFile()
    {

        return new User();
    }

    public void addCoints(int amount)
    {
        if(amount<=0)
            return;
        this.balance += amount;
    }
    public void dismissCoints(int amount)
    {
        if(amount<=0)
            return;
        this.balance -= amount;
    }

    public int getLines()
    {
        int count = 0;
        if(isFirstLine()) count++;
        if(isSecondLine()) count++;
        if(isThirdLine()) count++;
        return count;
    }


    public int getBalance() {
        return balance;
    }

    public boolean isFirstLine() {
        return firstLine;
    }

    public void setFirstLine(boolean firstLine) {
        this.firstLine = firstLine;
    }

    public boolean isSecondLine() {
        return secondLine;
    }

    public void setSecondLine(boolean secondLine) {
        this.secondLine = secondLine;
    }

    public boolean isThirdLine() {
        return thirdLine;
    }

    public void setThirdLine(boolean thirdLine) {
        this.thirdLine = thirdLine;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}
