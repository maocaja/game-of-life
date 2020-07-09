package main.com.gameoflife;

import java.util.Arrays;

public class Grid {

    private Cell[][] cells;
    private int columns;
    private int rows;

    public Grid(Cell[][] cellsGrid, int columns, int rows) {
        this.cells = cellsGrid;
        this.columns = columns;
        this.rows = rows;
    }

    public Grid(char[][] initialBoard) {
        this(setCellsGrid(initialBoard), initialBoard.length, initialBoard[0].length);
    }

    private static Cell[][] setCellsGrid(char[][] initialBoard) {
        Cell[][] cellsGrid = new Cell[initialBoard.length][initialBoard[0].length];
        for (int indexX = 0; indexX < initialBoard.length; ++indexX) {
            for (int indexY = 0; indexY < initialBoard[0].length; ++indexY) {
                cellsGrid[indexX][indexY] = Cell.equalTo(initialBoard[indexX][indexY]);
            }
        }
        return cellsGrid;
    }

    public Grid nextGrid() {
        Grid nextGrid = newGrid();
        for (int indexX = 0; indexX < this.columns; indexX++) {
            for (int indexY = 0; indexY < this.rows; indexY++) {
                int liveNeighbours = countLiveNeighbours(indexX, indexY);
                nextGrid.cells[indexX][indexY] = cells[indexX][indexY].evaluateCell(liveNeighbours);
            }
        }
        return nextGrid;
    }

    private Grid newGrid() {
        return new Grid(new Cell[this.columns][this.rows], this.columns, this.rows);
    }

    public int countLiveNeighbours(int x, int y) {
        int counterLiveNeighbours = 0;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int index = 0; index < 8; ++index) {
            int newX = x + dx[index];
            int newY = y + dy[index];
            if (isValidCell(newX,newY)) {
                if (cells[newX][newY] == Cell.LIVE) {
                    counterLiveNeighbours += 1;
                }
            }
        }
        return counterLiveNeighbours;
    }

    private boolean isValidCell(int newX, int newY){
        return ((newX > 0 && newX < this.columns) && (newY > 0 && newY < this.rows)) ? true : false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return Arrays.equals(cells, grid.cells);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cells);
    }

    @Override
    public String toString() {

        StringBuilder gridString = new StringBuilder();
        for (int i = 0; i < this.columns; ++i) {
            for (int j = 0; j < this.rows; ++j) {
                gridString.append(cells[i][j].toString());
            }
            gridString.append(String.format("%n"));
        }
        return gridString.toString();
    }
}
