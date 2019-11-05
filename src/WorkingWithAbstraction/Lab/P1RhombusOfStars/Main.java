package WorkingWithAbstraction.Lab.P1RhombusOfStars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int row = 1; row <= n; row++) {
            printCurrentRow(n, row);
        }
        for (int row = n - 1; row > 0; row--) {
            printCurrentRow(n, row);
        }
    }

    private static void printCurrentRow(int n, int row) {
        System.out.print(printSpace(" ", n - row));
        System.out.print(printSpace("* ", row));
        System.out.println();
    }

    private static String printSpace(String space, int count) {
        StringBuilder sb = new StringBuilder();

        while (count-- > 0) {
            sb.append(space);
        }
        return sb.toString();
    }
}
