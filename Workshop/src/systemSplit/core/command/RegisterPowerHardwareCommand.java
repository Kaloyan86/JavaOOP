package systemSplit.core.command;

import systemSplit.core.model.hardware.Hardware;
import systemSplit.core.model.hardware.PowerHardware;
import systemSplit.core.system.SystemSplit;

public class RegisterPowerHardwareCommand extends BaseCommand {
    private SystemSplit systemSplit;
    private String name;
    private int capacity;
    private int memory;

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
        this.name = (String) args[1];
        this.capacity = Integer.parseInt(args[2].toString());
        this.memory = Integer.parseInt(args[3].toString());
    }

    public RegisterPowerHardwareCommand(Object... args) {
        super(args);
    }

    @Override
    public void execute() {
        Hardware hardware = new PowerHardware(this.name, this.capacity, this.memory);
        this.systemSplit.addHardwareComponent(hardware);
    }
}
