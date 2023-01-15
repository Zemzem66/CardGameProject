package com.example.cardgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.main;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //stage.setTitle("Hello!");
        //stage.setScene(scene);
        //stage.show();
    }



    //SpellCard spellCards =new SpellCard(15,15,12);
//<!--Wizard funktionert nicht beim werte eingeben!--!>
    public static void fight(MonsterCard monsterOne, MonsterCard monsterTwo ) {
        for (int i = 0; i < 100; i++) {
            //GENERATOR fehlt
            if(monsterOne.damage > monsterTwo.damage)
            {
                monsterOne.attack(monsterTwo);
            }

            if(monsterOne.damage < monsterTwo.damage) {
                monsterTwo.attack(monsterOne);
            }
            if(monsterOne.getHealth() <= 0 || monsterTwo.getHealth() <= 0)
            {
                break;
            }
            break;
        }
    } // Wie kann man diese logisch erweitern, sodass winner geprinted wird


    public static void SpellFight(Spells spell1, Spells spell2)
    {
        /*
        if(spell1 == Spells.FireSpell)
        {
            System.out.println(spell1 +" is "+ Spells.FireSpell);
        }
        if(spell1 == Spells.WaterSpell)
        {
            System.out.println(spell1 +" is "+ Spells.WaterSpell);
        }
        if(spell1 == Spells.NormalSpell)
        {
            System.out.println(spell1 +" is "+ Spells.NormalSpell);
        }*/

        //Enum ein String, und ausgeben
        //TODO SPELLS ISNT WORKING WELL, FIRESPELL = HEALTH / 2 AND WATERSPELL DAMAGE * 2
        if(spell1.SpellDamage > spell2.SpellDamage)
        {
            if((spell1 == Spells.WaterSpell && spell2 == Spells.FireSpell) ||(spell2 == Spells.WaterSpell && spell1 == Spells.FireSpell) ){
                System.out.println(spell2.SpellHealth);
                spell2.SpellHealth = spell2.SpellHealth / 2;


                System.out.println(spell2.getSpellHealth());
                spell2.setSpellHealth(spell1.SpellDamage * 2 );
                System.out.println(spell2.getSpellHealth());

            }

            System.out.println(spell1 + " defeats " + spell2 + " health: "+ spell2.getSpellHealth());
        }
        else if(spell2.SpellDamage > spell1.SpellDamage)
        {
            spell1.setSpellHealth(spell2.SpellDamage);
            System.out.println(spell2+" defeats "+spell1 + " health: "+ spell1.getSpellHealth());
        }
    }
    public static void main(String[] args) {

        //ElementType elementType = null;
        //System.out.println(elementType);


        //ElementType.FIRE


        User playerOne = new User("Mike", "1234567");
        User playerTwo = new User("Kayle", "1234567");
        //Wizard, damage, health, element -> fire, normal, water -> String

        MonsterName monsterName;
        ElementType elementType;
        //<!0--------------TODO ELEMENTE RICHT ZUORDNENE >> passed
        //  MonsterCard myWizzard = new MonsterCard(11,1,ElementType.randomElement(),MonsterName.Wizard);


        //MonsterCard kraken = new Kraken(15,1,ElementType.randomElement(),MonsterName.Kraken);
        //MonsterCard goblin = new MonsterCard(15,1, ElementType.randomElement(),MonsterName.Goblin);
        // MonsterCard ork = new MonsterCard(15,1,ElementType.randomElement(),MonsterName.Ork);
        //MonsterCard fireElves = new MonsterCard(15,1,ElementType.randomElement(),MonsterName.FireEvle);

        //<--TODO: MonsterCard goblin = new Goblin(15,1,ElementType.randomElement(),MonsterName.Golbin); das ist alte Version

        playerOne.printUserName(); //Player one <<<<<<<<<<<<<<<<-------------------------
        playerTwo.printUserName(); //Player two <<<<<<<<<<<<<<<--------------------------
        //  myWizzard.getMonsterName(); !!!!!! Fragen !!!!!
        MonsterName wizardName = MonsterName.Wizard;
        System.out.println(wizardName);
        // myWizzard.print();


        MonsterName goblinName = MonsterName.Goblin;
        System.out.println(goblinName);
        //goblin.print();
/*
        while(myWizzard.getHealth() != 0 || goblin.getHealth() !=0) {
            fight(goblin, myWizzard);
            //spater bitte testen ob die fight functin ,funktioniert.

            if (myWizzard.getHealth() <= 0) {
                System.out.println(goblinName+" defeats Wizard");

                break;
            } else if (goblin.getHealth() <= 0) {
                System.out.println(wizardName+" defeats Goblin");

                break;
            }
        }
        System.out.println("Wizard health: "+myWizzard.getHealth());
        System.out.println("Goblin health: " +goblin.getHealth());



        //  System.out.println("Hello");
        //effective, if water and fire is spelled, double fire

  //      if(spellCards.)




        ///SpellCars Testss
       // Spells randomSpells =Spells.getRandomSpells();
        Spells fireSpell = Spells.FireSpell;
        Spells waterSpell = Spells.WaterSpell;
        Spells normalSpell = Spells.NormalSpell;

        //SpellFight(normalSpell,fireSpell);
 //TODO Spells > wrong output, with too much spellsFights
        SpellFight(Spells.getRandomSpells(),Spells.getRandomSpells());

        //TODO,WIE KANN MAN ENUM MIT CLASSE Kombinieren? kann man nicht


        launch();
    }
*/
    }
}