/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class Truck extends Vehicle {
  private int load;

  public Truck(String description, int mpg, String vin, int load) {
    super(description, mpg, vin);
    this.load = load;
  }

  public Truck(Vehicle vehicle, int load) {
    this(vehicle.getDescription(), vehicle.getMpg(), vehicle.getVin(), load);
  }

  public String toString() {
    return getDescription() + " (Truck) " + " MPG: " + getMpg() + " Load: " + load + " VIN Number: " + getVin();
  }
}