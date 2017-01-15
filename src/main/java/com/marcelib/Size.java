package com.marcelib;

public class Size {

    private static int size;
    private static boolean sizeSet = false;


    public static void setSize(int size) throws IllegalAccessException {
        if (!sizeSet) {
            Size.size = size;
            Size.sizeSet = true;
        } else {
            throw new IllegalAccessException("Cannot set size of the board twice!");
        }
    }

    public static int getSize() throws IllegalAccessException {
        if (sizeSet) {
            return Size.size;
        } else {
            throw new IllegalAccessException("Cannot access size of the board before initialization!");
        }
    }
}
