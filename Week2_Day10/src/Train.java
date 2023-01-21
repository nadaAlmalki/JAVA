public class Train extends Trip{
    public Train() {
    }

    public Train(String tripnumber, double distance, double speed, String startTime) {
        super(tripnumber, distance, speed, startTime);
    }


    public int calculateDuration() {


        return (int) ((this.distance / this.speed));
    }



   @Override
    public String toString() {
        return
                "tripnumber =  '" + tripnumber + '\'' +"\n"+
                "distance =  " + distance +" km "+"\n"+
                "speed =  " + speed +" km/h "+"\n"+
                "startTime =  '" + startTime + '\'' ;
    }
}
