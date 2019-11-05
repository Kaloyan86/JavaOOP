package systemSplit.core.command;

import systemSplit.core.model.software.ExpressSoftware;
import systemSplit.core.model.software.Software;
import systemSplit.core.system.SystemSplit;

public class RegisterExpressSoftwareCommand extends BaseCommand {

    private SystemSplit systemSplit;
    private String hardwareComponentName;
    private String name;
    private int capacity;
    private int memory;

    public RegisterExpressSoftwareCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
        this.hardwareComponentName = args[1].toString();
        this.name = args[2].toString();
        this.capacity = Integer.parseInt(args[3].toString());
        this.memory = Integer.parseInt(args[4].toString());
    }

    @Override
    public void execute() {
        Software software = new ExpressSoftware(this.name, this.capacity, this.memory);
        this.systemSplit.addSoftwareToHardware(this.hardwareComponentName, software);

    }
}
