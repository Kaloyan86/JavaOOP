package systemSplit.core.engine;

import systemSplit.core.command.Command;
import systemSplit.core.command.factory.CommandFactory;
import systemSplit.core.reader.Reader;
import systemSplit.core.system.SystemSplit;

import java.net.PortUnreachableException;

public class Engine {
    private static final String END_COMMAND = "System Split";
    private SystemSplit systemSplit;
    private Reader reader;

    public Engine(SystemSplit systemSplit, Reader reader) {
        this.systemSplit = systemSplit;
        this.reader = reader;
    }

    public void run() {
        String line = this.reader.readLine();
        while (!END_COMMAND.equalsIgnoreCase(line)) {
            String[] tokens = line.split("[\\(\\,\\s\\)]+");
            String commandName = tokens[0];
            Object[] params = new Object[tokens.length];
            params[0] = this.systemSplit;
            for (int i = 1; i < tokens.length; i++) {
                params[i] = tokens[i];
            }
            Command command = CommandFactory.buildCommand(commandName, params);
            command.execute();
            line = this.reader.readLine();
        }
        Command command = CommandFactory.buildCommand("SystemSplit", this.systemSplit);
        command.execute();
    }
}
