/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class SUVRates extends VehicleRates{
  private double daily_rate = 29.95;
  private double weekly_rate = 189.95;
  private double monthly_rate = 679.95;
  private double mileage_rate = 0.15;
  private double daily_insur_rate = 14.95;
  public SUVRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_rate, double daily_insur_rate)
  {
    super(daily_rate, weekly_rate, monthly_rate, mileage_rate, daily_insur_rate);
  }
  public String toString()
  {
    return "SUV rates= \ndailyrate: " + daily_rate + ". weeklyrate: " + weekly_rate + ". monthlyRate: " + monthly_rate + ". mileagerate: " + mileage_rate+ ". DailyInsuranceRate: " + daily_insur_rate;
  }
}