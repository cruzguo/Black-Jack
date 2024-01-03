public enum Suit {
    HEARTS("Hearts"),
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");

    private final String suitText;
    private Suit(String suitText) {
        this.suitText = suitText;
    }

    public String printSuit() {
        return this.suitText;
    }
}
