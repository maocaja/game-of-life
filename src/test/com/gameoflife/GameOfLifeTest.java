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
        List<String> config = Arrays.asList("1",
                                          "...",
                                          "...",
                                          "...");
        ConwayGame conwayGame = new ConwayGame(config);
        assertThat(conwayGame.getBoard().toString(), equalTo(conwayGame.iterate(conwayGame.getBoard()).toString()));
    }

    @Test
    public void oneCellInMiddle_thenCellDeadNextFiveGeneration() {
        List<String> config = Arrays.asList("5",
                                            "...",
                                            ".*.",
                                            "...");

        List<String> resultBoard = Arrays.asList("...",
                                                "...",
                                                "...");
        Board board = new Board(resultBoard);
        ConwayGame conwayGame = new ConwayGame(config);
        assertThat(board.toString(), equalTo(conwayGame.iterate(conwayGame.getBoard()).toString()));
    }

    @Test
    public void fourLiveCellsInTheMiddle_thenContinueLiveNext10Generation() {
        List<String> config = Arrays.asList("10",
                                            "....",
                                            ".**.",
                                            ".**.",
                                            "....");

        List<String> resultBoard = Arrays.asList("....",
                                                 ".**.",
                                                 ".**.",
                                                 "....");

        ConwayGame conwayGame = new ConwayGame(config);
        Board board = new Board(resultBoard);
        assertThat(board.toString(), equalTo(conwayGame.iterate(conwayGame.getBoard()).toString()));
    }

    @Test
    public void aDiagonalLifeCells_thenAfter4GenerationsItIsConstant() {
        List<String> config = Arrays.asList("4",
                                                 "........",
                                                 "...*....",
                                                 "...***..",
                                                 "........",
                                                 "........");

        List<String> resultBoard = Arrays.asList("........",
                                                "...**...",
                                                "..*..*..",
                                                "...**...",
                                                "........");
        ConwayGame conwayGame = new ConwayGame(config);
        Board board = new Board(resultBoard);
        assertThat(board.toString(), equalTo(conwayGame.iterate(conwayGame.getBoard()).toString()));
    }

}