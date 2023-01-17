public class Square extends Rectangle {
    public Square() {
    }

    public Square(double width, double length) {
        super(width, length);
    }

    public Square(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
    }


    public void setWidth(double width) {
        this.width = width;
    }
    public double getSide() {

        return this.width * this.width;
    }

    @Override
    public double getPerimeter() {
        return 4*this.width;
    }
}
