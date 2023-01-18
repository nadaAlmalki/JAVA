public class MoveablePoint implements Movable{

    int x = 100;
    int y = 210;
    int Xspeed = 50;
    int Yspeed = 40;


    public MoveablePoint() {
    }

    public MoveablePoint(int x, int y, int xspeed, int yspeed) {
        this.x = x;
        this.y = y;
        Xspeed = xspeed;
        Yspeed = yspeed;
    }

    @Override
    public void moveUp() {
        this.y+=Yspeed;
    }

    @Override
    public void moveDwon() {
        this.y-=Yspeed;
    }

    @Override
    public void moveLeft() {
        this.x-=Xspeed;
    }

    @Override
    public void moveRight() {
        this.x+=Xspeed;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "x= " + x +
                ", y= " + y +
                ", Xspeed= " + Xspeed +
                ", Yspeed= " + Yspeed +
                '}';
    }
}
