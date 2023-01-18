public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Book book1 = new Book();
        book1.setPrice(200);
        System.out.println("Book price after discount is : "+book1.getPrice());


        Movie movie1 = new Movie();
        movie1.setPrice(200);
        System.out.println("Movie price after discount is : "+movie1.getPrice());

        System.out.println("\n");


        MoveablePoint  MOVE1 = new MoveablePoint();
        MOVE1.moveUp();
        System.out.println("\n");

        System.out.println(MOVE1.toString());
        MoveablePoint  MOVE2 = new MoveablePoint(1330,20440,5440,4440);
        MOVE2.moveUp();
        System.out.println(MOVE2.toString());

} }
