/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class SUV extends Vehicle {
  private int seating;
  private int cargo;

  public SUV(String description, int mpg, String vin, int seating, int cargo) {
    super(description, mpg, vin);
    this.seating = seating;
    this.cargo = cargo;
  }

  public SUV(Vehicle vehicle, int seating, int cargo) {
    this(vehicle.getDescription(), vehicle.getMpg(), vehicle.getVin(), seating, cargo);
  }

  public String toString() {
    return getDescription() + " (SUV) " + " MPG: " + getMpg() + " Seating: " + seating + " Cargo Capacity: " + cargo
        + " VIN Number: " + getVin();
  }
}