package payslip;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for InputParser class.
 */
class InputParserTest {

    @Test
    @DisplayName("Parser test case 1 - Monica")
    void testParser1() {

        List<String> employeeData = new ArrayList<String>() {
            {
                add("Monica");
                add("Tan");
                add("60050");
                add("9%");
                add("01 March – 31 March");
            }
        };
        List<Object> parse = InputParser.ParseInput(employeeData);

        List<Object> test = new ArrayList<Object>() {
            {
                add("Monica");
                add("Tan");
                add(60050);
                add(0.09);
                add("01 March – 31 March");
            }
        };

        assertEquals(test, parse);
    }

    @Test
    @DisplayName("Parser test case 2 - Brend")
    void testParser2() {

        List<String> employeeData = new ArrayList<String>() {
            {
                add("Brend");
                add("Tulu");
                add("120000");
                add("10%");
                add("01 March – 31 March");
            }
        };
        List<Object> parse = InputParser.ParseInput(employeeData);

        List<Object> test = new ArrayList<Object>() {
            {
                add("Brend");
                add("Tulu");
                add(120000);
                add(0.10);
                add("01 March – 31 March");
            }
        };

        assertEquals(test, parse);
    }
}
