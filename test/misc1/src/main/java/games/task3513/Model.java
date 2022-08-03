package games.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score;
    int maxTile;
    private Stack<Tile[][]> previousStates = new Stack();
    private Stack<Integer> previousScores = new Stack();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::down));
        queue.peek().getMove().move();
    }

    public boolean hasBoardChanged() {
        Tile[][] previousGameTiles = previousStates.peek();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value != previousGameTiles[i][j].value) return true;
            }
        }
        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        if (hasBoardChanged()) {
            rollback();
            return moveEfficiency;
        } else return new MoveEfficiency(-1, 0, move);
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        if (n == 0) left();
        else if (n == 1) right();
        else if (n == 2) up();
        else if (n == 3) down();
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 1; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value) return true;
            }
        }
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 1; j < FIELD_WIDTH; j++) {
                if (gameTiles[j][i].value == gameTiles[j - 1][i].value) return true;
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] savedState = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                savedState[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(savedState);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        score = 0;
        maxTile = 0;
        for (int i = 0; i < gameTiles.length; i++)
            for (int j = 0; j < gameTiles[i].length; j++)
                gameTiles[i][j] = new Tile();
        addTile();
        addTile();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyList = new ArrayList();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                Tile tile = gameTiles[i][j];
                if (tile.value == 0) emptyList.add(tile);
            }
        }
        return emptyList;
    }

    public void addTile() {
        List<Tile> emptyList = getEmptyTiles();
        if (emptyList.size() > 0) {
            int m = (int) (emptyList.size() * Math.random());
            emptyList.get(m).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean compressed = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            for (int j = 0; j < tiles.length - 1 - i; j++) {
                Tile current = tiles[j];
                Tile next = tiles[j + 1];
                if (current.value == 0 & next.value > 0) {
                    compressed = true;
                    int temp = current.value;
                    current.value = next.value;
                    next.value = temp;
                }
            }
        }
        return compressed;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean merged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            Tile current = tiles[i];
            if (current.value == 0) continue;
            Tile next = tiles[i + 1];
            if (current.value == next.value) {
                merged = true;
                current.value *= 2;
                next.value = 0;
                score += current.value;
                if (current.value > maxTile) maxTile = current.value;
                compressTiles(tiles);
            }
        }
        return merged;
    }

    void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean added = false;
        for (Tile[] gameTile : gameTiles) {
            if (compressTiles(gameTile)) added = true;
            if (mergeTiles(gameTile)) added = true;
        }
        if (added) {
            addTile();
            isSaveNeeded = true;
        }
    }

    void up() {
        saveState(gameTiles);
        rotateMatrixCounterClockwise();
        left();
        rotateMatrixCounterClockwise();
        rotateMatrixCounterClockwise();
        rotateMatrixCounterClockwise();
    }

    void right() {
        saveState(gameTiles);
        rotateMatrixCounterClockwise();
        rotateMatrixCounterClockwise();
        left();
        rotateMatrixCounterClockwise();
        rotateMatrixCounterClockwise();
    }

    void down() {
        saveState(gameTiles);
        rotateMatrixCounterClockwise();
        rotateMatrixCounterClockwise();
        rotateMatrixCounterClockwise();
        left();
        rotateMatrixCounterClockwise();
    }

    private void rotateMatrixCounterClockwise() {
        Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                temp[i][j] = gameTiles[j][FIELD_WIDTH - i - 1];
            }
        }
        gameTiles = temp;
    }
}
