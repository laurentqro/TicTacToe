package tictactoe;

public class ComputerPlayer extends Player {
    private Player opponent;

    ComputerPlayer(String mark, Player opponent) {
        super(mark);
        this.opponent = opponent;
    }

    @Override
    public String getMove(Board board) {
        ScoredMove bestMove = minimax(board);
        return Integer.toString(bestMove.getCellPosition());
    }

    private ScoredMove minimax(Board board) {
        ScoredMove move = maxValue(board);
        return move;
    }

    private ScoredMove maxValue(Board board) {
        int bestScore = Integer.MIN_VALUE;
        int bestPosition = Integer.MIN_VALUE;

        if (board.hasTie() || board.hasWin()) {
            int score = calculateScore(board);
            return new ScoredMove(new Cell(bestPosition), score);
        }

        for (Cell cell : board.getAvailableMoves()) {
            cell.setMark(mark);
            ScoredMove scoredMove = minValue(board);
            int score = scoredMove.getScore();

            if (score > bestScore) {
                bestPosition = cell.getPosition();
                bestScore = score;
            }
            cell.reset();
        }
        return new ScoredMove(new Cell(bestPosition), bestScore);
    }

    private ScoredMove minValue(Board board) {
        int bestScore = Integer.MAX_VALUE;
        int bestPosition = Integer.MAX_VALUE;

        if (board.hasTie() || board.hasWin()) {
            int score = calculateScore(board);
            return new ScoredMove(new Cell(bestPosition), score);
        }

        for (Cell cell : board.getAvailableMoves()) {
            cell.setMark(opponent.getMark());
            ScoredMove scoredMove = maxValue(board);
            int score = scoredMove.getScore();

            if (score < bestScore) {
                bestPosition = cell.getPosition();
                bestScore = score;
            }
            cell.reset();
        }
        return new ScoredMove(new Cell(bestPosition), bestScore);
    }

    private int calculateScore(Board board) {
        if (board.hasTie()) {
            return 0;
        }

        if (board.getWinner().equals(mark)) {
            return 1;
        } else {
            return -1;
        }
    }
}
