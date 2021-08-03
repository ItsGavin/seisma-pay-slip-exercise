public class Calculations {

  public static int calcGross(int salary) {
    double gross = salary/12;
    int grossRounded = (int) Math.round(gross);

    return grossRounded;
  }

  // public int calcTax() {
  //   return 1;
  // }
}
