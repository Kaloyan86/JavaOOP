package systemSplit.core.system;

import systemSplit.core.model.hardware.Hardware;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class DumpExtension extends SystemSplit {

    private Map<String, Hardware> dumpHardwareCollection;
    private Map<String, Hardware> dumpedMemoryCollection;

    private Map<String, Hardware> sharedHardwareCollection;

    public DumpExtension() {
        this.dumpHardwareCollection = new LinkedHashMap<>();
        this.dumpedMemoryCollection = new LinkedHashMap<>();
        this.initialSharedHardware();
    }

    private void initialSharedHardware() {
        Class<?> systemSplitClass = this.getClass().getSuperclass();

        try {
            Field hardwareComponents = systemSplitClass.getDeclaredField("hardwareComponents");
            hardwareComponents.setAccessible(true);

            Field sharedHardwareCollection = this.getClass().getDeclaredField("sharedHardwareCollection");
            sharedHardwareCollection.setAccessible(true);

            sharedHardwareCollection.set(this, hardwareComponents.get(this));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void removeHardwareComponent(String hardwareComponentName) {
        dumpedMemoryCollection.put(hardwareComponentName, sharedHardwareCollection.get(hardwareComponentName));
        sharedHardwareCollection.remove(hardwareComponentName);
    }

    public void restoreHardwareComponent(String hardwareComponentName) {
        sharedHardwareCollection.put(hardwareComponentName, dumpedMemoryCollection.get(hardwareComponentName));
    }

    public void destroyHardwareComponent(String hardwareComponentName) {
        dumpedMemoryCollection.remove(hardwareComponentName);
        sharedHardwareCollection.remove(hardwareComponentName);
    }

    public long getPowerHardwareComponentCount() {
        return dumpedMemoryCollection.values().stream().filter(h -> h.getType().equalsIgnoreCase("Power")).count();

    }

    public long getHeavyHardwareComponentCount() {
        return dumpedMemoryCollection.values().stream().filter(h -> h.getType().equalsIgnoreCase("Heavy")).count();
    }

    public long getExpressSoftwareComponentsCount() {
        long count = 0;
        for (Hardware h : dumpedMemoryCollection.values()) {
            count += h.getSoftwares().stream().filter(s -> s.getClass().getSimpleName().equals("ExpressSoftware")).count();
        }
        return count;
    }
    public long getLightSoftwareComponentsCount() {
        long count = 0;
        for (Hardware h : dumpedMemoryCollection.values()) {
            count += h.getSoftwares().stream().filter(s -> s.getClass().getSimpleName().equals("LightSoftware")).count();
        }
        return count;
    }
    public int getTotalDumpedMemoryInUse() {
        return this.getSumValues(Hardware::getUsedMemory);
    }

    public int getTotalDumpedCapacityTaken() {
        return this.getSumValues(Hardware::getUsedCapacity);
    }
    private int getSumValues(ToIntFunction<Hardware> func) {
        return this.dumpedMemoryCollection.values().stream().mapToInt(func).sum();
    }
}
