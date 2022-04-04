/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class Car extends Vehicle {
  private int seating;

  public Car(String description, int mpg, String vin, int seating) {
    super(description, mpg, vin);
    this.seating = seating;
  }

  public Car(Vehicle vehicle, int seating) {
    this(vehicle.getDescription(), vehicle.getMpg(), vehicle.getVin(), seating);
  }

  public String toString() {
    return getDescription() + " (Car) " + " MPG: " + getMpg() + " Seating: " + seating + " VIN Number: " + getVin();
  }
}
