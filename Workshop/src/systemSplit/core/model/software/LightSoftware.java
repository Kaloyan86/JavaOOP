package systemSplit.core.model.software;

public class LightSoftware extends Software {
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, Type.LIGHT, capacityConsumption, memoryConsumption);
    }

    @Override
    public int getCapacityConsumption() {
        int baseCapacity = super.getCapacityConsumption();
        baseCapacity += baseCapacity / 2;
        return baseCapacity;
    }

    @Override
    public int getMemoryConsumption() {
        int baseMemory = super.getMemoryConsumption();
        baseMemory -= baseMemory / 2;
        return baseMemory;
    }
}
