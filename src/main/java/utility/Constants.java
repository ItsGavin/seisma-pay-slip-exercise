package utility;

/**
 * File containing constant variables used throughout the program.
 */
public final class Constants {

    private Constants() {
        // Restrict instantiation
    }

    public static final int MONTHS = 12;

    // {Tax bracket upper amount, Initial tax amount, Tax rate}
    public static final double[][] TAXDATA = {
        {18200.0, 0.0, 0.0},
        {37000.0, 0.0, 0.19},
        {87000.0, 3572.0, 0.325},
        {180000.0, 19822.0, 0.37},
        {-1.0, 54232.0, 0.45}
    };

}
