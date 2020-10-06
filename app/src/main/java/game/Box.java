package game;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Box implements ICopyConstructor<Box>{
    private Shape shape;
    private Card card;
    private float point;
    private int raw;
    private int column;

    /**
     *
     * @param box is copy constructor
     */
    public Box copyConstructor(Box box){
        Shape shapeCopy = new Shape(this.shape.getWidth(),this.getShape().getWidth());
        Box CopyBox = new Box(shapeCopy,null,point,raw,column);
        return CopyBox;
    }
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

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Float.compare(box.point, point) == 0 &&
                raw == box.raw &&
                column == box.column &&
                Objects.equals(shape, box.shape);
    }

    @NonNull
    @Override
    public String toString() {
        return "Row : " + this.raw;
    }
}
