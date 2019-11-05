package systemSplit.core.command;

import systemSplit.core.system.DumpExtension;

public class DumpAnalyzeCommand extends BaseCommand {

    private DumpExtension dumpExtension;

    public DumpAnalyzeCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.dumpExtension = (DumpExtension) args[0];
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();

        long powerHardwareComponentsCount = this.dumpExtension.getPowerHardwareComponentCount();
        long heavyHardwareComponentsCount = this.dumpExtension.getHeavyHardwareComponentCount();
        long expressSoftwareComponents = this.dumpExtension.getExpressSoftwareComponentsCount();
        long lightSoftwareComponents = this.dumpExtension.getLightSoftwareComponentsCount();

        int totalDumpedMemory = this.dumpExtension.getTotalDumpedMemoryInUse();
        int totalDumpedCapacity = this.dumpExtension.getTotalDumpedCapacityTaken();

        sb.append("Dump Analysis");
        sb.append(System.lineSeparator());

        sb.append(String.format("Power Hardware Components: %d%n", powerHardwareComponentsCount));
        sb.append(String.format("Heavy Hardware Components: %d%n", heavyHardwareComponentsCount));

        sb.append(String.format("Express Software Components: %d%n", expressSoftwareComponents));
        sb.append(String.format("Light Software Components: %d%n", lightSoftwareComponents));
        sb.append(String.format("Total Dumped Memory: %d%n", totalDumpedMemory));
        sb.append(String.format("Total Dumped Capacity: %d%n", totalDumpedCapacity));

        System.out.println(sb.toString());

    }
}
