package WorkingWithAbstraction.Exercises.P5JediGalaxy;

public class Evil {
    private int row;
    private int col;
    private Galaxy galaxy;

    public Evil(int row, int col, Galaxy galaxy) {
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
        return this.row >= 0 && this.col >= 0;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void move() {
        if (this.getRow() < galaxy.getStars().length && this.getCol() < galaxy.getStars()[0].length) {
            galaxy.getStars()[this.getRow()][this.getCol()].setValue(0);
        }
        this.setRow(this.getRow() - 1);
        this.setCol(this.getCol() - 1);
    }
}
