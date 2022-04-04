/* Abednego Njike, Zachary Bazzle, & David Blaine */
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class SystemInterface {

    private static CurrentRates agency_rates;
    private static Vehicles agency_vehicles;
    private static Accounts accounts;
    private static Transactions transactions_history;
    public static final NumberFormat formatter = new DecimalFormat("#0.00");

    private SystemInterface() {
        throw new IllegalStateException("Utility class");
    }

    // used to init static variables (in place of a constructor)
    public static void initSystem(CurrentRates r, Vehicles v, Accounts a, Transactions t) {

        agency_rates = r;
        agency_vehicles = v;
        accounts = a;
        transactions_history = t;
    }

    // Note that methods makeReservation, cancelReservation, addAccount, and
    // updateXXXRates return
    // an acknowledgement of successful completion of the requested action (e.g.
    // “Vehicle QK3FL4273ME
    // successfully reserved”). Method processReturnedVehicle returns the final cost
    // for the returned
    // vehicle (e.g., “Total charge for VIN QK3FL4273ME for 3 days, 233 miles @
    // 0.15/mile and daily
    // insurance @ 14.95/day (with 100 miles credit as Prime customer) = $xxx.xx.)
    // Current Rates Related Methods
    public static String[] getCarRates() {
        String[] message = new String[1];
        message[0] = agency_rates.getCarRates().toString();
        return message;
    }

    public static String[] getSUVRates() {
        String[] message = new String[1];
        message[0] = agency_rates.getSUVRates().toString();
        return message;
    }

    public static String[] getTruckRates() {
        String[] message = new String[1];
        message[0] = agency_rates.getTruckRates().toString();
        return message;
    }

    public static String[] updateCarRates(VehicleRates r) {
        String[] message = new String[1];
        agency_rates = new CurrentRates((CarRates) r, (SUVRates) agency_rates.getSUVRates(),
                (TruckRates) agency_rates.getTruckRates());
        message[0] = "Succesfully Updated Car Rates!";
        return message;
    }

    public static String[] updateSUVRates(VehicleRates r) {
        String[] message = new String[1];
        agency_rates = new CurrentRates((CarRates) agency_rates.getCarRates(), (SUVRates) r,
                (TruckRates) agency_rates.getTruckRates());
        message[0] = "Succesfully Updated SUV Rates!";
        return message;
    }

    public static String[] updateTruckRates(VehicleRates r) {
        String[] message = new String[1];
        agency_rates = new CurrentRates((CarRates) agency_rates.getCarRates(), (SUVRates) agency_rates.getSUVRates(),
                (TruckRates) r);
        message[0] = "Succesfully Updated Truck Rates!";
        return message;
    }

    public static String[] estimatedRentalCost(RentalDetails details) {
        String[] message = new String[1];
        double amount = agency_rates.calcEstimatedCost(details.getVehicleType() - 1, details.getRentalPeriod(),
                details.getEstimatedNumMiles(), details.getDailyInsur(), details.getPrimeCustomer());
        message[0] = "Estmated Rental Cost: " + formatter.format(amount);

        return message;
    }

    public static String[] processReturnedVehicle(String vin, int num_days_used, int num_miles_driven) {
        String[] message = new String[1];

        try {
            Vehicle vehicle = agency_vehicles.getVehicle(vin);
            if (!vehicle.isReserved()) {
                throw new UnreservedVehicleException("Vehicle (" + vin + ") is not Reserved!");
            }
            double total = agency_rates.calcActualCost(vehicle.getQuotedRates(), num_days_used, num_miles_driven,
                    vehicle.getReservation().getInsurance(),
                    accounts.getAccount(vehicle.getReservation().getCardNum()).primeCustomer());
            message[0] = "Total charge for VIN (" + vin + ")  is $" + formatter.format(total);
            Transaction T = new Transaction(vehicle.getReservation().getCardNum(),
                    accounts.getAccount(vehicle.getReservation().getCardNum()).getCompany(),
                    vehicle.getClass().getSimpleName(), new TimeSpan(num_days_used), Double.toString(total));
            transactions_history.add(T);
            vehicle.cancelReservation();
        } catch (Exception e) {
            message[0] = e.toString();
        }
        return message;

        // Total charge for VIN QK3FL4273ME for 3 days, 233 miles @ 0.15/mile and daily
        // insurance @ 14.95/day (with 100 miles credit as Prime customer) = $xxx.xx.

    }
    // Note that the rates to be used are retrieved from the VehicleRates object
    // stored in the specific rented
    // vehicle object, the daily insurance option is retrieved from the Reservation
    // object of the rented
    // vehicle, and whether they are a Prime customer is retrived from the Customer
    // Account object vehicle
    // associated with the Reservation object associated with the specific rented
    // vehicle.

    // Vehicle Related Methods
    public static String[] getAvailCars() {
        String[] vehicleStrings = new String[0];
        VehicleNode temp = agency_vehicles.getNode();
        while (temp != null) {
            if (temp.getVehicle() instanceof Car && !(temp.getVehicle().isReserved())) {
                String[] newLength = Arrays.copyOf(vehicleStrings, vehicleStrings.length + 1);
                newLength[vehicleStrings.length] = temp.getVehicle().toString();
                vehicleStrings = newLength;
            }
            temp = temp.getNode();
        }
        return vehicleStrings;
    }

    public static String[] getAvailSUVs() {
        String[] vehicleStrings = new String[0];
        VehicleNode temp = agency_vehicles.getNode();
        while (temp != null) {
            if (temp.getVehicle() instanceof SUV && !(temp.getVehicle().isReserved())) {
                String[] newLength = Arrays.copyOf(vehicleStrings, vehicleStrings.length + 1);
                newLength[vehicleStrings.length] = temp.getVehicle().toString();
                vehicleStrings = newLength;
            }
            temp = temp.getNode();
        }
        return vehicleStrings;
    }

    public static String[] getAvailTrucks() {
        String[] vehicleStrings = new String[0];
        VehicleNode temp = agency_vehicles.getNode();
        while (temp != null) {
            if (temp.getVehicle() instanceof Truck && !(temp.getVehicle().isReserved())) {
                String[] newLength = Arrays.copyOf(vehicleStrings, vehicleStrings.length + 1);
                newLength[vehicleStrings.length] = temp.getVehicle().toString();
                vehicleStrings = newLength;
            }
            temp = temp.getNode();
        }
        return vehicleStrings;
    }

    public static String[] getAllVehicles() {
        String[] vehicleStrings = new String[0];
        VehicleNode temp = agency_vehicles.getNode();
        while (temp != null) {
            String[] newLength = Arrays.copyOf(vehicleStrings, vehicleStrings.length + 1);
            newLength[vehicleStrings.length] = temp.getVehicle().toString();
            vehicleStrings = newLength;
            temp = temp.getNode();
        }
        return vehicleStrings;
    }

    public static String[] makeReservation(ReservationDetails details) {
        String[] message = new String[1];
        try {
            Vehicle vehicle = agency_vehicles.getVehicle(details.getVIN());
            vehicle.setReservation(new Reservation(accounts.getAccount(details.getCreditCardNum()).getCreditCardNum(),
                    details.getRentalPeriod(), details.getInsuranceSelected()));
            if (vehicle instanceof Car) {
                vehicle.setQuotedRates(agency_rates.getCarRates());
            } else if (vehicle instanceof SUV) {
                vehicle.setQuotedRates(agency_rates.getSUVRates());
            } else {
                vehicle.setQuotedRates(agency_rates.getTruckRates());
            }
            message[0] = "Vehicle (" + vehicle.getVIN() + ") succesfully reserved!";
        } catch (Exception e) {
            message[0] = e.toString();
        }
        return message;
    }

    public static String[] cancelReservation(String vin) {
        String[] message = new String[1];
        try {
            Vehicle vehicle = agency_vehicles.getVehicle(vin);
            vehicle.cancelReservation();
            message[0] = "Vehicle (" + vehicle.getVIN() + ") succesfully available!";
        } catch (Exception e) {
            message[0] = e.toString();
        }
        return message;
    }

    public static String[] getReservation(String vin) {
        String[] message = new String[1];
        try {
            Vehicle vehicle = agency_vehicles.getVehicle(vin);
            message[0] = vehicle.getReservation().toString();
        } catch (Exception e) {
            message[0] = e.toString();
        }
        return message;
    }

    public static String[] getAllReservations() {
        String[] vehicleStrings = new String[0];
        VehicleNode temp = agency_vehicles.getNode();
        while (temp != null) {
            if (temp.getVehicle().getReservation() != null) {
                String[] newLength = Arrays.copyOf(vehicleStrings, vehicleStrings.length + 1);
                newLength[vehicleStrings.length] = temp.getVehicle().getReservation().toString();
                vehicleStrings = newLength;
            }
            temp = temp.getNode();
        }
        if (vehicleStrings.length == 0) {
            vehicleStrings = new String[1];
            vehicleStrings[0] = "There are no Reservations!";
        }
        return vehicleStrings;
    }

    // Customer Accounts Related Methods
    public static String[] addAccount(String creditcard, String company_name, boolean prime_cust) {
        String[] message = new String[1];
        try {
            accounts.getAccount(creditcard);
            message[0] = "Account (" + creditcard + ") already exists!";
        } catch (AccountNotFoundException e) {
            accounts.add(new AccountNode(new Account(creditcard, company_name, prime_cust)));
            message[0] = "Succesfully Added Account " + company_name;
        } catch (Exception e) {
            message[1] = e.toString();
        }
        return message;
    }

    public static String[] getAccount(String creditcard_num) {
        String[] message = new String[1];
        try {
            Account account = accounts.getAccount(creditcard_num);
            message[0] = account.toString() + "\n";
            VehicleNode temp = agency_vehicles.getNode();
            while (temp != null) {
                if (temp.getVehicle().getReservation() != null
                        && temp.getVehicle().getReservation().getCardNum().equals(creditcard_num)) {
                    String[] newLength = Arrays.copyOf(message, message.length + 1);
                    newLength[message.length] = temp.getVehicle().toString() + "\n "
                            + temp.getVehicle().getReservation().toString();
                    message = newLength;
                }
                temp = temp.getNode();
            }
        } catch (Exception e) {
            message[0] = e.toString();
        }

        return message;
    }

    public static String[] getAllAccounts() {
        String[] vehicleStrings = new String[0];
        AccountNode temp = accounts.getNode();
        while (temp != null) {
            String[] newLength = Arrays.copyOf(vehicleStrings, vehicleStrings.length + 1);
            newLength[vehicleStrings.length] = temp.getAccount().toString();
            vehicleStrings = newLength;
            temp = temp.getNode();
        }
        if (vehicleStrings.length == 0) {
            vehicleStrings = new String[1];
            vehicleStrings[0] = "There are no Accounts!";
        }
        return vehicleStrings;
    }

    // transactions-related methods
    public static String[] getAllTransactions() {
        String[] message = new String[0];
        transactions_history.reset();
        while (transactions_history.hasNext()) {
            String[] newLength = Arrays.copyOf(message, message.length + 1);
            newLength[message.length] = transactions_history.getNext().toString();
            message = newLength;
        }
        if (message.length == 0) {
            message = new String[1];
            message[0] = "There are no Reservations!";
        }
        return message;
    }

    public static String responceValidator(Scanner console, String... acceptedStrings) {
        String responce;
        while (true) {
            responce = console.next().split("")[0];
            if (Arrays.stream(acceptedStrings).anyMatch(responce::equalsIgnoreCase)) {
                break;
            } else {
                System.out.println();
                System.out.print("Error: Unknown Responce! Please use, " + Arrays.toString(acceptedStrings) + ": ");
            }
        }
        return responce;

    }

    public static boolean initialized() {
        return (agency_rates != null);
    }
}