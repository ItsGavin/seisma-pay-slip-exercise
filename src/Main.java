import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
 * Main class containing the main method of the pay slip calculation program.
 * 
 * This program is designed to first read and parse employee information from 
 * an input csv file. The data is then ran through various calculations to 
 * obtain pay slip information and written to an output csv.
 * 
 * @author Gavin Ng
 */
public class Main {
    // Global variable defining the relative path for the employee details csv
    static String INPUTSOURCE = "resources/input.csv";
    // Global variable defining the relative path for the employee pay slip 
    // information csv
    static String OUTPUTSOURCE = "resources/output.csv";

    /**
     * Main method of the program
     * Order of operation:
     * 1. Reads and parses employee details from specified input csv file
     * 2. Calculates payroll data
     * 3. Writes employee pay slip information out to specified output csv file
     * 
     * @param args the command line arguements
     * @throws Exception if an error occurs
     */
    public static void main(String[] args) throws Exception {
        // List of list of strings to hold data read from the input csv
        List<List<String>> inputcsv = new ArrayList<>();
        // List of strings containing the data to be written to the output csv
        List<String> outputcsv = new ArrayList<>();

        System.out.println("Reading input csv from: " + INPUTSOURCE);

        // Read data from input csv file
        try (BufferedReader reader = new BufferedReader(
            new FileReader(INPUTSOURCE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                inputcsv.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        // Iterates through each line of the input csv (each employee)
        for (List employeeData : inputcsv) {
            // Extract individual data values from the list
            // First and last name
            String fName = (String) employeeData.get(0);
            String lName = (String) employeeData.get(1);

            // Annual salary
            int salary = Integer.parseInt((String) employeeData.get(2));

            // Superannuation rate
            String superRaw = (String) employeeData.get(3);
            double superRate = Double.parseDouble(superRaw.substring(
                0, superRaw.length()-1))/100;

            // Payment period
            String payPeriod = (String) employeeData.get(4);

            // Calculate payroll data
            // Gross income
            int gross = Calculations.calcGross(salary);

            // Income tax
            int tax = Calculations.calcTax(salary);

            // Net income
            int net = Calculations.calcNet(gross, tax);

            // Superannuation
            int superAmount = Calculations.calcSuper(gross, superRate);

            // Save to output list
            String out = String.format("%s %s,%s,%d,%d,%d,%d\n", fName, lName, 
                payPeriod, gross, tax, net, superAmount);

            outputcsv.add(out);
        }

        System.out.println("Writing output csv to: " + OUTPUTSOURCE);

        // Write data to output csv file
        try (PrintWriter writer = new PrintWriter(new File(OUTPUTSOURCE))) {
     
            for (String outputLine : outputcsv) {
                writer.write(outputLine);
            }

            System.out.println("Write complete"); 
        }
    }
}
