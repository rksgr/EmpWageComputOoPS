
package com.mycompany.dec_13_empwagecomput_oops;

public class EmpWageComputation {
    private static final int WAGE_PER_HR = 20;
    private static final int FULL_DAY_HR = 8; 
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
        double emp_daily_wage = WAGE_PER_HR*FULL_DAY_HR;
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
    /*
    Use Case 6: Calculate wages till days or working hours reached for month
    */
    public double empWageConditional(){
        int MAX_WORKG_HRS = 100;
        int MAX_WORKG_DAYS  = 20;
        double tot_wage =0;
        int days = 0;
        int workg_hrs = 0;
        int workg_days = 0;
        while ((days<30) &&(workg_hrs<=MAX_WORKG_HRS) &&(workg_days<=MAX_WORKG_DAYS)){          
            tot_wage +=empDailyWageSwitchCase();
            if (empDailyWageSwitchCase()==160.0){
                workg_hrs+=8;
                workg_days++;
            } else if (empDailyWageSwitchCase()==160.0){
                workg_hrs+=4;
                workg_days++; 
            }
            days++;
        }
        return tot_wage;
    }
    
    // Main method
    public static void main(String []args){
        EmpWageComputation ewc = new EmpWageComputation();
        double tot_cond_wage = ewc.empWageConditional();
        System.out.println("The conditional monthly wage of the employee = " 
                + tot_cond_wage);
    }
}
