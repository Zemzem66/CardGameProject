package com.example.cardgame;

public class Packages {
    private Card[] playerOne;
    private Card[] playerTwo;
    private int[] myValue;

    Packages(Stack myStack, int rounds)
    {
        myValue = new int[rounds];
        playerOne = new Card[5]; // ???? fixe werte oder ?
        playerTwo = new Card[5];

        for(int i = 0; i < rounds; i++)
        {
        //    playerOne[i] = myStack.getFromDeck; // gets the hand for player one
          //  playerTwo[i] = myStack.getFromDeck; // gets the hand for player two

        }

    }
}
