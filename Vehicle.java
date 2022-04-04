/* Abednego Njike, Zachary Bazzle, & David Blaine */
public abstract class Vehicle {
  private String description;
  private int mpg;
  private String vin;
  private Reservation resv = null;

  public Vehicle(String description, int mpg, String vin) {
    this.description = description;
    this.mpg = mpg;
    this.vin = vin;
  }

  public String getDescription() {
    return this.description;
  }

  public int getMpg() {
    return this.mpg;
  }

  public String getVin() {
    return this.vin;
  }

  public Reservation getReservation() {
    return this.resv;
  }

  public abstract String toString();

  public boolean isReserved() {
    return this.resv != null;
  }

  public void reserve(Reservation r) throws ReservedVehicleException {

    if (!isReserved()) {
      this.resv = r;
      return;
    }
    new ReservedVehicleException(
        "The vehicle with the VIN number " + this.vin + " has already been reserved. Please select an alternative.");
  }

  public void cancelReservation() throws UnreservedVehicleException {
    if (isReserved()) {
      this.resv = null;
      return;
    }
    new UnreservedVehicleException("The vehicle with the VIN number " + this.vin + " is available.");
  }

}