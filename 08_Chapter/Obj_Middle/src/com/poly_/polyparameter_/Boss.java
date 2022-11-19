package com.poly_.polyparameter_;

public class Boss extends Employee {
    private double bonus;

    public Boss(String name, double m_salary, double bonus) {
        super(name, m_salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println("经理正在管理工作！");
    }

    @Override
    public void gerAnnual() {
        System.out.println("经理每年的工资为：" + (getM_salary() * 12 + bonus));
    }
}
