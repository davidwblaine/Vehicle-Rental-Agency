/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class TruckRates extends VehicleRates{

  private double daily_rate = 35.95;
  private double weekly_rate = 224.95;
  private double monthly_rate = 787.95;
  private double mileage_rate = 0.26;
  private double daily_insur_rate = 22.95;

  public TruckRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_rate, double daily_insur_rate)
  {
    super(daily_rate,weekly_rate, monthly_rate, mileage_rate, daily_insur_rate);
  }
  public String toString()
  {
    return "Truck rates = \ndailyrate: " + daily_rate + "\nweeklyrate: " + weekly_rate + "\nmonthlyRate: " + monthly_rate + "\nmileagerate: " + mileage_rate+ "\n Daily insurance rate: " + daily_insur_rate;
  }
}