import api.AIEngine;
import api.GameEngine;
import api.RuleEngine;
import game.Board;
import game.Cell;
import game.Move;
import game.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class GamePlayTest  {
    GameEngine gameEngine;
    AIEngine aiEngine;
    RuleEngine ruleEngine;
    @Before
    public void setup(){
        gameEngine = new GameEngine();
        aiEngine = new AIEngine();
        ruleEngine = new RuleEngine();
    }
    @Test
    public void checkForRowWin(){

        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{1,0}, {1,1}, {1,2}};
        playGame(board, moves);
        System.out.println(board);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForColWin(){

        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{0,0}, {1,0}, {2,0}};
        playGame(board, moves);
        System.out.println(board);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForDiagonalWin(){

        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{0,0}, {1,1}, {2,2}};
        playGame(board, moves);
        System.out.println(board);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForReverseDiagonalWin(){

        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{0,2}, {1,1}, {2,0 }};
        playGame(board, moves);
        System.out.println(board);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForComputerWin(){

        Board board = gameEngine.start("TicTacToe");
        int moves[][] = new int[][]{{1,0}, {1,1}, {2,1}};
        playGame(board, moves);
        System.out.println(board);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "O");
    }

    private void playGame(Board board, int[][] moves) {
        int row, col;
        int next = 0;
        while (!ruleEngine.getState(board).isOver()) {
            Player computer = new Player("O"), human = new Player("X");
            row = moves[next][0];
            col = moves[next][1];
            next++;
            Move oppMove = new Move(new Cell(row, col), human);
            gameEngine.move(board, oppMove);
            if (!ruleEngine.getState(board).isOver()) {
                Move computerMove = aiEngine.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
        }
    }


}
