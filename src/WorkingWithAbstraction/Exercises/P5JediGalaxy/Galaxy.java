package WorkingWithAbstraction.Exercises.P5JediGalaxy;

public class Galaxy {

    private Star[][] stars;

    public Galaxy(int row, int col) {
        this.stars = new Star[row][col];
        this.fillMatrix();
    }

    public Star[][] getStars() {
        return stars;
    }

    private void fillMatrix() {
        int starValue = 0;
        for (int row = 0; row < stars.length; row++) {
            for (int col = 0; col < stars[row].length; col++) {
                stars[row][col] = new Star(starValue++);
            }
        }
    }

}
