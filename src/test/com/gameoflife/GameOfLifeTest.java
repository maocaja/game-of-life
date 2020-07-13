package test.com.gameoflife;

import main.com.gameoflife.Board;
import main.com.gameoflife.ConwayGame;

import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeTest {

    @Test
    public void allDeadCells_thenNextGenerationAreDead() {
        List<String> seed = Arrays.asList("...",
                                          "...",
                                          "...");
        ConwayGame conwayGame = new ConwayGame(seed, 1);
        assertThat(conwayGame.getBoard().toString(), equalTo(conwayGame.iterate().toString()));
    }

    @Test
    public void oneCellInMiddle_thenCellDeadNextFiveGeneration() {
        List<String> initialSeed = Arrays.asList("...",
                                          ".*.",
                                          "...");

        List<String> resultSeed = Arrays.asList("...",
                                        "...",
                                        "...");
        Board resultBoard = new Board(resultSeed);
        ConwayGame conwayGame = new ConwayGame(initialSeed, 5);
        assertThat(resultBoard.toString(), equalTo(conwayGame.iterate().toString()));
    }

    @Test
    public void fourLiveCellsInTheMiddle_thenContinueLiveNext10Generation() {
        List<String> seed = Arrays.asList("....",
                                          ".**.",
                                          ".**.",
                                          "....");

        ConwayGame conwayGame = new ConwayGame(seed, 10);
        Board resultBoard = new Board(seed);
        assertThat(resultBoard.toString(), equalTo(conwayGame.iterate().toString()));
    }

    @Test
    public void aDiagonalLifeCells_thenAllCellsDeadNextGeneration() {
        List<String> initialSeed = Arrays.asList("........",
                                                 "...*....",
                                                 "...***..",
                                                 "........",
                                                 "........");

        List<String> resultSeed = Arrays.asList("........",
                                                "...**...",
                                                "..*..*..",
                                                "...**...",
                                                "........");
        ConwayGame conwayGame = new ConwayGame(initialSeed, 4);
        Board resultBoard = new Board(resultSeed);
        assertThat(resultBoard.toString(), equalTo(conwayGame.iterate().toString()));
    }

}