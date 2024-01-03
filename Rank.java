public enum Rank {
    DUECE(2, "Two"), THREE(3, "Three"),
    FOUR(4, "Four"), FIVE(5, "Five"), SIX(6, "Six"),
    SEVEN(7, "Seven"), EIGHT(8, "Eight"), NINE(9, "Nine"),
    TEN(10, "Ten"), JACK(10, "Jack"), Queen(10, "Queen"),
    KING(10, "King"), ACE(11, "Ace");

    private final int rankValue;
    private final String rankString;

    private Rank(int rankValue, String rankString) {
        this.rankValue = rankValue;
        this.rankString = rankString;
    }

    public int getRank() {
        return this.rankValue;
    }

    public String printRank() {
        return this.rankString;
    }
}
