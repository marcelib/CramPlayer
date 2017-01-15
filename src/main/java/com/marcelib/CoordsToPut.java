package com.marcelib;


import javafx.util.Pair;

import java.util.Stack;

public class CoordsToPut {

    private static Stack<Pair<Coord, Coord>> coordsToPut = new Stack<>();

    public static boolean putNext() throws IllegalAccessException {
        if (coordsToPut.isEmpty()) {
            return false;
        } else if (!(BoardCoordHandler.areThoseCoordsNextToEachOther(coordsToPut.peek().getKey(), coordsToPut.peek().getValue())
                && BoardCoordHandler.areThoseCoordsEmptyAndOnBoard(coordsToPut.peek().getKey(), coordsToPut.peek().getValue()))) {
            Pair<Coord,Coord> coordinatesToPut = coordsToPut.pop();
            return false;
        } else {
            Pair<Coord,Coord> coordinatesToPut = coordsToPut.pop();
            int x1 = coordinatesToPut.getKey().getX();
            int y1 = coordinatesToPut.getKey().getY();
            int x2 = coordinatesToPut.getValue().getX();
            int y2 = coordinatesToPut.getValue().getY();
            Board.getInstance().setMyMovementPoints(new Pair<>(new Coord(x1,y1), new Coord(x2,y2)));
            System.out.println((x1 + 1) + " " + (y1 + 1) + " " + (x2 + 1) + " " + (y2 + 1));
            return true;
        }
    }

    public static void addNextToPut(Pair<Coord, Coord> coordsToAdd) throws IllegalAccessException {
        if (BoardCoordHandler.areThoseCoordsNextToEachOther(coordsToAdd.getKey(), coordsToAdd.getValue())
                || BoardCoordHandler.areThoseCoordsEmptyAndOnBoard(coordsToAdd.getKey(), coordsToAdd.getValue())) {
            coordsToPut.add(coordsToAdd);
        }
    }
}
