package com.example.cardgame;

import java.util.Random;

public enum Spells {
    FireSpell(10, 100)
            {
                String FireSpell()
                {
                    return "FireSpell";
                }
            },
    WaterSpell(20,100)
            {
                String WaterSpell()
                {
                    return "WaterSpell";
                }
            },
    NormalSpell(12,1)
            {
                String NormalSpell(){return "NormalSpell";}
            };

    public int SpellDamage;
    public int SpellHealth;

    Spells(int SpellDamage,int SpellHealth)
    {
        this.SpellDamage = SpellDamage;
        this.SpellHealth = SpellHealth;
    }
    public int getDamage()
    {
        return SpellDamage;
    }
    public void setDamage(int damage)
    {
        this.SpellDamage = damage;
    }
    public int getSpellHealth()
    {
        return SpellHealth;
    }
    public void setSpellHealth(int SpellDamage)
    {
        this.SpellHealth -= SpellDamage;
    }

    public static Spells getRandomSpells() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }




}
