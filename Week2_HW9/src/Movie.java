public class Movie extends Product{

    String director;
    public Movie() {

    }
    public Movie(String director) {

        this.director = director;
    }

    public Movie(String name, double price, String director) {
        super(name, price);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getPrice() {
        return  price - (price*0.50);
    }
}
