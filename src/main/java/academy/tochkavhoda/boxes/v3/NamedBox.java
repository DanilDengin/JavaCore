package academy.tochkavhoda.boxes.v3;

import academy.tochkavhoda.figures.v3.Figure;


public class NamedBox <T extends Figure> extends Box<T>{
    private String name;

    public NamedBox(T figure, String name) {
        super(figure);
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
