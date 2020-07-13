package main.com.gameoflife;

import java.util.Arrays;

public enum Cell {

    LIVE("*") {
        @Override
        public Cell evaluateCell(int liveNeighbours) {
            return (liveNeighbours == 2 || liveNeighbours == 3) ? LIVE : DEAD;
        }
    }, DEAD(".") {
        @Override
        public Cell evaluateCell(int liveNeighbours) {
            return liveNeighbours == 3 ? LIVE : DEAD;
        }
    };

    private final String character;


    Cell(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return character;
    }

    public abstract Cell evaluateCell(int liveNeighbours);

    public static Cell getCell(String character) {
        return Arrays.stream(values())
                .filter(cell -> cell.character.equals(character))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException(String.format("Unsupported type %s.", character)));
    }

}
