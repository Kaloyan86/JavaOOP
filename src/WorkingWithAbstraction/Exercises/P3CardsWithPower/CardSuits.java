package WorkingWithAbstraction.Exercises.P3CardsWithPower;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    int values;

    CardSuits(int values) {
        this.values = values;
    }

    public int getValues() {
        return values;
    }
}
