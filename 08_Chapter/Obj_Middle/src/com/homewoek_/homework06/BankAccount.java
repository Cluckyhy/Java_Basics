package com.homewoek_.homework06;

public class BankAccount {
    private double balance;     //余额

    public BankAccount(double balance) {
        this.balance = balance;
    }

    //存款
    public void deposit(double amount) {
        balance += amount;
    }

    //取款
    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void showMoney() {
        System.out.println("当前账户余额为：" + balance);
    }
}
