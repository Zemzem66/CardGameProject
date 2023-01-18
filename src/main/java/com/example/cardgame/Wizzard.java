package com.example.cardgame;

public class Wizzard extends MonsterCard {
    public Wizzard(int damage, String elementType, String monsterName, String username) {
        super(damage,elementType,monsterName,username);
    }

    public Wizzard() {
        super();
    }

    public void setDecreaseHealth(int damage)
    {
        this.health -=damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
