package com.example.cardgame;

import java.util.Random;

public enum ElementType {
    FIRE(10),
    WATER(20),
    NORMAL(12);

    private int numVal;

    ElementType(int numVal)
    {
        this.numVal = numVal;
    }
    public int getNumVal()
    {
        return numVal;
    }

    private static final Random PRNG = new Random();

    public static ElementType randomElement() {
        ElementType[] elements = values();
        return elements[PRNG.nextInt(elements.length)];
    }
}
