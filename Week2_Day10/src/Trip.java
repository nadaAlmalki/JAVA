//import java.text.DateFormat;

public abstract class Trip {

    String tripnumber;
    double distance;
    double speed;
    String startTime = "0:0";

    public Trip() {

    }

    public Trip(String tripnumber, double distance, double speed, String startTime) {
        this.tripnumber = tripnumber;
        this.distance = distance;
        this.speed = speed;
        this.startTime = startTime;
    }

    public abstract int calculateDuration();

    public double covertMinToHour(int min) {
       // double minutes = Double.valueOf(min);
        double minutes = min;
        minutes = (this.distance/this.speed)/60;
        return minutes;
    }


    public String calculateArrivalTime() {

        //int time = Integer.valueOf(this.startTime);
       double time = Double.valueOf(this.startTime);

        return " "+ ((this.distance/this.speed) + time);


    }


}