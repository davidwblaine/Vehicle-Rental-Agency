/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class RentalDetails{
  private int veh_type;
  private String num_day_used;
  private int num_miles_driven;
  private boolean gettingInsurance;

  public RentalDetails(int veh_type, String num_day_used, int num_miles_driven, boolean gettingInsurance){
    this.veh_type = veh_type;
    this.num_day_used = num_day_used;
    this.num_miles_driven = num_miles_used;
    this.gettingInsurance = gettingInsurance;
  }

  public int getVeh_type(){
    return veh_type;
  }

  public String getNum_day_used(){
    return num_day_used;
  }

  public int getNum_miles_driven(){
    return num_miles_driven;
  }

  public boolean getGettingInsurance(){
    return gettingInsurance;
  }
}