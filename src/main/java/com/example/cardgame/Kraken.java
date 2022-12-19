package com.example.cardgame;

public class Kraken extends MonsterCard {

    int normal;

    public Kraken(int damage, int health,ElementType elementType,MonsterName monsterName) {
        super(damage, health,elementType,monsterName);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

   /// public MonsterCard getMyMonsterCard() {
      //  return myMonsterCard;
    //}

   // public void setMyMonsterCard(MonsterCard myMonsterCard) {
     //   this.myMonsterCard = myMonsterCard;
    //}

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //MonsterCard myMonsterCard = new MonsterCard(damage, health,elementType);
}
