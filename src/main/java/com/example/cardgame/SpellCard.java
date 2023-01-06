package com.example.cardgame;

public class SpellCard extends Card {
    //effective (eg: water is effective against fire, so damage is doubled)
    //– not effective (eg: fire is not effective against water, so damage is halved)
    //– no effect (eg: normal monster vs normal spell, no change of damage,
    // directwater -> fire
    //• fire -> normal
    //• normal -> water


    public Spells getSpellType() {
        return spellType;
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

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public SpellCard(ElementType elementType, Spells spellType, int damage) {
        super(elementType,damage, CardType.SpellCard);
        this.spellType = spellType;
    }




}
