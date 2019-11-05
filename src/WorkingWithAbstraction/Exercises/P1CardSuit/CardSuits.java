package WorkingWithAbstraction.Exercises.P1CardSuit;

public enum CardSuits {
    CLUBS(1),
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
