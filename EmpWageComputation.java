
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
    /*
    Use case 4: Solve using switch statement
    */
    public double empDailyWageSwitchCase(){
        double emp_daily_wage = 0;
        boolean emp_pres = empIsPresent();
        int day_len = 0;
        // check if employee present or not
        if (emp_pres){
            // check if employee works part time or full time
            double random_num = Math.random();
            if (random_num>0.5){
               day_len = 1; // part time work
            }else {
               day_len = 2;  // full time work
            }
        }else {
            day_len = 0;     
        }

        // use switch case statement for wages
        switch(day_len){
            case 0:
                emp_daily_wage = empDailyWage(false);
                break;
            case 1:
                emp_daily_wage = empDailyWage(true);
                break;
            case 2:
                emp_daily_wage = empDailyWage();
                break;
        }
        return emp_daily_wage;
    }
    /*
    Use Case 5: Calculate wages for a month
    */
    public double empMonthlyWage(){
        double emp_month_wage = 0;
        for (int i=1;i<31;i++){
            // call the method which computes daily wage based on employee's hours worked
            emp_month_wage += empDailyWageSwitchCase();
        }
        return emp_month_wage;
    }
    // Main method
    public static void main(String []args){
        EmpWageComputation ewc = new EmpWageComputation();
        double emp_monthly_wage = ewc.empMonthlyWage();
        System.out.println("The monthly wage of the employee = " + emp_monthly_wage);
    }
}
