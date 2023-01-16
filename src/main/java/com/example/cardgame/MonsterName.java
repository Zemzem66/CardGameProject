package com.example.cardgame;

public enum MonsterName {
    Wizard {
        String Wizzard()
        {
            return "Wizard";
        }
    },
    Goblin {
        String Goblin()
        {
            return "Goblin";
        }
    },
    Kraken {
        String Kraken()
        {
            return "Kraken";
        }
    },
    FireElve {
        String Elf()
        {
            return "Elf";
        }
    },
    Ork {
        String OrkName()
        {
            return "Ork";
        }
    },
    Dragon {
        String DragonName(){ return "Dragon";}
    },
    Knight {
        String Knight() {return "Knight";}
    },
    Spell{
        String Spell() {return "Spell";}
    },
    Regular{
        String RegularSpell() {
            return "RegularSpell";
        }
    }


}
