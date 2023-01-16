package com.example.cardgame;
public enum CardType {
    SpellCard {
        String SpellCard()
        {
            return "Spell";
        }
    },
    MonsterCard {
        String MonsterCard() {
            return "Monster";
        }
    }
}
