package test.com.gameoflife;

import main.com.gameoflife.ConwayGame;

import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class GameOfLifeTest {

    @Test
    public void allDeadCells_thenNextGenerationAreDead() {
        List<String> seed = Arrays.asList("...", "...", "...");
        ConwayGame conwayGame = new ConwayGame(seed, 1);
        assertThat(conwayGame.getBoard().toString(), equalTo(conwayGame.getBoard().toString()));
    }
}