package vehicles;

public class Truck extends Vehicles {
    private static final double ADD_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, ADD_CONSUMPTION, tankCapacity);
    }


    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * 0.95);
    }
    public void setFuelConsumption(){
        super.setFuelConsumption(getFuelConsumption());
    }
}
