/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class ReservationDetails {

  private String vin;
  private String creditcard_num;
  private String num_day_used;
  private boolean gettingInsurance;

  public ReservationDetails(String vin, String num_day_used, String creditcard_num, boolean gettingInsurance){
    this.vin = vin;
    this.num_day_used = num_day_used;
    this.creditcard_num = creditcard_num;
    this.gettingInsurance = gettingInsurance;
  }

  public String getVin(){
    return vin;
  }

  public String getNum_day_used(){
    return num_day_used;
  }

  public String getCreditcard_num(){
    return creditcard_num;
  }

  public boolean getGettingInsurance(){
    return gettingInsurance;
  }
}