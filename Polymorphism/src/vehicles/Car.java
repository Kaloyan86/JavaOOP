package vehicles;

public class Car extends Vehicles {
    private static final double ADD_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption,ADD_CONSUMPTION, tankCapacity);
    }
    public void setFuelConsumption(){
        super.setFuelConsumption(getFuelConsumption());
    }
}
