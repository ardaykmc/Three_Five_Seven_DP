package game;

public class Box {
    private Shape shape;
    private Card card;
    private float point;
    public Box(Shape shape, Card card, float point) {
        this.shape = shape;
        this.card = card;
        this.point = point;
    }

    public Box(Shape shape) {
        this.shape = shape;
    }

    public Box(float point){
        this.point = point;
    }

    public Box() {
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
