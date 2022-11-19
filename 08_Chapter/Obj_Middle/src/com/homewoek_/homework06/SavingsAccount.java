package com.homewoek_.homework06;

public class SavingsAccount extends BankAccount{
    private int count;
    private double rate;

    public SavingsAccount(double balance) {
        super(balance);
    }

    //扩展一个类方法
    public void earnMonthlyInterest(){
        this.count = 3;
        setBalance(getBalance()*(1+this.rate));
    }

    //重写父类中存款方法
    @Override
    public void deposit(double amount) {
        if(count<=0){
            setBalance(getBalance() + amount -1);
        }
        super.deposit(amount);
        count--;
    }

    //重写父类的取框方法


    @Override
    public void withdraw(double amount) {
        if(count<=0){
            setBalance(getBalance() + amount -1);
        }
        super.withdraw(amount);
        count--;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
