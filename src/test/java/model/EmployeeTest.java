package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;

/**
 * Unit test for Employee class.
 */
public class EmployeeTest {

    @Test
    @DisplayName("Testing average employee object 1 - Monica")
    void testAverage1() {

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
    void testAverage2() {

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
    void testExtreme1() {

        // Example test case 2 provided in exercise specification
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
    void testExtreme2() {

        // Example test case 2 provided in exercise specification
        Employee employee = new Employee(
            "Jake","Kin",500000000,0.50,"01 March – 31 March");

        assertAll("Pay slip information",
            () -> assertEquals(41666664, employee.gross, "Gross"),
            () -> assertEquals(18747769, employee.tax, "Tax"),
            () -> assertEquals(22918895, employee.net, "Net"),
            () -> assertEquals(20833332, employee.superAmount, "Super")
        );
    }
}