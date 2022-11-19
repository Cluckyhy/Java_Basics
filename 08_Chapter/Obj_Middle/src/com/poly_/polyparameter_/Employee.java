package com.poly_.polyparameter_;

public class Employee {
    private String name;
    private double m_salary;

    public Employee(String name, double m_salary) {
        this.name = name;
        this.m_salary = m_salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getM_salary() {
        return m_salary;
    }

    public void setM_salary(double m_salary) {
        this.m_salary = m_salary;
    }

    public void gerAnnual() {
        System.out.println("每年的工资为：" + m_salary * 12);
    }
}
