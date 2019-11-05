package vehicles;

public class Bus extends Vehicles {
    private static final double ADD_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption,ADD_CONSUMPTION, tankCapacity);

    }
    public void setFuelConsumption(){
        super.setFuelConsumption(getFuelConsumption());
    }
}
