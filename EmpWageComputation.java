
package com.mycompany.dec_13_empwagecomput_oops;

public class EmpWageComputation {
    
    /*
    Use case 1: Check whether employee is present
    */
    public boolean empIsPresent(){
        boolean emp_pres = false;
        if (Math.random()>0.5){
            emp_pres = true;
        }
        return emp_pres;
    }
    /*
    Use case 2: Calculate Daily Employee Wage
    */
    public int empDailyWage(){
        int wage_per_hour = 20;
        int full_day_hour = 8;
        int emp_daily_wage = wage_per_hour*full_day_hour;
        return emp_daily_wage;
    }
    public static void main(String []args){
        EmpWageComputation ewc = new EmpWageComputation();
        int emp_daily_wage = ewc.empDailyWage();
        System.out.println("The daily wage of the employee = " + emp_daily_wage);
    }
}
