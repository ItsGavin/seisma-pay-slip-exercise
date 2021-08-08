package model;
import static utility.Constants.TAXDATA;
import static utility.Constants.MONTHS;
/** 
 * Models an Employee, holding all the necessary employee information and
 * pay slip data used by the program
 * 
 * @author Gavin Ng
 */
public class Employee {

    private final String fName;
    private final String lName;
    private final int salary;
    private final double superRate;
    private final String payPeriod;

    private int tax = this.calcTax();
    private int gross = this.calcGross();
    private int net = this.calcNet();
    private int superAmount = this.calcSuper();

    public Employee(String fName, String lName, int salary, double superRate, 
        String payPeriod) {

        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
        this.superRate = superRate;
        this.payPeriod = payPeriod;
    }

    private int calcGross() {
        return (int) Math.round(this.salary/MONTHS);
    }

    private int calcTax() {

        int taxBracket;

        if (this.salary <= TAXDATA[0][0]) { taxBracket = 0; }
        else if (this.salary <= TAXDATA[1][0]) { taxBracket = 1; }
        else if (this.salary <= TAXDATA[2][0]) { taxBracket = 2; }
        else if (this.salary <= TAXDATA[3][0]) { taxBracket = 3; }
        else if (this.salary > TAXDATA[3][0]) { taxBracket = 4; }
        else taxBracket = 0;
        
        return (int) Math.round((TAXDATA[taxBracket][1] + (this.salary - 
            TAXDATA[taxBracket][0]) * TAXDATA[taxBracket][2]) / MONTHS);
    }

    private int calcNet() {
        return this.gross - this.tax;
    }

    private int calcSuper() {
        return (int) Math.round(this.gross * this.superRate);
    }

    public String toStringCSV() {
        return String.format("%s %s,%s,%d,%d,%d,%d\n", fName, lName, 
        payPeriod, gross, tax, net, superAmount);
    }
}
