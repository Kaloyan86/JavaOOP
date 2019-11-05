package carShop;

public class Seat extends CarImpl implements Sellable {
    private double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return price;
    }
    @Override
    public String toString() {
        String format = "%s sells for %f";
        return super.toString()+System.lineSeparator()+String.format(format,this.getModel(),this.getPrice());
    }
}
