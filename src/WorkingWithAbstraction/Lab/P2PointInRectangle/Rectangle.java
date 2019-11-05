package WorkingWithAbstraction.Lab.P2PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }
    public  boolean contains(Point point){

        boolean checkX = point.getX() >= this.bottomLeft.getX() && point.getX() <= this.topRight.getX();
        boolean checkY = point.getY() >= this.bottomLeft.getY() && point.getY() <= this.topRight.getY();

        return checkX && checkY;
    }
}
