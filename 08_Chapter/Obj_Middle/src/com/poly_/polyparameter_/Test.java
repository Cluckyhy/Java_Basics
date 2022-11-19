package com.poly_.polyparameter_;

import com.coderchy.modifier.B;

public class Test {
    public static void main(String[] args) {
        //实例化一个普通员工对象
        Worker worker = new Worker("小明",3000);
        //实例化一个经理对象
        Boss boss = new Boss("小红",12000,40000);
        //调用showEmpAnnual方法，查看员工的每年的工资
        Test t1 = new Test();
        t1.showEmpAnnual(worker);
        t1.showEmpAnnual(boss);
        t1.testWork(worker);
        t1.testWork(boss);
    }
    public void showEmpAnnual(Employee e){
        e.gerAnnual();
    }
    public void testWork(Employee e){
        if(e instanceof Worker){
            //向下转型
            ((Worker)e).work();
        }else if(e instanceof Boss){
            //向下转型
            ((Boss)e).manage();
        }else{

        }
    }
}
