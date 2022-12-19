package com.example.cardgame;

import java.util.ArrayList;
import java.util.Random;

public abstract class Card {

    //Klasse, NOETIG ODER NICHT

    ElementType elementType;
    public int damage;
    CardType cardType;

    //---------------------------Random
    //CARDS
    private Random mRandom;
    private ArrayList<Card> mCards;
    private ArrayList<Card> mPulledCards;

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Card(ElementType elementType, int damage, CardType cardType) {
        this.elementType = elementType;
        this.damage = damage;
        this.cardType = cardType;
    }

    public abstract String name();

    public abstract int damage();

    public abstract String elementType();

    void createStack()
    {

    }
    //public Card CardCreate()
    //{
      //  mRandom = new Random();
       // mPulledCards = new ArrayList<Card>();
        //mCards = new ArrayList<Card>(MonsterName.values().length * Spells.values().length);
    //}

    //MonsterCard monsterCard = new MonsterCard(5,2,4,5);
    //koennen monster alle zauber aufuehren, was ist der Unterschied zwischen, Monster aund Spellcards
}
