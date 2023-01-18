package com.example.cardgame;

public class FireEvle extends MonsterCard {

    public FireEvle(int damage,String elementType,String monsterName, String username) {
        super(damage,elementType,monsterName, username);
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



    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public double damage() {
        return 0;
    }

    //MonsterCard myMonsterCard = new MonsterCard(damage,health);

}
