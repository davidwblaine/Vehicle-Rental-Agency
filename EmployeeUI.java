/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class EmployeeUI implements UserInterface {
  private boolean quit = false;

public void start(Scanner input) { 
  int selection;

 while(!quit) {
displayMenu();
selection = getSelection(input);
execute(selection, input);
} 
}
private void execute(int selection, Scanner input)
{
int veh_type;
String vin; 
String creditcard_num; 
String[] display_lines;
RentalDetails rental_details; 
ReservationDetails reserv_details;

switch(selection) {

case 1: veh_type = getVehicleType(input);
switch(veh_type){
case 1: display_lines = SystemInterface.getCarRates(); break; 
case 2: display_lines = SystemInterface.getSUVRates(); break; 
case 3: display_lines = SystemInterface.getTruckRates(); break;
} 
displayResults(display_lines); 
break;

case 2: veh_type = getVehicleType(input);
switch(veh_type){
case 1: display_lines = SystemInterface.getAvailCars(); 
break; 
case 2: display_lines = SystemInterface.getAvailSUVs(); break; 
case 3: display_lines = SystemInterface.getAvailTrucks(); break;
} 
displayResults(display_lines); 
break;

case 3: rental_details = getRentalDetails(input);
display_lines = SystemInterface.estimatedRentalCost(rental_details); 
displayResults(display_lines);
break;

case 4: reserv_details = getReservationDetails(input);
display_lines = SystemInterface.makeReservation(reserv_details); 
displayResults(display_lines);
break;

case 5: vin = getVIN(user_input);
display_lines = SystemInterface.cancelReservation(creditcard_num, vin); 
displayResults(display_lines);
break;

case 6: creditcard_num = getCreditCardNum(input);
display_lines = SystemInterface.getAccount(creditcard_num); 
displayResults(display_lines);
break;

case 7: creditcard_num = getCreditCardNum(user_input);
vin = getVIN(input);
display_lines = SystemInterface.processReturnedVehicle(vin,num_day_used,num_miles_driven);
displayResults(display_lines); 
break;

case 8: quit = true;
break;
}
}

private void displayMenu(){
  System.out.println("Enter 1 for rental rates");
  System.out.println("Enter 2 for available vehicles");
  System.out.println("Enter 3 for estimated rental cost");
  System.out.println("Enter 4 to make a reservation");
  System.out.println("Enter 5 to cancel a reservation");
  System.out.println("Enter 6 to view corporate account");
  System.out.println("Enter 7 to process returned vehicle");
  System.out.println("Enter 8 to quit program"); 
}

private int getSelection(Scanner input){
System.out.println("Enter a number from 1 to 8");
selection = input.next();
if( selection < 1 || selection > 8){
  System.out.println("Entry invalid please reenter");
  System.out.println("Enter a number from 1 to 8");
  selection = input.next();
}
}

private String getVIN(Scanner input) {
System.out.println("Enter the VIN for the given vehicle");
 String vin = input.next();
}

private int getVehicleType(Scanner input) {
System.out.println("Enter 1 for cars, 2 for SUV, or 3 for Truck");
veh_type = input.next();
if(veh_type < 1 || veh_type > 3){
  System.out.println("invalid entry please reenter");
  System.out.println("Enter 1 for cars, 2 for SUV, or 3 for Truck");
  veh_type = input.next();
}
return veh_type;
}

private RentalDetails getRentalDetails(Scanner input) {
veh_type = getVehicleType(input);
System.out.println("please enter the estimated number of miles");
num_miles_driven = input.next();
System.out.println("Please enter D, W, or M for the duration of your rental. (D - Days, W - Weeks, or M - Months)");
    String num_day_used = input.next();
    System.out.println("Please enter your rental time.");
    int rentalTime = input.nextInt();
    TimeSpan time = new TimeSpan(num_day_used.charAt(0), rentalTime);

    boolean gettingInsurance;
    System.out.println("Would you like to add insurance? (Y/N)");
    String insuranceChoice = input.next();
    if (insuranceChoice.equals("Y"))
      gettingInsurance = true;
    else
      gettingInsurance = false;

      return rental_details;
}


private ReservationDetails getReservationDetails(Scanner input) {
System.out.println("Please input the vehicle VIN number.");
    String vin = input.next();
    System.out.println("Please enter your Credit Card Number.");
    String creditcard_num = input.next();

    System.out.println("Please enter D, W, or M for the duration of your rental. (D - Days, W - Weeks, or M - Months)");
    String num_day_used = input.next();

    System.out.println("Please enter your rental time.");
    int rentalTime = input.nextInt();
    TimeSpan time = new TimeSpan(num_day_used.charAt(0), rentalTime);

    boolean gettingInsurance;
    System.out.println("Would you like to add insurance? (Y/N)");
    String insuranceChoice = input.next();
    if (insuranceChoice.equals("Y"))
      gettingInsurance = true;
    else
      gettingInsurance = false;

      return reserv_details;
}

private void displayResults(String[] lines) {

}
}