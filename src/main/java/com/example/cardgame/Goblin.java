package com.example.cardgame;

public class Goblin extends MonsterCard  {
   // int damage;
 //int health = 100;
    public Goblin(int damage, String elementType, String monsterName, String username) {
        super(damage, elementType,monsterName,username);
    }

    //public int getNormal() {return normal;}

    //public void setNormal(int normal) {
      //  this.normal = normal;
    //}

    //public MonsterCard getMyMonsterCard() {return myMonsterCard;}

    //public void setMyMonsterCard(MonsterCard myMonsterCard) {this.myMonsterCard = myMonsterCard;}

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

    //MonsterCard myMonsterCard = new MonsterCard(damage, normal,normal, health);

}
