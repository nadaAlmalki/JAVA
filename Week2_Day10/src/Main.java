public class Main {
    public static void main(String[] args) {
        System.out.println("Travel by CAR: ");
    //String tripnumber, double distance, double speed, String startTime
    Car car = new Car("01", 340.0, 100.0, "2.10" );
        System.out.println(car.toString());
        System.out.println("Arrival time at :  " + car.calculateArrivalTime()+"  hours");


        System.out.println("\n"+ "Travel by Train: ");
      Trip train = new Train("0101", 22.3, 2.0, "00.00" );

        System.out.println(train.toString());
        System.out.println("Arrival time at :  " + train.calculateArrivalTime()+"  hours");

        System.out.println("\n"+ "Travel by CAR: ");

        Car car2 = new Car("021", 425.5, 79.16, "1.00" );
        System.out.println(car2.toString());
        System.out.println("Arrival time at :  " + car2.calculateArrivalTime()+"  hours");

}}