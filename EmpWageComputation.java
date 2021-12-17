package com.mycompany.dec_13_empwagecomput_oops;
import java.util.Scanner;

public class EmpWageComputation {
    private static final int WAGE_PER_HR = 20;
    private static final int FULL_DAY_HR = 8; 
    private static final int MAX_WORKG_DAYS = 20; 
    private static final int MAX_WORKG_HRS = 100; 
    private static final int TOTAL_DAYS_IN_MONTH = 30; 
    private static final int IS_ABSENT = 0;
    private static final int IS_PART_TIME = 1;
    private static final int IS_FULL_TIME = 2;
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
        int days = 0, workg_hrs = 0, workg_days = 0;
        // Till maximum hours or maximum days are reached in a month
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
    /*
    Use Case 7: Class method to compute employee wage
    */
    public static double empWageCalculate(){
        double emp_daily_wage = 0;
        int days = 0, workg_hrs = 0, workg_days = 0;
        
        // Till maximum hours or maximum days are reached in a month
        while ((days<TOTAL_DAYS_IN_MONTH) && (workg_hrs<=MAX_WORKG_HRS) 
                && (workg_days<=MAX_WORKG_DAYS)){
            // generate a random number out of 0,1 and 2
            int absent_or_part_or_full = (int)((Math.random())*10)%3;
            // check if employee works part time or full time or is absent
            switch (absent_or_part_or_full){
                    case IS_ABSENT: // absent
                        emp_daily_wage += 0;
                        break;
                    case IS_PART_TIME: // part time
                        workg_hrs+=4;
                        workg_days++;
                        emp_daily_wage += 0.5*WAGE_PER_HR*FULL_DAY_HR ;
                        break;
                    case IS_FULL_TIME: // full time
                        workg_hrs+=8;
                        workg_days++;
                        emp_daily_wage += WAGE_PER_HR*FULL_DAY_HR ;
                        break;
            }
            days++;
        }
        return emp_daily_wage;
    }
    /*
    Use case 8: Employee wage multiple companies
    */
    public static void empWageMultiCompanies(){
        System.out.println("Enter the number of companies whose wage need "
                + "to be calculated: ");
        Scanner sc = new Scanner(System.in);
        int no_comp = sc.nextInt();
        // declare an array of array
        int[][] comp_norm = new int[no_comp][];
        String [] comp_name = new String[no_comp];
        
        for (int i=0;i<no_comp;i++){
            // Take input from user about each company
            System.out.println("Enter name of company : ");
            Scanner sc0 = new Scanner(System.in);
            String company_nam = sc0.next();
            System.out.println("Enter number of working days in "+company_nam+ " : ");
            Scanner sc1 = new Scanner(System.in);
            int working_days = sc1.nextInt();
            System.out.println("Enter wage per hour in "+company_nam+ ": ");
            Scanner sc2 = new Scanner(System.in);
            int wage_per_hr = sc2.nextInt();
            System.out.println("Enter number of working hours per month in "+company_nam+ ": ");
            Scanner sc3 = new Scanner(System.in);
            int working_hrs_per_month = sc3.nextInt();
            System.out.println("Enter number of hours in full day in "+company_nam+ ": ");
            Scanner sc4 = new Scanner(System.in);
            int full_day_hours = sc4.nextInt();  

            double emp_salary = monthlyEmployeeWageMulti(working_days,wage_per_hr,
                    working_hrs_per_month,full_day_hours);
            System.out.println("The monthly salary of the employee in "+ 
                    company_nam +" = "+emp_salary);
        }  
    }
    // calculate monthly wage of employee in different companies
    public static double monthlyEmployeeWageMulti(int working_days,int wage_per_hr,
            int working_hrs_per_month, int full_day_hours){
        double emp_tot_wage = 0;
        int days = 0, workg_hrs = 0, workg_days = 0;
        
        // Till maximum hours or maximum days are reached in a month
        while ((days<working_days) && (workg_hrs<=working_hrs_per_month) 
                && (days<=MAX_WORKG_DAYS)){
            // generate a random number out of 0,1 and 2
            int absent_or_part_or_full = (int)((Math.random())*10)%3;
            // check if employee works part time or full time or is absent
            switch (absent_or_part_or_full){
                    case IS_ABSENT: // absent
                        break;
                    case IS_PART_TIME: // part time
                        workg_hrs += full_day_hours/2;
                        workg_days++;
                        emp_tot_wage += 0.5*wage_per_hr*full_day_hours ;
                        break;
                    case IS_FULL_TIME: // full time
                        workg_hrs += full_day_hours;
                        workg_days++;
                        emp_tot_wage += wage_per_hr*full_day_hours ;
                        break;
            }
            days++;
        }
        return emp_tot_wage;
    }
    // Main method
    public static void main(String []args){
        empWageMultiCompanies();
    }
}
