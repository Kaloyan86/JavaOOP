package motocrossWorldChampionship.entities;

public class PowerMotorcycle extends MotorcycleImpl {

    private static final double CUBIC_CENTIMETERS = 450;

    private static final int MIN_POWER = 70;

    private static final int MAX_POWER = 100;

    public PowerMotorcycle(String model, int horsePower) {
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
