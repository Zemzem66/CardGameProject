package com.example.cardgame;

public class FireEvle extends MonsterCard {


    public FireEvle(int damage,  int health,ElementType elementType,MonsterName monsterName) {
        super(damage, health,elementType,monsterName);
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

    //public MonsterCard getMyMonsterCard() {
      //  return myMonsterCard;
    //}

    //public void setMyMonsterCard(MonsterCard myMonsterCard) {
       // this.myMonsterCard = myMonsterCard;
    //}

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int damage() {
        return 0;
    }

    //MonsterCard myMonsterCard = new MonsterCard(damage,health);

}
