package com.example.cardgame;

import java.util.ArrayList;
import java.util.List;

public class User {
    boolean battle = false;
    List<String> stack = new ArrayList<String>(); // stack muss erstellt werden
    List<String> deck = new ArrayList<String>(); // deck muss erstellt werden
    String username; // Benutzername

    //Request an den Server.Server

    //Server.Server serverReqeuet = new Server.Server();

    String password; // password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
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






}
