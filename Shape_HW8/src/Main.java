public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Rectangle r1= new Rectangle();
        r1.setLength(2);
        r1.setWidth(20);
        r1.getLength();
        r1.getWidth();
        System.out.println("Rectangle Area is :  "+r1.getArea());
        System.out.println("Rectangle Perimeter is :  "+r1.getPerimeter());
       // System.out.println(r1.toString());

        System.out.println("\n");
        Square Square1= new Square();
        Square1.setWidth(2);
        Square1.getWidth();
        System.out.println("Square Side is :  "+Square1.getSide());
        System.out.println("Square Perimeter is :  "+Square1.getPerimeter());
        //System.out.println(Square1.toString());

        System.out.println("\n");
        Circle circle1 = new Circle();
        System.out.println("Circle Area is :  "+circle1.getArea());
        Circle circle2= new Circle();
        circle2.setRadius(4);//Expected Result = 50.24
        System.out.println("Area of The Second Circle is :  "+circle2.getArea());
        System.out.println("Perimeter of The Second Circle is :  "+circle2.getPerimeter());


    }
}