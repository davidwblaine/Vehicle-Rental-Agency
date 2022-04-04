/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class TimeSpan {
  private char timeUnit;
  private int numUnits;

  public TimeSpan(char timeUnit, int numUnits) {
    this.timeUnit = timeUnit;
    this.numUnits = numUnits;
  }

  public char getTimeUnit() {
    return this.timeUnit;
  }

  public int getNumUnits() {
    return this.numUnits;
  }

  public String getTimeSpan() {
    switch (this.timeUnit) {
      case 'D':
        return numUnits + " day(s)";
      case 'W':
        return numUnits + " week(s)";
      case 'M':
        return numUnits + " month(s)";
      default:
        return "No Timespan";
    }
  }
}
