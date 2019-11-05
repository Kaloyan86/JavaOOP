package WorkingWithAbstraction.Exercises.P2CardsRanks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CardsRanks[] cardsRanks = CardsRanks.values();
        System.out.println(reader.readLine()+":");
        Arrays.stream(cardsRanks)
                .forEach(e -> System.out.printf("Ordinal value: %d; Name value: %s\n", e.ordinal(), e.name()));

    }
}
