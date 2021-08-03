import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String INPUTDATA = "resources/input.csv";
    public static void main(String[] args) throws Exception {
        List<List<String>> input_csv = new ArrayList<>();
        List<String> output_csv = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(INPUTDATA))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] values = line.split(",");
                input_csv.add(Arrays.asList(values));
            }
        }

        for (List employee_data : input_csv) {
            //System.out.println(employee_data);

            // Extract individual data values from the list
            // First and last name
            String first_name = (String) employee_data.get(0);
            String last_name = (String) employee_data.get(1);

            // Annual salary
            double annual_salary = Double.parseDouble((String) employee_data.get(2));

            // Super annuation rate
            String super_raw = (String) employee_data.get(3);
            int super_rate = Integer.parseInt(super_raw.substring(0, super_raw.length()-1));

            // Payment period
            String pay_period = (String) employee_data.get(4);

            // System.out.println(first_name);
            // System.out.println(last_name);
            // System.out.println(annual_salary);
            // System.out.println(super_rate);
            // System.out.println(pay_period);

            String out = String.format("%s %s,%s,%d", first_name, last_name, pay_period, super_rate);
            output_csv.add(out);
        }
        
        System.out.println(input_csv);
        System.out.println(output_csv);
    }
}
