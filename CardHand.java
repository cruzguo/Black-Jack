import java.util.NoSuchElementException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
public class CardHand {
    private ObservableList<Node> cards;
    private SimpleIntegerProperty value = new SimpleIntegerProperty(0);
    private int aces = 0;

    public CardHand(ObservableList<Node> cards) {
        this.cards = cards;
    }

    public void clearCards() {
        cards.clear();
        value.set(0);
        aces = 0;
    }

    public void takeCard(Card card) {
        cards.add(card);
        if (card.printRank().equals("ACE")) {
            aces++;
        }
        if (value.get() + card.getRank() > 21 && aces > 0) {
            value.set(value.get() + card.getRank() - 10);  //count Ace as '1', not '11'
            aces--;
        } else {
            value.set(value.get() + card.getRank());
        }
    }

    public String showHand() {
        String show = "";
        for (int i = 0; i < cards.size(); i++) {
            show += cards.get(i).toString();
        }
        return show;
    }

    public boolean give(Card card, CardHand otherHand) throws NoSuchElementException {
        if (!cards.contains(card)) {
            return false;
        } else {
            int removeIndex = -1;
            Node remove = null;
            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i) == card) {
                    removeIndex = i;
                    break;
                }
            }
            if (removeIndex >= 0) {
                remove = cards.get(removeIndex);
            } else {
                throw new NoSuchElementException("The card could not be found.");
            }
            cards.remove(removeIndex);
            otherHand.takeCard((Card)remove);
            return true;
        }
    }
    public SimpleIntegerProperty valueProperty() {
        return value;
    }
}
