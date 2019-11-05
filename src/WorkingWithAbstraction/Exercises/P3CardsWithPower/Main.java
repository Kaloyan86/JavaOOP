package WorkingWithAbstraction.Exercises.P3CardsWithPower;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String cardRank = reader.readLine();
        String cardSuit = reader.readLine();

        CardsRanks cardsRanks = CardsRanks.valueOf(cardRank);
        CardSuits cardSuits = CardSuits.valueOf(cardSuit);
        Card card = new Card(cardSuits, cardsRanks);

        int power = card.getCardsRanks().getValues() + card.getCardSuits().getValues();
        System.out.printf("Card name: %s of %s; Card power: %d", card.getCardsRanks().name(),
                card.getCardSuits().name(), power);
    }
}
