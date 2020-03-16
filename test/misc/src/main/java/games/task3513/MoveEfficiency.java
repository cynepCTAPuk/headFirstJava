package games.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency moveEfficiency) {
        int efficiency = Integer.compare(this.numberOfEmptyTiles, moveEfficiency.numberOfEmptyTiles);
        if (efficiency == 0) efficiency = Integer.compare(this.score, moveEfficiency.score);
        return efficiency;
    }
}
