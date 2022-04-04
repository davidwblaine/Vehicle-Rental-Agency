/* Abednego Njike, Zachary Bazzle, & David Blaine */
import java.util.*;
public class CurrentRates
{
  static Scanner input = new Scanner(System.in); 
  private VehicleRates[] rates = new VehicleRates[3];
  public CurrentRates(CarRates car_rates, SUVRates suv_rates, TruckRates truck_rates)
  {
    car_rates = new CarRates(24.5,159.95,514.95,0.15,14.95);
    suv_rates = new SUVRates(29.95,189.95,679.95,0.15,14.95);
    truck_rates = new TruckRates(35.95,224.95,787.95,0.26,22.95);
    rates[0] = car_rates;
    rates[1] = suv_rates;
    rates[2] = truck_rates;
  }
  public VehicleRates getCarRates()
  {
    return rates[0];
  }
  public VehicleRates getSUVRates()
  {
    return rates[1];
  }
  public VehicleRates getTruckRates()
  {
    return rates[2];
  }

  public double calcEstimatedCost(int vehicleType, TimeSpan estimatedRentalPeriod, int estimatedNumMiles, boolean dailynsur, boolean primeCustomer){
    VehicleRates _rate = null;
    double valueComputed = 0;
    double _mileageRate;
    if(vehicleType == 1)
    _rate = getCarRates();
    else if(vehicleType == 2)
    _rate = getSUVRates();
    else if(vehicleType == 3)
    _rate = getTruckRates();

    _mileageRate = estimatedNumMiles * _rate.getMileageRate();

    switch(estimatedRentalPeriod.getTimeUnit())
    {
      case 'D': valueComputed = estimatedRentalPeriod.getNumUnits() * _rate.getDailyRate();break;
      case 'W': valueComputed = estimatedRentalPeriod.getNumUnits() * _rate.getWeeklyRate();break;
      case 'M': valueComputed = estimatedRentalPeriod.getNumUnits() * _rate.getMonthlyRate(); break;
      default:break;
    }
    return _mileageRate + valueComputed;

  }
  
  public double calcActualCost(VehicleRates rates, int numDaysUsed, int NumMilesDriven, boolean dailyInsur, boolean primeCustomer) {
                double amount = 0;
                if (dailyInsur) {
                        amount += rates.getDailyInsuranceRate() * numDaysUsed;
                }
                if (primeCustomer) {
                        NumMilesDriven -= 100;
                        if (NumMilesDriven < 0) {
                                NumMilesDriven = 0;
                        }
                }
                if (numDaysUsed > 30) {
                        amount += rates.getMonthlyRate() * ((double) numDaysUsed / 31);
                } else if (numDaysUsed > 6) {
                        amount += rates.getWeeklyRate() * ((double) numDaysUsed / 7);
                } else {
                        amount += rates.getDailyRate() * ((double) numDaysUsed);
                }
                amount += rates.getMileageRate() * NumMilesDriven;

                return amount;
        }
}