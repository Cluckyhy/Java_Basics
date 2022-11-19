package com.homewoek_.homework06;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(double balance) {
        super(balance);
    }

    //重写父类的存款方法

    @Override
    public void deposit(double amount) {
        //每次存款都要收取1块钱的手续费
        setBalance(getBalance() + amount - 1);
    }

    //重写父类的取款方法

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance() + amount - 1);
    }
}
