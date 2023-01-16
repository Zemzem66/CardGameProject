package com.example.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Deck {




    List<Card> myCards = new ArrayList<Card>();

    public List<Card> getMyCards() {
        return myCards;
    }

    public void setMyCards(Card myCardsT) {
        myCards.add(myCardsT);
    }

    Card card1;
    Card card2;
    Card card3;
    Card card4;
    public Deck() {
    }

    public Card getCard1() {
        return card1;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public Card getCard2() {
        return card2;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public Card getCard3() {
        return card3;
    }

    public void setCard3(Card card3) {
        this.card3 = card3;
    }

    public Card getCard4() {
        return card4;
    }

    public void setCard4(Card card4) {
        this.card4 = card4;
    }
}
