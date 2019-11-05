package systemSplit.core.command;

import systemSplit.core.system.DumpExtension;

public class DestroyCommand extends BaseCommand {


    private DumpExtension dumpExtension;
    private String hardwareComponentName;

    public DestroyCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArgs(Object... args) {
        this.dumpExtension = (DumpExtension) args[0];
        this.hardwareComponentName = args[1].toString();
    }

    @Override
    public void execute() {
        this.dumpExtension.destroyHardwareComponent(this.hardwareComponentName);
    }
}
