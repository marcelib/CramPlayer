package com.marcelib;


import javafx.util.Pair;

public class Board {

    private static Board instance = null;
    private static int grid[][] = null;

    private Board() {
    }

    public static Board getInstance() throws IllegalAccessException {
        if (instance == null) {
            instance = new Board();
            Board.grid = new int[Size.getSize()][Size.getSize()];
        }
        return instance;
    }

    public static void lazyInit() throws IllegalAccessException {
        int size = Size.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public int[][] getBoard() {
        return Board.grid;
    }

    public void setEnemyMovementPoints(Pair<Coord, Coord> enemyMovementPoints) {

        grid[enemyMovementPoints.getKey().getX()][enemyMovementPoints.getKey().getY()] = 2;

        grid[enemyMovementPoints.getValue().getX()][enemyMovementPoints.getValue().getY()] = 2;
    }

    public void setMyMovementPoints(Pair<Coord, Coord> myMovementPoints) {

        grid[myMovementPoints.getKey().getX()][myMovementPoints.getKey().getY()] = 1;

        grid[myMovementPoints.getValue().getX()][myMovementPoints.getValue().getY()] = 1;
    }
}
