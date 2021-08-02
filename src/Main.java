import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String INPUTDATA = "resources/input.csv";
    public static void main(String[] args) throws Exception {
        List<List<String>> employee_details = new ArrayList<>();

        try (BufferedReader in = new BufferedReader(new FileReader(INPUTDATA))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] values = line.split(",");
                employee_details.add(Arrays.asList(values));
            }
        }
        
        System.out.println(employee_details);
        System.out.println("Hello, World!");
    }
}
