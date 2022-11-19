package com.poly_.polyparameter_;

public class Worker extends Employee {

    public Worker(String name, double m_salary) {
        super(name, m_salary);
    }

    public void work() {
        System.out.println("普通员工正在工作！");
    }

    @Override
    public void gerAnnual() {
        System.out.println("我每年的工资为：" + getM_salary() * 12);
    }
}
