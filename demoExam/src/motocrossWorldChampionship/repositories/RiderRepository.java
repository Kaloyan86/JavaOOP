package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.*;

public class RiderRepository implements Repository<Rider> {

    private Collection<Rider> data;

    public RiderRepository() {
        this.data = new ArrayList<>();
    }


    @Override
    public Rider getByName(String name) {
        return this.data.stream().filter(rider -> rider.getName().equals(name)).limit(1).findFirst().orElse(null);
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(this.data);
    }

    @Override
    public void add(Rider model) {
        this.data.add(model);
    }

    @Override
    public boolean remove(Rider model) {

        return this.data.removeIf(r -> r.getName().equals(model.getName()));
    }
}
