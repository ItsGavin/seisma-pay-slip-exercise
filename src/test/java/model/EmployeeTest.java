package model;

import org.junit.jupiter.api.Test;

import utility.InputOutOfRangeException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.DisplayName;

/**
 * Unit test for Employee class.
 */
public class EmployeeTest{

    @Test
    @DisplayName("Testing average employee object 1 - Monica")
    void testAverage1() throws Exception{

        // Example test case 1 provided in exercise specification
        Employee employee = new Employee(
            "Monica","Tan",60050,0.09,"01 March – 31 March");

        assertAll("Pay slip information",
            () -> assertEquals(5004, employee.gross, "Gross"),
            () -> assertEquals(922, employee.tax, "Tax"),
            () -> assertEquals(4082, employee.net, "Net"),
            () -> assertEquals(450, employee.superAmount, "Super")
        );
    }

    @Test
    @DisplayName("Testing average employee object 2 - Brend")
    void testAverage2() throws Exception{

        // Example test case 2 provided in exercise specification
        Employee employee = new Employee(
            "Brend","Tulu",120000,0.10,"01 March – 31 March");

        assertAll("Pay slip information",
            () -> assertEquals(10000, employee.gross, "Gross"),
            () -> assertEquals(2669, employee.tax, "Tax"),
            () -> assertEquals(7331, employee.net, "Net"),
            () -> assertEquals(1000, employee.superAmount, "Super")
        );
    }

    @Test
    @DisplayName("Testing extreme employee object 2 - Joe")
    void testExtreme1() throws Exception{

        Employee employee = new Employee(
            "Joe","Ham",0,0.0,"01 March – 31 March");

        assertAll("Pay slip information",
            () -> assertEquals(0, employee.gross, "Gross"),
            () -> assertEquals(0, employee.tax, "Tax"),
            () -> assertEquals(0, employee.net, "Net"),
            () -> assertEquals(0, employee.superAmount, "Super")
        );
    }

    @Test
    @DisplayName("Testing extreme employee object 2 - Jake")
    void testExtreme2() throws Exception{

        Employee employee = new Employee(
            "Jake","Kin",500000000,0.50,"01 March – 31 March");

        assertAll("Pay slip information",
            () -> assertEquals(41666664, employee.gross, "Gross"),
            () -> assertEquals(18747769, employee.tax, "Tax"),
            () -> assertEquals(22918895, employee.net, "Net"),
            () -> assertEquals(20833332, employee.superAmount, "Super")
        );
    }

    @Test
    @DisplayName("Testing employee object with negative salary")
    void testOutOfRangeSalary() {

        Throwable exception = assertThrows(InputOutOfRangeException.class,() -> {
            Employee employee = new Employee("Jonah","R",-20,0.01,"01 March – 31 March");
        });
            
        assertEquals("Salary must be a positive integer: Jonah R", 
            exception.getMessage());
    }

    @Test
    @DisplayName("Testing employee object with out of range super rate")
    void testOutOfRangeSuper() {

        Throwable exception = assertThrows(InputOutOfRangeException.class,() -> {
            Employee employee = new Employee("Jacob","C",10000,0.80,"01 March – 31 March");
        });
            
        assertEquals("Super rate must be between 0 - 0.5: Jacob C", 
            exception.getMessage());
    }
}