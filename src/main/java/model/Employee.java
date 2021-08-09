package model;

import static utility.Constants.TAXDATA;
import static utility.Constants.MONTHS;

import utility.InputOutOfRangeException;

/** 
 * Models an Employee, holding all the necessary employee information and
 * pay slip data used by the program.
 * 
 * Constructor takes first name, last name, annual salary, superannuation rate,
 * and payment period as input and calculates tax rate, gross income, net 
 * income, and superannuation amount. 
 * 
 * @author Gavin Ng
 */
public class Employee{

    public final String fName;
    public final String lName;
    public final int salary;
    public final double superRate;
    public final String payPeriod;

    public int tax;
    public int gross;
    public int net;
    public int superAmount;

    public Employee(String fName, String lName, int salary, double superRate, 
        String payPeriod) throws Exception{

        try {
            if (salary < 0) {
                System.out.println("ERROR");
                String message = String.format(
                    "Salary must be a positive integer: %s %s", fName, lName);
                InputOutOfRangeException ex = 
                    new InputOutOfRangeException(message);
                throw ex;
            }
            if (superRate < 0.0 || superRate > 0.50) {
                String message = String.format(
                    "Super rate must be between 0 - 0.5: %s %s", fName, lName);
                InputOutOfRangeException ex = 
                    new InputOutOfRangeException(message);
                throw ex;
            }
        } finally {
            this.fName = fName;
            this.lName = lName;
            this.salary = salary;
            this.superRate = superRate;
            this.payPeriod = payPeriod;
    
            this.tax = this.calcTax();
            this.gross = this.calcGross();
            this.net = this.calcNet();
            this.superAmount = this.calcSuper();
        }
        // catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
    }

    private int calcGross() {

        return (int) Math.round(salary/MONTHS);
    }

    private int calcTax() {

        int taxBracket;
        double taxRaw;

        if (salary <= TAXDATA[0][0]) { taxBracket = 0; }
        else if (salary <= TAXDATA[1][0]) { taxBracket = 1; }
        else if (salary <= TAXDATA[2][0]) { taxBracket = 2; }
        else if (salary <= TAXDATA[3][0]) { taxBracket = 3; }
        else if (salary > TAXDATA[3][0]) { taxBracket = 4; }
        else taxBracket = 0;

        if (taxBracket > 0) {
            taxRaw = (TAXDATA[taxBracket][1] + (salary - 
            TAXDATA[taxBracket-1][0]) * TAXDATA[taxBracket][2]) / MONTHS;
        }
        else {
            taxRaw = 0.0;
        }
        
        return (int) Math.round(taxRaw);
    }

    private int calcNet() {

        return gross - tax;
    }

    private int calcSuper() {

        return (int) Math.round(gross * superRate);
    }

    public String toStringCSV() {

        return String.format("%s %s,%s,%d,%d,%d,%d\n", fName, lName, 
        payPeriod, gross, tax, net, superAmount);
    }
}
