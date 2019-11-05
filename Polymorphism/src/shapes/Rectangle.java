package shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter(this.height * 2 + this.width * 2);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.height * this.width);
    }
}
