package systemSplit.core.system;

import systemSplit.core.model.hardware.Hardware;
import systemSplit.core.model.software.Software;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class SystemSplit {

    private Map<String, Hardware> hardwareComponents;

    public SystemSplit() {
        this.hardwareComponents = new LinkedHashMap<>();
    }

    public void addHardwareComponent(Hardware hardware) {
        this.hardwareComponents.put(hardware.getName(), hardware);
    }

    public void addSoftwareToHardware(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            hardwareComponents.get(hardwareName).addSoftware(software);
        }
    }
    public void releaseSoftware(String hardwareName, String softwareName) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.removeSoftware(softwareName);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.hardwareComponents.values().stream().sorted((h1,h2)->{
            if (h1.getType().equalsIgnoreCase("Power")){
                return -1;
            }else {
                return 1;
            }
        }).forEach(h->{
            sb.append(h.toString());
            sb.append(System.lineSeparator());
        });
        return sb.toString().trim();
    }

    public int getHardwareComponentSize() {
        return this.hardwareComponents.size();
    }

    public int getSoftwareComponentCount() {
        return this.getSumValues(Hardware::getSoftwareCount);
    }

    public int getTotalOperationalMemoryInUse() {
        return this.getSumValues(Hardware::getUsedMemory);
    }

    public int getTotalCapacityTaken() {
        return this.getSumValues(Hardware::getUsedCapacity);
    }

    public int getMaximumMemory() {
        return this.getSumValues(Hardware::getMaximumMemory);
    }

    public int getMaximumCapacity() {
        return this.getSumValues(Hardware::getMaximumCapacity);
    }

    private int getSumValues(ToIntFunction<Hardware> func) {
        return this.hardwareComponents.values().stream().mapToInt(func).sum();
    }


}
