package main.com.gameoflife;

public class Main {

    public static void main(String[] args) {
        ConwayGame conwayGame = new ConwayGame();
        int generations = conwayGame.getGenerations();
        Board board = conwayGame.getBoard();
        for (int index = 0; index < generations; ++index){
            System.out.println(board.toString());
            board = conwayGame.iterate(board);
        }

    }

}