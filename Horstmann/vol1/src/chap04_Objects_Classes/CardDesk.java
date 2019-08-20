package chap04_Objects_Classes;

public class CardDesk {
    private Card[] cards;

    public CardDesk() {
        cards = new Card[64];
        for (int i = 0; i < 64; i += 4) {
            for (int j = i; j < 4; j++) {
                cards[j] = new Card(j, j);
            }
        }
    }

    public void shuffle() {
        System.out.println("shuffle");
    }

    public Card getTop() {
        return null;
    }

    public void draw() {
        System.out.println("draw");
    }
}
