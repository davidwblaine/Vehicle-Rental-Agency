/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class Transaction{

private String creditcard_num;
private String company_name;
private String vehicle_type; 
private String rental_period; 
private String rental_cost;

public Transaction(String creditcard_num, String company_name, String vehicle_type, String rental_period, String rental_cost) {
    this.creditcard_num = creditcard_num;
    this.company_name = company_name;
    this.vehicle_type = vehicle_type;
    this.rental_period = rental_period;
    this.rental_cost = rental_cost;
  }
  public String getCCN()
  {
    return creditcard_num;
  }

public String toString() {
return "\nCredit card number: " + creditcard_num + "\nCompany name: " + company_name + "\nVehicle type: " + vehicle_type + "\nRental period: " + rental_period + "\nRental cost: " + rental_cost;
}
}