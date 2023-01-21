public class Car extends Trip {

    public Car() {
    }

    public Car(String tripnumber, double distance, double speed, String startTime) {
        super(tripnumber, distance, speed, startTime);
    }


    public int calculateDuration() {
      /* double duration =calculateDuration();
        duration = ((this.distance / this.speed));
              return duration;  */

        return (int)((this.distance/this.speed));

    }

    @Override
    public String toString() {
        return "Car:  " +
                "tripnumber =  '" + tripnumber + '\'' +"\n"+
                "distance =  " + distance +" km "+"\n"+
                "speed =  " + speed +" km/h "+"\n"+
                "startTime =  '" + startTime + '\'' ;
    }
}