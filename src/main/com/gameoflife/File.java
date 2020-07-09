package main.com.gameoflife;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class File {

    private final String ROOT_PATH = "src/main/resources/";
    private final String FILE_NAME = "gameOfLife.txt";
    private List<String> fileContent;
    private int generations;
    private char[][] seed;

    public File() throws FileNotFoundException {
        readFile();
        setGenerations();
        setSeed();
    }

    private void setSeed() {
        seed = new char[fileContent.size() - 1][];
        for (int index = 1; index < fileContent.size(); ++index) {
            char[] line = fileContent.get(index).toCharArray();
            seed[index - 1] = line;
        }
    }

    private void readFile() throws FileNotFoundException {
        try {
            fileContent = Files.readAllLines(Paths.get(ROOT_PATH, FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileNotFoundException();
        }
    }

    private void setGenerations() {
        this.generations = Integer.valueOf(fileContent.get(0));
    }

    public int getGenerations() {
        return generations;
    }

    public char[][] getSeed() {
        return seed;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File();
        System.out.println(file.getGenerations());
        System.out.println(Arrays.deepToString(file.getSeed()));
    }

}
