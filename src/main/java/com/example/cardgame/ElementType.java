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

}
