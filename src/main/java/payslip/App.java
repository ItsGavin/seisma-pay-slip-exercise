package payslip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Employee;

/** 
 * App class containing the main method of the pay slip calculation program.
 * 
 * This program is designed to first read and parse employee information from 
 * an input CSV file. The data is then ran through various calculations to 
 * obtain pay slip information and written to an output CSV.
 * 
 * @author Gavin Ng
 */
public final class App {
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

        List<List<String>> inputcsv = new ArrayList<>();
        List<String> outputcsv = new ArrayList<>();

        String INPUTSOURCE = args[0];
        String OUTPUTSOURCE = args[1];
   
        // Read from input CSV
        try (BufferedReader reader = new BufferedReader(
            new FileReader(INPUTSOURCE))) {

            System.out.println("Reading input csv from: " + INPUTSOURCE);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                inputcsv.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No input CSV file found at path: " + INPUTSOURCE);
            System.out.println(e.getMessage());
            return;
        }

        for (List employeeData : inputcsv) {

            String fName = (String) employeeData.get(0);
            String lName = (String) employeeData.get(1);

            int salary = Integer.parseInt((String) employeeData.get(2));

            String superRaw = (String) employeeData.get(3);
            double superRate = Double.parseDouble(superRaw.substring(
                0, superRaw.length()-1))/100;

            String payPeriod = (String) employeeData.get(4);

            Employee employee = new Employee(fName, lName, salary, superRate, 
                payPeriod);

            // System.out.println(employeeData);
            // System.out.println(employee.toStringCSV());
            outputcsv.add(employee.toStringCSV());
        }

        // Write to output CSV
        try (PrintWriter writer = new PrintWriter(new File(OUTPUTSOURCE))) {

            System.out.println("Writing output csv to: " + OUTPUTSOURCE);
     
            for (String outputLine : outputcsv) {
                writer.write(outputLine);
            }

            System.out.println("Write complete"); 
        }
    }
}
