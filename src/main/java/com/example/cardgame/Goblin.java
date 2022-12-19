package com.example.cardgame;

public class Goblin extends MonsterCard  {
   // int damage;
 //int health = 100;
    public Goblin(int damage,int health, ElementType elementType, MonsterName monsterName) {
        super(damage, health, elementType,monsterName);
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

    public void getMonsterName()
    {
        System.out.println("Goblin");
        // return "Goblin";
    }

    //MonsterCard myMonsterCard = new MonsterCard(damage, normal,normal, health);

}
