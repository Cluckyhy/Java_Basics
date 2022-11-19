package com.homewoek_.homework06;

public class Homework06 {
    public static void main(String[] args) {
        //CheckingAccount checkingAccount = new CheckingAccount(1000);
        //取款后
        //checkingAccount.deposit(100);
        //checkingAccount.showMoney();
        ////存款后
        //checkingAccount.withdraw(100);
        //checkingAccount.showMoney();


        SavingsAccount savingsAccount = new SavingsAccount(1000);
        //设置默认每月免费的存取框次数
        savingsAccount.setCount(3);
        //设置利率为0.01
        savingsAccount.setRate(0.01);
        //开始取款
        savingsAccount.withdraw(100);
        savingsAccount.showMoney();
        savingsAccount.withdraw(100);
        savingsAccount.showMoney();
        //开始存款
        savingsAccount.deposit(100);
        savingsAccount.showMoney();
        //再次存款
        System.out.println(savingsAccount.getCount());
        savingsAccount.deposit(100);
        savingsAccount.showMoney();
        //月初计算上个月的余额
        savingsAccount.earnMonthlyInterest();
        savingsAccount.showMoney();
        //存款
        savingsAccount.deposit(100);
        savingsAccount.showMoney();

    }

}
