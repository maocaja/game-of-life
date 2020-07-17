package main.com.gameoflife;

import main.utils.Configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static List<String> loadInitialConfiguration() throws FileNotFoundException {
        try {
            return Files.readAllLines(Paths.get(Configuration.ROOT_PATH, Configuration.FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileNotFoundException("The file does not exist");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ConwayGame conwayGame = new ConwayGame(loadInitialConfiguration());
        for (int index = 0; index < conwayGame.getGenerations(); ++index) {
            Board board = conwayGame.getBoard();
            System.out.println(board.toString());
            conwayGame.iterate(board);
        }

    }

}