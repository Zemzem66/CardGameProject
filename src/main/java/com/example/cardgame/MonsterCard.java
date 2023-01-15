package com.example.cardgame;

public class MonsterCard extends Card /*implements Playable */{
    //ALLE MONSTER UNTERSCHIEDLICHE SKILLS/


    MonsterType monsterType;

    MonsterName monsterName;
    int fire;
    int normal;

    int health;
    public MonsterCard(int damage, ElementType elementType, MonsterName monsterName) {
        super(elementType, damage, CardType.SpellCard);
        this.monsterName = monsterName;
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
