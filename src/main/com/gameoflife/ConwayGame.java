package main.com.gameoflife;

import java.util.List;

public class ConwayGame {
    private int generations;
    private Board board;

    public ConwayGame(List<String> config) {
        loadGenerations(config);
        createBoard(config);
    }

    public Board iterate(Board board) {
        for (int index = 0; index < generations; ++index) {
            this.board = board.nextBoard();
        }
        return this.board;
    }

    private void loadGenerations(List<String> config) {
        this.generations = Integer.valueOf(config.get(0));
    }

    private void createBoard(List<String> config) {
        this.board = new Board(config.subList(1, config.size()));
    }

    public int getGenerations() {
        return generations;
    }

    public Board getBoard() {
        return board;
    }
}
