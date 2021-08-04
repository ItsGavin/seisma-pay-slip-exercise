import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String INPUTDATA = "resources/input.csv";
    public static void main(String[] args) throws Exception {
        List<List<String>> inputcsv = new ArrayList<>();
        List<String> outputcsv = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(INPUTDATA))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] values = line.split(",");
                inputcsv.add(Arrays.asList(values));
            }
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
            int superRate = Integer.parseInt(superRaw.substring(0, superRaw.length()-1));

            // Payment period
            String payPeriod = (String) employeeData.get(4);

            // Calculate payroll data
            // Gross income
            int gross = Calculations.calcGross(salary);

            // Income tax
            int tax = Calculations.calcTax(salary);
            // Net income

            // Save to output list
            // String out = String.format("%s %s,%s,%d,%d,%d,%d", fName, lName, payPeriod, gross, tax, net, super);
            // outputcsv.add(out);
        }
        
        System.out.println(inputcsv);
        System.out.println(outputcsv);
    }
}
