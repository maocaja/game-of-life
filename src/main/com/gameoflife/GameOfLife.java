package main.com.gameoflife;

import java.io.FileNotFoundException;

public class GameOfLife {

    private File file;
    private Grid grid;
    private int generations;

    public GameOfLife() throws FileNotFoundException {
        this.file = new File();
        this.generations = file.getGenerations();
        this.grid = new Grid(file.getSeed());
    }

    public void iterateGenerations() {
        for (int index = 1; index <= this.generations; ++index) {
            System.out.println(index);
            System.out.println(grid.toString());
            Grid nextGrid = grid.nextGrid();
            grid = nextGrid;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.iterateGenerations();
    }
}
