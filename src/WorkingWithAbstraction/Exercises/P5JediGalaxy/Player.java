package WorkingWithAbstraction.Exercises.P5JediGalaxy;

public class Player {
    private int row;
    private int col;
    private Galaxy galaxy;

    public Player(int row, int col, Galaxy galaxy) {
        this.row = row;
        this.col = col;
        this.galaxy = galaxy;
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isInField() {
        return this.row >= 0 && col < this.galaxy.getStars()[1].length;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public long move() {
        long sum = 0;
        if (this.getRow() < galaxy.getStars().length && this.getCol() >= 0 && this.getCol() < galaxy.getStars()[0].length) {
            sum += galaxy.getStars()[this.getRow()][this.getCol()].getValue();
        }
        this.setCol(this.getCol() + 1);
        this.setRow(this.getRow() - 1);
        return sum;
    }
}
