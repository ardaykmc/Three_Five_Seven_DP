package game;

public class Box {
    private Shape shape;
    private Card card;
    private float point;
    private int raw;
    private int column;
    public Box(Shape shape, Card card, float point) {
        this.shape = shape;
        this.card = card;
        this.point = point;
        this.raw = 0;
        this.column = 0;
    }

    public Box(Shape shape, Card card, float point, int raw, int column) {
        this.shape = shape;
        this.card = card;
        this.point = point;
        this.raw = raw;
        this.column = column;
    }

    public Box(float point, int raw, int column) {
        this.point = point;
        this.raw = raw;
        this.column = column;
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

    public int getRaw() {
        return raw;
    }

    public void setRaw(int raw) {
        this.raw = raw;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
