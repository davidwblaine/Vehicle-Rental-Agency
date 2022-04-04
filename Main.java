/* Abednego Njike, Zachary Bazzle, & David Blaine */
import java.util.*;

public class Main {
  static Scanner input = new Scanner(System.in);
  Vehicles agency_vehicles = new Vehicles();

  public Main() {
    Vehicle veh1 = new Car("Chevrolet Camaro - 2018", 30, "HK4GM4564GD", 2);
    Vehicle veh2 = new Car("Ford Fusion - 2018", 34, "AB4EG5689GM", 4);
    Vehicle veh3 = new Car("Ford Fusion Hybrid - 2017", 32, "KU4EG3245RW", 4);
    Vehicle veh4 = new Car("Chevrolet Impala - 2018", 30, "RK3BM4366YH", 4);
    Vehicle veh5 = new SUV("Honda Odyssey - 2020", 28, "VN9RE2635TD", 7, 6);
    Vehicle veh6 = new SUV("Dodge Caravan - 2019", 25, "QK3FL4273ME", 5, 4);
    Vehicle veh7 = new SUV("Ford Expedition - 2018", 20, "JK2RT9264HY", 5, 3);
    Vehicle veh8 = new Truck("Ten-Foot", 12, "EJ5KU2435BC", 2810);
    Vehicle veh9 = new Truck("Eighteent-Foot", 10, "KG4DM5472RK", 5930);
    Vehicle veh10 = new Truck("Twenty-Four-Foot", 8, "EB2WR3082QB", 6500);
    Vehicle veh11 = new Truck("Twenty-Four-Foot", 8, "TV3GH4280EK", 6500);
    Vehicle[] listVehicle = { veh1, veh2, veh3, veh4, veh5, veh6, veh7, veh8, veh9, veh10, veh11 };
    for (Vehicle vehicle : listVehicle) {
      agency_vehicles.add(vehicle);
    }
  }

  public  void main(String[] args) {
    int numSelected;
    int num;
    Main main = new Main();
    UserInterface ui;
   boolean quit = false;
   while(!quit) { 
		ui = getUI(input);
	
		if(ui == null) {
			quit = true;
    }
		else {
			if(!SystemInterface.initialized())
			SystemInterface.initSystem(agency_rates, agency_vehicles, accounts, transactions);
      
			ui.start(input);
		}
    }
	}

public static UserInterface getUI(Scanner input) {
	boolean valid_selection = false;

	while(!valid_selection) {
		System.out.print("1 Employee, 2  Manager, 3  quit");

		selection = input.nextInt();
		if(selection == 1) {
			return new EmployeeInterface();
			valid_selection = true;
		}
		else
		if(selection == 2) {
			return new ManagerInterface();
			valid_selection = true;
		}
		else
		if(selection == 3) {
			return null;
			valid_selection = true;
		}
		else
			System.out.println("Invalid selection please reenter");
	}
	return ui;
}



    do {
      System.out.println("\n1 - Display all vehicles");
      System.out.println("2 - Display available vehicles");
      System.out.println("3 - Reserve a vehicle");
      System.out.println("4 - Display a Reservation");
      System.out.println("5 - Cancel a Reservation");
      System.out.println("6 - Add a vehicle");
      System.out.println("7 - Quit");
      numSelected = input.nextInt();

      switch (numSelected) {
        case 1:
          main.displayAll();
          break;
        case 2:
          main.displayAvailable();
          break;
        case 3:
          main.reserveVehicle();
          break;
        case 4:
          main.displayReservation();
          break;
        case 5:
          main.cancelReservation();
          break;
        case 6:
          main.addVehicle();
          break;
        default:
          System.out.println("Exiting Application");
          break;
      }
    } while (numSelected != 7);
  

  public void displayAll() {
    agency_vehicles.reset();
    while (agency_vehicles.hasNext()) {
      System.out.println(agency_vehicles.getNext().toString());
    }
  }

  public void displayAvailable() {
    agency_vehicles.reset();
    while (agency_vehicles.hasNext()) {
      Vehicle testVeh = agency_vehicles.getNext();
      if (!testVeh.isReserved())
        System.out.println(testVeh);
      else
        System.out.println("Invalid Input");
    }
  }

  public void addVehicle() {
    System.out.println("Enter vehicle description");
    input.nextLine();
    String description = input.nextLine();
    System.out.println("Enter MPG");
    int mpg = input.nextInt();
    System.out.println("Enter VIN");
    String vin = input.next();
    System.out.println("Select a Vehicle Type, (1 - Car, 2 - SUV, 3 - Truck)");
    int vehicleType = input.nextInt();
    Vehicle vehicle = null;
    if (vehicleType == 1) {
      System.out.println("\nEnter Seat Capacity");
      int seating = input.nextInt();
      vehicle = new Car(description, mpg, vin, seating);
      agency_vehicles.add(vehicle);
      System.out.println("New Car Added!");
    } else if (vehicleType == 2) {
      System.out.println("\nEnter Seat Capacity");
      int seating = input.nextInt();
      System.out.println("Enter Cargo Capacity");
      int cargo = input.nextInt();
      vehicle = new SUV(description, mpg, vin, seating, cargo);
      agency_vehicles.add(vehicle);
      System.out.println("New SUV Added!");
    } else if (vehicleType == 3) {
      System.out.println("\nEnter Load Capacity");
      int load = input.nextInt();
      vehicle = new Truck(description, mpg, vin, load);
      agency_vehicles.add(vehicle);
      System.out.println("New Truck Added!");
    } else
      System.out.println("Invalid Input");
  }

  public void reserveVehicle() {
    Vehicle testVeh;
    System.out.println("Please input the vehicle VIN number.");
    String vin = input.next();
    try {
      testVeh = agency_vehicles.getVehicle(vin);
    } catch (VINNotFoundException e) {
      System.out.println(e);
      return;
    }

    System.out.println("Please enter your Credit Card Number.");
    String cardNumber = input.next();

    System.out.println("Please enter D, W, or M for the duration of your rental. (D - Days, W - Weeks, or M - Months)");
    String rentalDuration = input.next();

    System.out.println("Please enter your rental time.");
    int rentalTime = input.nextInt();
    TimeSpan time = new TimeSpan(rentalDuration.charAt(0), rentalTime);

    boolean gettingInsurance;
    System.out.println("Would you like to add insurance? (Y/N)");
    String insuranceChoice = input.next();
    if (insuranceChoice.equals("Y"))
      gettingInsurance = true;
    else
      gettingInsurance = false;

    Reservation res1 = new Reservation(cardNumber, time, gettingInsurance);

    try {
      testVeh.reserve(res1);
      System.out.println("Reservation Complete");
    } catch (ReservedVehicleException e) {
      System.out.println(e);
    }
  }

  public void displayReservation() {
    Vehicle testVeh;
    System.out.println("Please input the vehicle VIN number.");
    String vin = input.next();

    try {
      testVeh = agency_vehicles.getVehicle(vin);
    } catch (VINNotFoundException e) {
      System.out.println(e);
      return;
    }

    if (testVeh.getReservation() != null)
      System.out.println(testVeh.getReservation().toString());
    else
      System.out.println("Vehicle Available");
  }

  public void cancelReservation() {
    Vehicle testVeh;
    System.out.println("Please input the vehicle VIN number.");
    String vin = input.next();

    try {
      testVeh = agency_vehicles.getVehicle(vin);
    } catch (VINNotFoundException e) {
      System.out.println(e);
      return;
    }

    try {
      testVeh.cancelReservation();
      System.out.println("\nReservation Cancelled");
    } catch (UnreservedVehicleException e) {
      System.out.println(e);
    }
  }
}

