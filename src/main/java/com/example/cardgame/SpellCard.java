package com.example.cardgame;

public class SpellCard extends Card {

String username;
    public Spells getSpellType() {
        return spellType;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public void setSpellType(Spells spellType) {
        this.spellType = spellType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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

    Spells spellType;

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }
/*
    public SpellCard(ElementType elementType, Spells spellType, int damage) {
        super(elementType,damage, CardType.SpellCard);
        this.spellType = spellType;
    }


 */

    public SpellCard(int damage, String elementType, String monsterName, String username) {
        super(elementType, damage, CardType.SpellCard);
        this.monsterName = monsterName;
        this.username = username;
    }


}
