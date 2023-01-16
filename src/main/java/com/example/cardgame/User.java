package com.example.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    //ROUNDS MAX 100
    int userId;

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }

    Deck deck;
    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    boolean battle = false;
    List<Card> stack = new ArrayList<>(); // stack muss, class erstellt werden
/*
    public List<Card> getDeck() {
        return deck;
    }

    public void setDeck(List<Card> deck) {
        this.deck = deck;
    }

 */

    public List<Card> getDeckArray() {
        return deckArray;
    }

    public void setDeckArray(List<Card> deckArray) {
        this.deckArray = deckArray;
    }

    List<Card> deckArray = new ArrayList<>(); // deck muss, class erstellt werden
    private static List<Card> cards = new ArrayList<>();

    //Shuffler von Cards
    //public User() {}
    public void shuffle()
    {
        Collections.shuffle(this.cards); // mischt meine karten
    }



    String username; // Benutzername

    //Request an den Server.Server

    //Server.Server serverReqeuet = new Server.Server();

    String password; // password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username+"\r";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void printUserName()
    {
        System.out.println(getUsername());

    }
    int coins;
/*
    boolean battle()
    {
          if()

    }

    int getStack();

    void setStack();

    int isTrading();


    boolean isRegister();

    boolean isLogin();

    int AquiredCard();

    boolean isAquired();

    int compareStats();
*/
   // Packages cardPackages = new Packages();
public static void main(String[] args) {
    //Testing cards
   // cards = (List<Card>) new MonsterCard(1,2,ElementType.randomElement(),MonsterName.Ork);
   /// Card card = new Card(ElementType.randomElement(), 1,CardType.;
}





}
