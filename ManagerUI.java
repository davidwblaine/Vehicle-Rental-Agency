/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class ManagerUI implements UserInterface{
  static Scanner input = new Scanner(System.in);
  
  private boolean quit = false;
  int num_miles;
  public void start(Scanner input){
    int selection;

    while(!quit){
      DisplayMenu();
      selection = getSelection(input);
      execute(selection, input);
    }
  }
  private void execute(int selection, Scanner input){
    int veh_type;
    String vin, creditcard_num; 
    String[] display_lines;
    RentalDetails rental_details; 
    Reservation_Details reserv_details;

      switch(selection) {
// allows updating of rental and insurance rates
case 1: veh_type = getVehicleType(input);
  switch(veh_type){
   case 1: display_lines[0] = SystemInterface.getCarRates(); 
           display_lines[1] = SystemInterface.updateCarRates();
   break;
   case 2: display_lines[0] = SystemInterface.getSUVRates(); 
           display_lines[1] = SystemInterface.updateSUVRates();
   break;
   case 3: display_lines[0] = SystemInterface.getTruckRates(); 
           display_lines[1] = SystemInterface.updateSUVRates();
   break;
}
displayResults();
break;
// display all vehicles in the agency
case 2:
   display_lines = SystemInterface.getAllVehicles(); 
   displayResults(display_lines);

   break;
// add an account
case 3: 
display_lines = SystemInterface.addAccount(input);
displayResults(display_lines);
break;

// view all reservations
case 4: 
display_lines = SystemInterface.getAllReservations();
displayResults(display_lines);
break;
// view all accounts 
case 5: 
display_lines = SystemInterface.getAllAccounts();
displayResults(display_lines);
break;
// view all transactions
case 6: 
display_lines = SystemInterface.getAllTransactions();
displayResults(display_lines);
break;
// quit program
case 7: quit = true;
}
  }

// ------- private methods
private void displayMenu() {
// displays the menu of options
  System.out.println("Menu - Manager");
  System.out.println("1 - View/Update Rates");
  System.out.println("2 - View All vehicles");
  System.out.println("3 - Add Account");
  System.out.println("4 - View All Reservations");
  System.out.println("5 - View All Accounts");
  System.out.println("6 - View Transactions");
  System.out.println("7 - Quit"); 
}

private int getSelection(Scanner input) { 
// prompts user for selection from menu (continues to prompt is selection < 1 or selection > 8)
  System.out.print("Please Enter a Number 1 - 8: ");
    selecton = input.nextInt();
  while(selection < 1 || selection > 8){
   System.out.println("Invalid Selection. Please enter a number 1 - 8");
    selection = input.nextInt; 
  }
}

private String getVIN(Scanner input){
// prompts user to enter VIN for a given vehicle (does not do any error checking on the input)
  System.out.println("Please enter the VIN number of the vehicle");
    vin = input.nextLine();
  return vin;
}

private int getVehicleType(Scanner input){
// prompts user to enter 1, 2, or 3, and returns (continues to prompt user if invalid input given)
 System.out.println("Enter (1), (2), (3)");
 veh_type = input.nextInt();
 while(veh_type < 1 || veh_type > 3){
   System.out.println("Invalid option. Please choose 1, 2, or 3");
   veh_type = input.nextInt();
 }
} 
private void displayResults(String[] lines){
// displays the array of strings passed, one string per screen line 
 for(int i = 0; i < 2; i++){
   System.out.println(display_lines[i]);
 }
  }
  }
