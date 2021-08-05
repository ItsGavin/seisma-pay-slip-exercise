public class Calculations {

    public static int calcGross(int salary) {
        double gross = salary/12;
        int grossRounded = (int) Math.round(gross);

        return grossRounded;
    }

    public static int calcTax(int salary) {
        // Tax bracket 1
        // No tax
        if (salary <= 18200) return 0;

        // Tax bracket 2
        // 19c for each $1 over $18,200 
        else if (salary <= 37000) {
            double tax = ((salary-18200) * 0.19) / 12;
            return (int) Math.round(tax);
        }

        // Tax bracket 3
        // $3,572 plus 32.5c for each $1 over $37,000
        else if (salary <= 87000) {
            double tax = (3572 + (salary-37000) * 0.325) / 12;
            return (int) Math.round(tax);
        }

        // Tax bracket 4
        // $19,822 plus 37c for each $1 over $87,000 
        else if (salary <= 180000) {
            double tax = (19822 + (salary-87000) * 0.37) / 12;
            return (int) Math.round(tax);
        }

        // Tax bracket 5
        // $54,232 plus 45c for each $1 over $180,000
        else if (salary > 180000) {
            double tax = (54232 + (salary-180000) * 0.45) / 12;
            return (int) Math.round(tax);
        }

        //-1 tax indicates a failure in the tax calculation
        else return -1; 
    }

    public static int calcNet(int gross, int tax) {
        return gross - tax;
    }

    public static int calcSuper(int gross, double superRate) {
        return (int) Math.round(gross * superRate);
    }
}
