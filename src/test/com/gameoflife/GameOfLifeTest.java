package test.com.gameoflife;

import main.com.gameoflife.ConwayGame;

import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeTest {

    public final static String LINE_BREAK = String.format("%n");

    private ConwayGame getGame(List<String> config) {
        ConwayGame game = new ConwayGame(config);
        for (int times = 1; times <= game.getGenerations(); ++times) {
            game.nextGeneration();
        }
        return game;
    }


    @Test
    public void allDeadCells_thenNextGenerationAreDead() {
        List<String> config = Arrays.asList("1",
                "...",
                "...",
                "...");
        ConwayGame game = getGame(config);

        StringBuilder finalBoard = new StringBuilder();
        finalBoard.append("...").append(LINE_BREAK)
                .append("...").append(LINE_BREAK)
                .append("...").append(LINE_BREAK);

        assertThat(game.getBoard().toString(), equalTo(finalBoard.toString()));
    }

    @Test
    public void oneCellInMiddle_thenCellDeadNextFiveGeneration() {
        List<String> config = Arrays.asList("5",
                "...",
                ".*.",
                "...");

        ConwayGame game = getGame(config);

        StringBuilder finalBoard = new StringBuilder();
        finalBoard.append("...").append(LINE_BREAK)
                .append("...").append(LINE_BREAK)
                .append("...").append(LINE_BREAK);


        assertThat(game.getBoard().toString(), equalTo(finalBoard.toString()));
    }

    @Test
    public void fourLiveCellsInTheMiddle_thenContinueLiveNext10Generation() {
        List<String> config = Arrays.asList("10",
                "....",
                ".**.",
                ".**.",
                "....");

        ConwayGame game = getGame(config);

        StringBuilder finalBoard = new StringBuilder();
        finalBoard.append("....").append(LINE_BREAK)
                .append(".**.").append(LINE_BREAK)
                .append(".**.").append(LINE_BREAK)
                .append("....").append(LINE_BREAK);

        assertThat(game.getBoard().toString(), equalTo(finalBoard.toString()));
    }

    @Test
    public void aDiagonalLifeCells_thenAfter4GenerationsItIsConstant() {
        List<String> config = Arrays.asList("4",
                "........",
                "...*....",
                "...***..",
                "........",
                "........");

        ConwayGame game = getGame(config);

        StringBuilder finalBoard = new StringBuilder();
        finalBoard.append("........").append(LINE_BREAK)
                .append("...**...").append(LINE_BREAK)
                .append("..*..*..").append(LINE_BREAK)
                .append("...**...").append(LINE_BREAK)
                .append("........").append(LINE_BREAK);

        assertThat(game.getBoard().toString(), equalTo(finalBoard.toString()));
    }

}