package main.com.gameoflife;

import main.utils.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ConwayGame {

    private List<String> initialConfiguration;
    private int generations;
    private Board board;

    public ConwayGame() {
        loadInitialConfiguration();
        loadGenerations();
        createBoard();
    }

    public ConwayGame(List<String> seed, int generations) {
        this.board = new Board(seed);
        this.generations = generations;
    }

    private void createBoard() {
        this.board = new Board(getSeed());
    }

    public Board iterate() {
        for (int index = 0; index < generations; ++index) {
            board = board.nextBoard();
        }
        return this.board;
    }


    private void loadInitialConfiguration() {
        try {
            this.initialConfiguration =
                    Files.readAllLines(Paths.get(Configuration.ROOT_PATH, Configuration.FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGenerations() {
        this.generations = Integer.valueOf(initialConfiguration.get(0));
    }

    private List<String> getSeed() {
        return initialConfiguration.subList(1, initialConfiguration.size());
    }

    public int getGenerations() {
        return generations;
    }

    public Board getBoard() {
        return board;
    }
}
