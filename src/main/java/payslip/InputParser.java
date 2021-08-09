package payslip;
import java.util.ArrayList;
import java.util.List;
/**
 * Singleton method to parse CSV input data into a format usable by the
 * Employee constructor.
 * 
 * @author Gavin Ng
 */
public class InputParser {
    
    public static List<Object> ParseInput(List<String> employeeData) {

        String fName = (String) employeeData.get(0);
        String lName = (String) employeeData.get(1);

        int salary = Integer.parseInt((String) employeeData.get(2));

        String superRaw = (String) employeeData.get(3);
        double superRate = Double.parseDouble(superRaw.substring(
            0, superRaw.length()-1))/100;

        String payPeriod = (String) employeeData.get(4);

        List<Object> out = new ArrayList<Object>() {
            {
                add(fName);
                add(lName);
                add(salary);
                add(superRate);
                add(payPeriod);
            }
        };           

        return out;
    }
}
