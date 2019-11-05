package systemSplit.core.model.software;



public abstract class Software {

    private String name;
    private Type type;
    private int capacityConsumption;
    private int memoryConsumption;

    public Software(String name, Type type, int capacityConsumption, int memoryConsumption) {
        this.name = name;
        this.type = type;
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
    }

    public String getName() {
        return name;
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    protected enum Type{
        EXPRESS,
        LIGHT
    }
}
