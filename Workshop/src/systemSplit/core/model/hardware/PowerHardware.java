package systemSplit.core.model.hardware;

import systemSplit.core.model.software.Software;

public class PowerHardware extends Hardware {




    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, Type.POWER, maximumCapacity, maximumMemory);

    }

    @Override
    public int getMaximumCapacity() {
        int baseCapacity = super.getMaximumCapacity();
        baseCapacity -= ((baseCapacity * 3) / 4);
        return baseCapacity - super.getUsedCapacity();
    }

    @Override
    public int getMaximumMemory() {
        int baseMemory = super.getMaximumMemory();
        baseMemory += ((baseMemory * 3) / 4);
        return baseMemory - super.getUsedMemory();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
