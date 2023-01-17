public class Circle extends Shape{
    double radius = 1.0;

    public Circle() {

    }
    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        double area = (Math.PI)*(Math.pow(this.radius,2)) ;
        return area;
    }

    public double getPerimeter(){

        return Math.sqrt((getArea())*(Math.PI)*4);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
