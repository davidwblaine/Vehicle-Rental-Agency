/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class VehicleNode {
  private Vehicle vehicle;
  private VehicleNode next;

  public VehicleNode(Vehicle veh, VehicleNode next) {
    this.vehicle = veh;
    this.next = next;
  }

  public VehicleNode(Vehicle name) {
    this(name, null);
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public VehicleNode getNext() {
    return next;
  }

  public void setNext(VehicleNode next) {
    this.next = next;
  }

}