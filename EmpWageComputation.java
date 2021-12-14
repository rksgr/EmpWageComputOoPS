
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
    public double empDailyWage(){
        int wage_per_hour = 20;
        int full_day_hour = 8;
        double emp_daily_wage = wage_per_hour*full_day_hour;
        return emp_daily_wage;
    }
    /*
    Use case 3: Calculate wage of employee in case of part time
                Method overloading
    */
    public double empDailyWage(boolean ifPartTime){
        double part_time_wage = 0;
        // Part time he works 4 hours in a day, call empDailyWage() method
        if (ifPartTime){
            part_time_wage = 0.5*empDailyWage();
        }
        return part_time_wage;
    }
    public static void main(String []args){
        EmpWageComputation ewc = new EmpWageComputation();
        double emp_part_time_wage = ewc.empDailyWage(true);
        System.out.println("The part time wage of the employee = " + emp_part_time_wage);
    }
}
