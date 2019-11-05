package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Rider;

public class RiderImpl implements Rider {

    private static final int MIN_NAME_LENGTH = 5;

    private String name;

    private Motorcycle motorcycle;

    private int numberOfWins;

    private boolean canParticipate;

    public RiderImpl(String name) {
        this.setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return this.motorcycle;
    }

    public void addMotorcycle(Motorcycle motorcycle) {
        if (null == motorcycle) {
            throw new NullPointerException(ExceptionMessages.MOTORCYCLE_INVALID);
        }

        this.canParticipate = true;
        this.motorcycle = motorcycle;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    public boolean getCanParticipate() {
        return this.canParticipate && this.getMotorcycle() != null;
    }

    private void setName(String name) {
        if (null == name || name.isEmpty() || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, MIN_NAME_LENGTH));
        }

        this.name = name;
    }
}
