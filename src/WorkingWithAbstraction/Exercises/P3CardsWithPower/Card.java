package WorkingWithAbstraction.Exercises.P3CardsWithPower;


public class Card {
    private CardSuits cardSuits;
    private CardsRanks cardsRanks;

    public Card(CardSuits cardSuits, CardsRanks cardsRanks) {
        this.cardSuits = cardSuits;
        this.cardsRanks = cardsRanks;
    }

    public CardSuits getCardSuits() {
        return cardSuits;
    }

    public CardsRanks getCardsRanks() {
        return cardsRanks;
    }
}
