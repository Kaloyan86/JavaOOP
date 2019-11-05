package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;

import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.*;

public class MotorcycleRepository implements Repository<Motorcycle> {

    private Collection<Motorcycle> data;

    public MotorcycleRepository() {
        this.data = new ArrayList<>();
    }


    @Override
    public Motorcycle getByName(String name) {
        return this.data.stream()
                .filter(motorcycle -> motorcycle.getModel().equals(name)).limit(1).findFirst().orElse(null);
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(this.data);
    }

    @Override
    public void add(Motorcycle model) {
        this.data.add(model);
    }

    @Override
    public boolean remove(Motorcycle motorcycle) {

        return this.data.removeIf(r -> r.getModel().equals(motorcycle.getModel()));
    }
}
