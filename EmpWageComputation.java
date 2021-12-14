
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
    public static void main(String []args){
        EmpWageComputation ewc = new EmpWageComputation();
        boolean emp_pres = ewc.empIsPresent();
        if (emp_pres){ System.out.println("Employee is present");
        } else { System.out.println("Employee is absent");}
    }
}
