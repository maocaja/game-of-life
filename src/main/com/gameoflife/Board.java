package main.com.gameoflife;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Board {

    private Cell[][] cells;
    private int columns;
    private int rows;

    public Board(List<String> board) {
        this(loadCells(board), board.size(), board.get(0).length());
    }

    public Board(Cell[][] cells, int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = cells;
    }

    private static Cell[][] loadCells(List<String> board) {
        int rows = board.size();
        int columns = board.get(0).length();
        Cell[][] cells = new Cell[rows][columns];
        for (int indexRow = 0; indexRow < rows; indexRow++) {
            for (int indexColumn = 0; indexColumn < columns; indexColumn++) {
                cells[indexRow][indexColumn] =
                        Cell.getCell(String.valueOf(board.get(indexRow).charAt(indexColumn)));
            }
        }
        return cells;
    }

    public Board nextBoard() {
        Board nextBoard = new Board(new Cell[this.rows][this.columns], this.rows, this.columns);
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                int liveNeighbours = countLiveNeighbours(row, column);
                nextBoard.cells[row][column] = cells[row][column].evaluateCell(liveNeighbours);
            }
        }
        return nextBoard;
    }

    private int countLiveNeighbours(int row, int column) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int counterLiveNeighbours = 0;
        for (int index = 0; index < 8; ++index) {
            counterLiveNeighbours +=
                    getCounterLiveNeighbours(row + dy[index], column + dx[index]);
        }
        return counterLiveNeighbours;
    }

    private int getCounterLiveNeighbours(int newRow, int newColumn) {
        int counterLiveNeighbours = 0;
        if (isValidRow(newRow) && isValidColumn(newColumn)) {
            if (cells[newRow][newColumn] == Cell.LIVE) {
                counterLiveNeighbours += 1;
            }
        }
        return counterLiveNeighbours;

    }

    private boolean isValidColumn(int newColumn) {
        return (newColumn > 0 && newColumn < this.columns) ? true : false;
    }

    private boolean isValidRow(int newRow) {
        return (newRow > 0 && newRow < this.rows) ? true : false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;
        Board board = (Board) o;
        return columns == board.columns &&
                rows == board.rows &&
                Arrays.equals(cells, board.cells);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(columns, rows);
        result = 31 * result + Arrays.hashCode(cells);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder gridString = new StringBuilder();
        for (int indexRows = 0; indexRows < this.rows; ++indexRows) {
            for (int indexColumns = 0; indexColumns < this.columns; ++indexColumns) {
                gridString.append(cells[indexRows][indexColumns].toString());
            }
            gridString.append(String.format("%n"));
        }
        return gridString.toString();
    }
}
