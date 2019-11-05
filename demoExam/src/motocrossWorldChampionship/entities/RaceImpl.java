package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RaceImpl implements Race {

    private static final int MIN_NAME_LENGTH = 5;

    private static final int MIN_LAPS = 1;

    private String name;

    private int laps;

    private Collection<Rider> riders;

    private Map<String, Rider> ridersByName;

    public RaceImpl(String name, int laps) {
        this.setName(name);
        this.setLaps(laps);
        this.riders = new ArrayList<>();
        this.ridersByName = new HashMap<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return this.riders;
    }

    @Override
    public void addRider(Rider rider) {
        if (null == rider) {
            throw new NullPointerException(ExceptionMessages.RIDER_INVALID);
        }

        if (!rider.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_NOT_PARTICIPATE, rider.getName()));
        }

        if (this.ridersByName.containsKey(rider.getName())) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_ALREADY_ADDED, rider.getName(), this.getName()));
        }

        this.riders.add(rider);
        this.ridersByName.put(rider.getName(), rider);
    }

    private void setName(String name) {
        if (null == name || name.isEmpty() || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, MIN_NAME_LENGTH));
        }

        this.name = name;
    }

    private void setLaps(int laps) {
        if (laps < MIN_LAPS) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, MIN_LAPS));
        }

        this.laps = laps;
    }

}
