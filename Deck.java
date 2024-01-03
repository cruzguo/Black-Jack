import java.util.ArrayList;
import java.util.Random;
public class Deck {

    ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        populate();
        split();
        shuffle();
    }
    public void populate() {
        for (int s = 0; s < Suit.values().length; s++) {
            for (int r = 0; r < Rank.values().length; r++) {
                Card card = new Card(Rank.values()[r], Suit.values()[s]);
                cards.add(card);
            }
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int randIndex = rand.nextInt(i);
            Card randCard = cards.get(randIndex);
            Card currentCard = cards.get(i);
            cards.set(i, randCard);
            cards.set(randIndex, currentCard);
        }
    }

    public void split() {
        ArrayList<Card> topHalf = new ArrayList<>();
        ArrayList<Card> bottomHalf = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            if (i < cards.size() / 2) {
                bottomHalf.add(cards.get(i));
            }
            if (i >= cards.size() / 2) {
                topHalf.add(cards.get(i));
            }
        }
        ArrayList<Card> newSplit = new ArrayList<>();
        newSplit.addAll(topHalf);
        newSplit.addAll(bottomHalf);
        cards = newSplit;
    }

    public Card drawCard() {
        Card draw = cards.get(0);
        cards.remove(0);
        return draw;
    }
}
