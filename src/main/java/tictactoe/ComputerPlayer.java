package tictactoe;

import java.util.HashMap;
import java.util.Map;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String mark) {
        super(mark);
    }

    public int getMove(Game game) {
        return getBestMove(game);
    }

    private int getBestMove(Game game) {
        GameState gameState = new GameState(game);
        Map<Integer, Integer> scores = new HashMap<>();
        int depth = 0;
        return minimax(gameState, depth, scores);
    }

    private int minimax(GameState gameState, int depth, Map<Integer, Integer> scores) {
        if(gameState.isTerminal()) {
            return getScore(gameState);
        }

        String nextPlayerMark = gameState.getNextPlayer().getMark();

        for (Cell cell : gameState.getBoard().getAvailableCells()) {
            Board newBoard = // copy the board
            newBoard.markCellAtPosition(this.getMark(), cell.getPosition());
            GameState nextGameState = new GameState(newBoard, nextPlayerMark);
            scores.put(cell.getPosition(), minimax(nextGameState, depth += 1, new HashMap<>()));
        }

        if(depth == gameState.getBoard().getAvailableCells().size()) {
            return scores.entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .get()
                    .getKey();
        }

        if(gameState.getCurrentPlayer().getMark().equals(this.getMark())) {
            return scores.entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .get()
                    .getValue();
        }

        if(!gameState.getCurrentPlayer().getMark().equals(this.getMark())) {
            return scores.entrySet()
                    .stream()
                    .min(Map.Entry.comparingByValue())
                    .get()
                    .getValue();
        }
    }

    private int getScore(GameState gameState) {
        if(gameState.getBoard().getWinner().equals(this.getMark())) {
            return 1;
        }

        if(gameState.getBoard().hasTie()) {
            return 0;
        }

        return -1;
    }

    @Override
    public String getInput() {
        return null;
    }

}
