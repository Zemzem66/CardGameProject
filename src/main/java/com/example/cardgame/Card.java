package com.example.cardgame;

public abstract class Card {



    String username;
    //Klasse, NOETIG ODER NICHT
    String monsterName;
    String elementType;
    public int damage;
    CardType cardType;

  //  public Card(String monsterspellname, String etype, int damageValue, String ctype) {
    //}

    public Card() {

    }



    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
//---------------------------Random
    //CARDS
   // private Random mRandom;
    //private ArrayList<Card> mCards;
    //private ArrayList<Card> mPulledCards;

    //public Card(String elementType, double damage, String cardType) {

    //}

    public String getElementType() {
        return elementType;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setElementType(String elementType) {
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

    public Card(String elementType, int damage, CardType cardType) {
        this.elementType = elementType;
        this.damage = damage;
        this.cardType = cardType;
    }

    public abstract String name();

    public abstract double damage();

    public abstract String elementType();

    public abstract String cardType();
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
