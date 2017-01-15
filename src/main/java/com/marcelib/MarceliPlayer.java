package com.marcelib;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MarceliPlayer {


    private static int[][] board;

    public static int getSize() {
        return size;
    }

    private static int size = 0;

    public static void main(String[] args) throws IllegalAccessException {


        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String ping = null;
        try {
            ping = stdin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (ping != null) {
            if ("PING".equals(ping.toUpperCase())) {
                System.out.println("Pong");
            } else {
                System.out.println("Ping");
            }
        }

        try {
            size = Integer.parseInt(stdin.readLine());
            Size.setSize(size);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Board.getInstance();
        Board.lazyInit();


        loopWhileProgramIsRunning(stdin);
    }

    private static void loopWhileProgramIsRunning(BufferedReader stdin) throws IllegalAccessException {
        while (true) {

            String inp = readFromLine(stdin);

            if (iStartGame(inp)) {

                String[] elements = inp.trim().split(" ");

                int[] coords = new int[4];

                for (int i = 0; i < elements.length; i++) {
                    coords[i] = (Integer.parseInt(elements[i])) - 1;
                }

                Pair<Coord, Coord> enemyCoords = new Pair<>(new Coord(coords[0], coords[1])
                        , new Coord(coords[2], coords[3]));

                Board.getInstance().setEnemyMovementPoints(enemyCoords);
                AlgorithmStrategy.updateEnemyMovement(enemyCoords);

            } else if (endOfGame(inp)) {
                System.exit(0);
            } else {
                AlgorithmStrategy.setIStartFirst();
            }
            CoordsToPut.addNextToPut(AlgorithmStrategy.getNextCoordsPair());/*printNextCoords();*/
            CoordsToPut.putNext();
        }
    }

    private static boolean iStartGame(String inp) {
        return inp != null && !("START".equals(inp.toUpperCase()) || "ZACZYNAJ".equals(inp.toUpperCase()));
    }

    private static boolean endOfGame(String inp) {
        return inp != null && ("WYGRALES".equals(inp.toUpperCase()) || "PRZEGRALES".equals(inp.toUpperCase()));
    }

    private static String readFromLine(BufferedReader stdin) {
        String inp = null;
        try {
            inp = stdin.readLine();
        } catch (IOException ignored) {

        }
        return inp;
    }
}
