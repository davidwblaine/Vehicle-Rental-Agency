/* Abednego Njike, Zachary Bazzle, & David Blaine */
import java.util.*;

public class Vehicles {
  private VehicleNode current;
  private VehicleNode head;

  public Vehicles(VehicleNode agency_vehicles) {
    this.head = agency_vehicles;
    this.current = agency_vehicles;
  }

  public Vehicles() {
    this(null);
  }

  public void add(Vehicle v) {
    if (head == null) {
      head = new VehicleNode(v, null);
    } else {
      VehicleNode tempPtr = head;
      while (tempPtr.getNext() != null) {
        tempPtr = tempPtr.getNext();
      }
      tempPtr.setNext(new VehicleNode(v, null));
    }
  }

  public void reset() {
    this.current = this.head;
  }

  public boolean hasNext() {
    return (this.current.getNext() != null);
  }

  public Vehicle getNext() {
    this.current = this.current.getNext();
    return this.current.getVehicle();
  }

  public Vehicle getVehicle(String vin) throws VINNotFoundException {
    VehicleNode tempPtr = head;
    while (tempPtr != null) {
      if (tempPtr.getVehicle().getVin().equals(vin)) {
        return tempPtr.getVehicle();
      }
      else {
        tempPtr = tempPtr.getNext();
      }
    }
    throw new VINNotFoundException("There is no vehicle with the VIN " + vin + " in this database. Please try again.");
  }
}