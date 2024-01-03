import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
public class Card extends Parent {
    private Suit suit;
    private Rank rank;
    private boolean isFaceUp;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.isFaceUp = true;

        Rectangle card = new Rectangle(80, 100);
        card.setArcWidth(20);
        card.setArcHeight(20);
        card.setFill(Color.WHITE);

        Text text = new Text(toString());
        text.setWrappingWidth(70);

        getChildren().add(new StackPane(card, text));
    }

    public int getRank() {
        return rank.getRank();
    }
    public String printRank() {
        return rank.printRank();
    }

    public String getSuit() {
        return suit.printSuit();
    }

    public void flip() {
        if (this.isFaceUp) {
            this.isFaceUp = false;
        } else {
            this.isFaceUp = true;
        }
    }

    public String toString() {
        if (isFaceUp) {
            return String.format("%s of %s %n", rank.printRank(), suit.printSuit());
        } else {
            return String.format("The card is face down. %n");
        }
    }
}
