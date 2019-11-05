package motocrossWorldChampionship.entities;


import motocrossWorldChampionship.common.ExceptionMessages;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;

public abstract class MotorcycleImpl implements Motorcycle {

    private static final int MIN_MODEL_LENGTH = 4;

    private String model;

    private int horsePower;

    private double cubicCentimeters;

    public MotorcycleImpl(String model, int horsePower, double cubicCentimeters) {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setCubicCentimeters(cubicCentimeters);
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }
    
    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters() / this.getHorsePower() * laps;
    }

    protected abstract int getPowerMin();

    protected abstract int getPowerMax();

    private void setModel(String model) {
        if (null == model || model.trim().isEmpty() || model.length() < MIN_MODEL_LENGTH) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_MODEL, model, MIN_MODEL_LENGTH));
        }

        this.model = model;
    }

    private void setHorsePower(int horsePower) {
        if (horsePower < this.getPowerMin() || horsePower > this.getPowerMax()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }

        this.horsePower = horsePower;
    }

    private void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

}
