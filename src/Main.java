import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String INPUTSOURCE = "resources/input.csv";
    static String OUTPUTSOURCE = "resources/output.csv";

    public static void main(String[] args) throws Exception {
        List<List<String>> inputcsv = new ArrayList<>();
        List<String> outputcsv = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUTSOURCE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                inputcsv.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        for (List employeeData : inputcsv) {
            // Extract individual data values from the list
            // First and last name
            String fName = (String) employeeData.get(0);
            String lName = (String) employeeData.get(1);

            // Annual salary
            int salary = Integer.parseInt((String) employeeData.get(2));

            // Super annuation rate
            String superRaw = (String) employeeData.get(3);
            double superRate = Double.parseDouble(superRaw.substring(0, superRaw.length()-1))/100;

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
            String out = String.format("%s %s,%s,%d,%d,%d,%d\n", fName, lName, payPeriod, gross, tax, net, superAmount);
            outputcsv.add(out);
        }

        System.out.println(inputcsv);
        System.out.println(outputcsv);

        try (PrintWriter writer = new PrintWriter(new File(OUTPUTSOURCE))) {
     
            for (String outputLine : outputcsv) {
                writer.write(outputLine);
            }

            System.out.println("output.csv write complete"); 
        }
    }
}
