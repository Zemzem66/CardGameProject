package com.example.cardgame;

public class Goblin extends MonsterCard  {
   // int damage;
 //int health = 100;
    public Goblin(int damage, String elementType, String monsterName, String username) {
        super(damage, elementType,monsterName,username);
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

    public String getMonsterName()
    {
        System.out.println("Goblin");
        // return "Goblin";
        return null;
    }


}
