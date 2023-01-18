package com.example.cardgame;

public class MonsterCard extends Card /*implements Playable */{

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    String monsterName;
    int fire;
    int normal;

    String username;
    int health;
    public MonsterCard(int damage, String elementType, String monsterName, String username) {
        super(elementType, damage, CardType.MonsterCard);
        this.monsterName = monsterName;
        this.username = username;
    }

    public MonsterCard() {
        super();
    }



    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //Function Attack can be inherited <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public int getWater() {
        return damage;
    }

    public void setWater(int damage) {
        this.damage = damage;
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

    @Override
    public String name() {
        return null;
    }

    @Override
    public double damage() {
        return 0;
    }


    @Override
    public String elementType() {
        return null;
    }

    @Override
    public String cardType() {
        return null;
    }


    public void setDecreaseHealth(int damage)
    {
        this.health -=damage;
    }
    public void attack(MonsterCard monster)
    {
        monster.setDecreaseHealth(damage);
    }



    public void print()
    {
        System.out.println(getHealth());
    }
}
