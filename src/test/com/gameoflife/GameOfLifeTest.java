package test.com.gameoflife;

import main.com.gameoflife.Grid;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class GameOfLifeTest {

    @Test
    public void allDeadCells_thenNextGenerationAreDead() {
        char[][] seed = {{'.', '.', '.'},
                         {'.', '.', '.'},
                         {'.', '.', '.'}};
        Grid grid = new Grid(seed);
        assertThat(grid.nextGrid().toString(), equalTo(grid.toString()));
    }

    @Test
    public void oneCellInMiddle_thenCellDeadNextGeneration() {
        char[][] seed = {{'.', '.', '.'},
                         {'.', '*', '.'},
                         {'.', '.', '.'}};

        char[][] nextGrid = {{'.', '.', '.'},
                             {'.', '.', '.'},
                             {'.', '.', '.'}};
        Grid grid = new Grid(seed);
        assertThat(grid.nextGrid().toString(), equalTo(new Grid(nextGrid).toString()));
    }

    @Test
    public void fourLiveCellsInTheMiddle_thenContinueLiveNextGeneration() {
        char[][] seed = {{'.', '.', '.', '.'},
                         {'.', '*', '*', '.'},
                         {'.', '*', '*', '.'},
                         {'.', '.', '.', '.'}};
        Grid grid = new Grid(seed);
        assertThat(grid.nextGrid().toString(), equalTo(grid.toString()));
    }

    @Test
    public void aDiagonalLifeCells_thenAllCellsDeadNextGeneration() {
        char[][] seed = {{'*', '.', '.'},
                         {'.', '*', '.'},
                         {'.', '.', '*'}};

        char[][] nextGrid = {{'.', '.', '.'},
                             {'.', '.', '.'},
                             {'.', '.', '.'}};
        System.out.println(new Grid(nextGrid).toString());
        Grid grid = new Grid(seed);
        assertThat(grid.nextGrid().toString(), equalTo(new Grid(nextGrid).toString()));
    }

}