/* Abednego Njike, Zachary Bazzle, & David Blaine */
public class Reservation {
  private String credit_card;
  private TimeSpan rentalPeriod;

  private boolean insuranceSelected;

  public Reservation(String credit_card, TimeSpan rentalPeriod, boolean insuranceSelected) {

    this.credit_card = credit_card;
    this.rentalPeriod = rentalPeriod;
    this.insuranceSelected = insuranceSelected;
  }

  public String toString() {
    return "\nCredit Card Number: " + getCreditCard() + "\nRental Period : " + getRental().getTimeSpan()
        + "\nInsurance Selected: " + getInsurance();
  }

  public String getCreditCard() {
    return this.credit_card;
  }

  public boolean getInsurance() {
    return this.insuranceSelected;
  }

  public TimeSpan getRental() {
    return this.rentalPeriod;
  }
}