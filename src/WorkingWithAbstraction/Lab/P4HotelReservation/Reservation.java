package WorkingWithAbstraction.Lab.P4HotelReservation;

public class Reservation {
    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private Discount discount;

    public Reservation(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discount = discount;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public Season getSeason() {
        return season;
    }

    public Discount getDiscount() {
        return discount;
    }
}
