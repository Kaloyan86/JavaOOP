package systemSplit.core.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;

public class ConsoleReader implements Reader {

    private static final BufferedReader READER;

    static {
        READER = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public String readLine() {
        try {
            return READER.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
