/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class CarRates extends VehicleRates{
  private double daily_rate = 24.95;
  private double weekly_rate = 159.95;
  private double monthly_rate = 514.95;
  private double mileage_rate = 0.15;
  private double daily_insur_rate = 14.95;
  public CarRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_rate, double daily_insur_rate)
  {
    super(daily_rate, weekly_rate, monthly_rate, mileage_rate, daily_insur_rate);
  }
  public String toString()
  {
    return "car rates= \ndailyrate: " + daily_rate + ". weeklyrate: " + weekly_rate + ". monthlyRate: " + monthly_rate + ". mileagerate: " + mileage_rate+ ". DailyInsuranceRate: " + daily_insur_rate;
  }
}