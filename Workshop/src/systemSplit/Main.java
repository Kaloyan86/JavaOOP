package systemSplit;

import systemSplit.core.engine.Engine;
import systemSplit.core.reader.ConsoleReader;
import systemSplit.core.reader.Reader;
import systemSplit.core.system.DumpExtension;
import systemSplit.core.system.SystemSplit;

public class Main {
    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        SystemSplit systemSplit = new DumpExtension();
        Engine engine = new Engine(systemSplit, reader);
        engine.run();
    }
}
