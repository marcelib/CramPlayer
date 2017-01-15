package com.marcelib;

import javafx.util.Pair;

public class AlgorithmStrategy {


    private static Pair<Coord, Coord> previousEnemyMovement;
    private static boolean iStartFirst = false;
    private static boolean myFirstMovement = true;

    public static Pair<Coord, Coord> getNextCoordsPair() throws IllegalAccessException {

        if (iStartFirst && myFirstMovement) {
            myFirstMovement = false;
            int middleIndex = (int) Math.ceil((double) Size.getSize() / 2) - 1;
            Coord coord1 = new Coord(middleIndex, middleIndex);
            Coord coord2 = new Coord(middleIndex, middleIndex + 1);
            return new Pair<>(coord1, coord2);

        } else {
            return findCoordsTheRegularWay();
        }
    }

    public static void updateEnemyMovement(Pair<Coord, Coord> previousEnemyMovement) {
        AlgorithmStrategy.previousEnemyMovement = previousEnemyMovement;
    }

    public static void setIStartFirst() {
        iStartFirst = true;
    }

    private static Pair<Coord, Coord> findCoordsTheRegularWay() throws IllegalAccessException {
        int size = Size.getSize();
        Coord coord1 = new Coord(size - (1 + previousEnemyMovement.getKey().getX()),
                size - (1 + previousEnemyMovement.getKey().getY()));
        Coord coord2 = new Coord(size - (1 + previousEnemyMovement.getValue().getX()),
                size - (1 + previousEnemyMovement.getValue().getY()));
        if (BoardCoordHandler.areThoseCoordsEmptyAndOnBoard(coord1, coord2)) {
            return new Pair<>(coord1, coord2);
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size - 1; j++) {
                    if (BoardCoordHandler.areThoseCoordsEmptyAndOnBoard(new Coord(i, j), new Coord(i, j + 1))) {
                        return new Pair<>(new Coord(i, j), new Coord(i, j + 1));
                    }
                }
            }
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size; j++) {
                    if (BoardCoordHandler.areThoseCoordsEmptyAndOnBoard(new Coord(i, j), new Coord(i + 1, j))) {
                        return new Pair<>(new Coord(i, j), new Coord(i + 1, j));
                    }
                }
            }
        }
        return null;
    }
}
