package motocrossWorldChampionship.entities;

public class SpeedMotorcycle extends MotorcycleImpl {

    private static final double CUBIC_CENTIMETERS = 125;

    private static final int MIN_POWER = 50;

    private static final int MAX_POWER = 69;

    public SpeedMotorcycle(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS);
    }

    @Override
    protected int getPowerMin() {
        return MIN_POWER;
    }

    @Override
    protected int getPowerMax() {
        return MAX_POWER;
    }
}
