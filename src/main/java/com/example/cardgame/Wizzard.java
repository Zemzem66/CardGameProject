package com.example.cardgame;

public class Wizzard extends MonsterCard {
    //soll ich die variable hier erstellen.
    //MonsterCard myMonsterCard = new MonsterCard(water, normal, normal, health);
    //int health = 100;

    public Wizzard(int damage,int health, ElementType elementType, MonsterName monsterName) {
        super(damage, health,elementType,monsterName);
    }

    public Wizzard() {
        super();
    }

    public void setDecreaseHealth(int damage)
    {
        this.health -=damage;
    }

    //<myMonsterCard> void attack(myMonsterCard) // need to check.
    //{

    //}
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }



}
