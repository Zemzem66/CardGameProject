package com.example.cardgame;

import java.util.Random;

public enum ElementType {
    FIRE { String Fire(){
                return "Fire";
            }},
  //  FIRE(10),
    WATER{ String Water(){
      return "Water";
  }},
    NORMAL{ String Normal(){
        return "Regular";
    }};
/*
    private int numVal;

    ElementType(int numVal)
    {
        this.numVal = numVal;
    }

    ElementType() {

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

 */
}
