package academy.tochkavhoda.boxes.v3;

import academy.tochkavhoda.figures.v3.Figure;

public class ArrayBox<T extends Figure> {
    private T[] figures;

    public ArrayBox(T[] figures) {
        this.figures = figures;
    }

    public T[] getContent() {
        return figures;
    }

    public void setContent(T[] figures) {
        this.figures = figures;
    }

    public T getElement(int i) {
        return figures[i];
    }

    public void setElement(int i, T fig) {
       figures[i] = fig;
    }

    public boolean isSameSize(ArrayBox<? extends Figure> figures) {
        double eps = 0.000001;
        return Math.abs((this.figures.length - figures.getContent().length))<eps;

    }
}
