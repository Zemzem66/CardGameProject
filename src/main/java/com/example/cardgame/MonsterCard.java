package com.example.cardgame;

public class MonsterCard {
    int water;
    int fire;
    int normal;

    public MonsterCard(int water, int fire) {
        this.water = water;
        this.fire = fire;
        this.normal = normal;
    }

    //Function Attack can be inherited <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }
}
