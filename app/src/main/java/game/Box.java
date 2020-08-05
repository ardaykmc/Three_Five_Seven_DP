package game;

public class Box {
    private Shape shape;
    private Card card;

    public Box(Shape shape, Card card) {
        this.shape = shape;
        this.card = card;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
