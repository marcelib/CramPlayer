package com.marcelib;

public class BoardCoordHandler {

    public static boolean areThoseCoordsEmptyAndOnBoard(Coord firstCoord, Coord secondCoord) throws IllegalAccessException {

        boolean firstCoordInBoard = firstCoord.getX() >= 0 && firstCoord.getX() < Size.getSize()
                && firstCoord.getY() >= 0 && firstCoord.getY() < Size.getSize();

        boolean secondCoordInBoard = secondCoord.getX() >= 0 && firstCoord.getX() < Size.getSize()
                && secondCoord.getY() >= 0 && firstCoord.getY() < Size.getSize();/*
        System.out.println("inBoard is " + (firstCoordInBoard && secondCoordInBoard));*/

        boolean firstCoordEmpty = Board.getInstance().getBoard()[firstCoord.getX()][firstCoord.getY()] == 0;/*
        System.out.println(Board.getInstance().getBoard()[firstCoord.getX()][firstCoord.getY()]);*/

        boolean secondCoordEmpty = Board.getInstance().getBoard()[secondCoord.getX()][secondCoord.getY()] == 0;/*
        System.out.println(Board.getInstance().getBoard()[secondCoord.getX()][secondCoord.getY()]);
        System.out.println("empty is " + (firstCoordEmpty && secondCoordEmpty ));*/
        return firstCoordEmpty && firstCoordInBoard && secondCoordEmpty && secondCoordInBoard;
    }

    public static boolean areThoseCoordsNextToEachOther(Coord firstCoord, Coord secondCoord) {

        boolean oneCoordNotEqual = (firstCoord.getX() != secondCoord.getX()) || (firstCoord.getY() != secondCoord.getY());
        boolean xNextToEachOther = Math.abs(firstCoord.getX() - secondCoord.getX()) <= 1;
        boolean yNextToEachOther = Math.abs(firstCoord.getY() - secondCoord.getY()) <= 1;/*
        System.out.println("next to  is" + (oneCoordNotEqual && xNextToEachOther && yNextToEachOther));*/
        return oneCoordNotEqual && xNextToEachOther && yNextToEachOther;
    }
}
