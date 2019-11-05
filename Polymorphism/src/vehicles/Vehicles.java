package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles {
    public boolean airConditionIsOn;
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;
    private double additionalConsumption;

    protected Vehicles(double fuelQuantity, double fuelConsumption, double additionalConsumption, double tankCapacity) {
        this.airConditionIsOn = true;
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(fuelQuantity);
        this.additionalConsumption = additionalConsumption;
        this.setFuelConsumption(fuelConsumption);


    }

    public void setAirConditionIsOn(boolean airConditionIsOn) {
        this.airConditionIsOn = airConditionIsOn;
    }

    protected double getFuelConsumption() {
        return this.fuelConsumption;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (fuelQuantity <= this.tankCapacity){
            this.fuelQuantity = fuelQuantity;
        }else {
            this.fuelQuantity = 0;
        }

    }

    public void setFuelConsumption(double fuelConsumption) {
        if (airConditionIsOn) {
            this.fuelConsumption = fuelConsumption + additionalConsumption;
        } else {
            this.fuelConsumption = fuelConsumption;
        }

    }

    public String drive(double distance) {
        String output = null;

        double fuelNeeded = distance * this.fuelConsumption;
        if (fuelNeeded <= this.fuelQuantity) {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            this.fuelQuantity -= fuelNeeded;
            output = String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
        } else {
            output = String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        return output;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    public void refuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + fuel > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        this.fuelQuantity += fuel;

    }
}
