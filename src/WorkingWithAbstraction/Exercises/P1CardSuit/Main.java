package WorkingWithAbstraction.Exercises.P1CardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CardSuits[] cardSuit = CardSuits.values();
        System.out.println(reader.readLine() + ":");
        Arrays.stream(cardSuit).forEach(e -> System.out.printf("Ordinal value: %d; Name value: %s\n", e.ordinal(), e.name()));
    }
}
