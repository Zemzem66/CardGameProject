package main;
import com.example.cardgame.*;
import com.example.cardgame.MonsterCard;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static javafx.application.Application.launch;

public class main {
    static ByteArrayOutputStream baos = new ByteArrayOutputStream();
    static PrintStream ps = new PrintStream(baos);
    static PrintStream old = System.out;

    public String battleLog()
    {
        System.out.println("Here"+baos.toString());
        //return null;
        return baos.toString();
    }
    public static Card fight(Card cardfirst, Card cardsecond) {
        System.setOut(ps);
            //EFFECTIVNES 1:
            // Water > fire
            if(cardfirst.getElementType().equals("Fire")  && cardsecond.getElementType().equals("Water"))
            {
                cardfirst.setDamage(cardfirst.getDamage()/2);
                cardsecond.setDamage(cardsecond.getDamage()*2);
                if(cardfirst.getDamage() > cardsecond.getDamage())
                {
                    System.out.println(cardfirst.getUsername() + ": " + cardfirst.getElementType() + "("+cardfirst.getDamage() +") wins: " +" vs "+
                           cardsecond.getUsername()+" "+ cardsecond.getElementType() + "("+cardsecond.getDamage() +")" );

                    System.out.flush();
                    System.setOut(old);
                    return cardfirst;
                }else if(cardfirst.getDamage() < cardsecond.getDamage())
                {
                    System.out.println(cardsecond.getUsername() + ": " + cardsecond.getElementType() + "("+cardsecond.getDamage() +") wins: " +" vs "+
                            cardfirst.getUsername()+" "+ cardfirst.getElementType() + "("+cardfirst.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardsecond;
                }
                else{
                    System.out.println("-----------------Draw---------------");
                    System.out.flush();
                    System.setOut(old);
                    return null;
                }
             //   fire > normal
            }else if(cardfirst.getElementType().equals("Fire") && cardsecond.getElementType().equals("Normal"))
            {
                cardfirst.setDamage(cardfirst.getDamage()*2);
                if(cardfirst.getDamage() > cardsecond.getDamage())
                {
                    System.out.println(cardfirst.getUsername() + ": " + cardfirst.getElementType() + "("+cardfirst.getDamage() +") wins: " +" vs "+
                            cardsecond.getUsername()+" "+ cardsecond.getElementType() + "("+cardsecond.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardfirst;
                } else if (cardfirst.getDamage() < cardsecond.getDamage()) {
                    System.out.println(cardsecond.getUsername() + ": " + cardsecond.getElementType() + "("+cardsecond.getDamage() +") wins: " +" vs "+
                            cardfirst.getUsername()+" "+ cardfirst.getElementType() + "("+cardfirst.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardsecond;
                } else {
                    System.out.println("-------------DRAW---------------");
                    System.out.flush();
                    System.setOut(old);
                    return null;
                }
            }
            //   normal > water
            else if (cardfirst.getElementType().equals("Normal") && cardsecond.getElementType().equals("Water")) {
                cardfirst.setDamage(cardfirst.getDamage()*2);
                if(cardfirst.getDamage() > cardsecond.getDamage())
                {
                    System.out.println(cardfirst.getUsername() + ": " + cardfirst.getElementType() + "("+cardfirst.getDamage() +") wins: " +" vs "+
                            cardsecond.getUsername()+" "+ cardsecond.getElementType() + "("+cardsecond.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardfirst;
                }

                else if(cardfirst.getDamage() < cardsecond.getDamage()) {
                    System.out.println(cardsecond.getUsername() + ": " + cardsecond.getElementType() + "("+cardsecond.getDamage() +") wins: " +" vs "+
                            cardfirst.getUsername()+" "+ cardfirst.getElementType() + "("+cardfirst.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardsecond;
                }
                else{
                    System.out.println("-------------DRAW------------");
                    System.out.flush();
                    System.setOut(old);
                    return null;
                }
            } else if (cardfirst.getElementType().equals("Water") && cardsecond.getElementType().equals("Fire")) {
                cardfirst.setDamage(cardfirst.getDamage()*2);
                if(cardfirst.getDamage() > cardsecond.getDamage())
                {
                    System.out.println(cardfirst.getUsername() + ": " + cardfirst.getElementType() + "("+cardfirst.getDamage() +") wins: " +" vs "+
                            cardsecond.getUsername()+ " "+ cardsecond.getElementType() + "("+cardsecond.getDamage() +")" );                } else if (cardfirst.getDamage() < cardsecond.getDamage()) {
                    System.out.flush();
                    System.setOut(old);
                    return cardfirst;
                }
                else if (cardsecond.getDamage() > cardfirst.getDamage())
                {
                    System.out.println(cardsecond.getUsername() + ": " + cardsecond.getElementType() + "("+cardsecond.getDamage() +") wins: " +" vs "+
                            cardfirst.getUsername()+" "+ cardfirst.getElementType() + "("+cardfirst.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardsecond;
                }
                else {
                    System.out.println("-------------DRAW------------");
                    System.out.flush();
                    System.setOut(old);
                    return null;
                }
            }
            else if(cardfirst.getElementType().equals("Normal") && cardsecond.getElementType().equals("Fire"))
            {
                cardfirst.setDamage(cardfirst.getDamage()*2);
                if(cardfirst.getDamage() > cardsecond.getDamage())
                {
                    System.out.println(cardfirst.getUsername() + ": " + cardfirst.getElementType() + "("+cardfirst.getDamage() +") wins: " +" vs "+
                            cardsecond.getUsername()+" "+ cardsecond.getElementType() + "("+cardsecond.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardfirst;
                } else if ((cardfirst.getDamage() < cardsecond.getDamage())) {
                    System.out.println(cardsecond.getUsername() + ": " + cardsecond.getElementType() + "("+cardsecond.getDamage() +") wins: " +" vs "+
                            cardfirst.getUsername()+" "+ cardfirst.getElementType() + "("+cardfirst.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardsecond;

                } else {
                    System.out.println("------------DRAW-------------");
                    System.out.flush();
                    System.setOut(old);
                    return null;
                }
            }else if (cardfirst.getElementType().equals("Water")&& cardsecond.getElementType().equals("Normal")) {
                cardsecond.setDamage(cardfirst.getDamage()*2);
                if(cardfirst.getDamage() > cardsecond.getDamage())
                {
                    System.out.println(cardfirst.getUsername() + ": " + cardfirst.getElementType() + "("+cardfirst.getDamage() +") wins: " +" vs "+
                            cardsecond.getUsername()+" "+ cardsecond.getElementType() + "("+cardsecond.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardfirst;
                }
                else if(cardfirst.getDamage() < cardsecond.getDamage()) {
                    System.out.println(cardsecond.getUsername() + ": " + cardsecond.getElementType() + "("+cardsecond.getDamage() +") wins: " +" vs "+
                            cardfirst.getUsername()+" "+ cardfirst.getElementType() + "("+cardfirst.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardsecond;
                }else {
                    System.out.println("------------DRAW-------------");
                    System.out.flush();
                    System.setOut(old);
                    return null;
                }
            }
            else{
                if(cardfirst.getDamage() > cardsecond.getDamage())
                {
                    System.out.println(cardfirst.getUsername() + ": " + cardfirst.getElementType() + "("+cardfirst.getDamage() +") wins: " +" vs "+
                            cardsecond.getUsername()+" "+ cardsecond.getElementType() + "("+cardsecond.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardfirst;
                } else if (cardfirst.getDamage() < cardsecond.getDamage()) {
                    System.out.println(cardsecond.getUsername() + ": " + cardsecond.getElementType() + "("+cardsecond.getDamage() +") wins: " +" vs "+
                            cardfirst.getUsername()+" "+ cardfirst.getElementType() + "("+cardfirst.getDamage() +")" );
                    System.out.flush();
                    System.setOut(old);
                    return cardsecond;
                } else {
                    System.out.println("-------------draw-----------");
                    System.out.flush();
                    System.setOut(old);
                    return cardfirst;
                }
            }
            return null;
           // return "Test!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
        }

    public static void main(String[] args) {
        Card kCard1 = new MonsterCard(10,"Water","Goblin","Kienboec");
        Card kCard2 = new MonsterCard(50, "Normal", "Dragon", "kienboec");
        Card kCard3 = new SpellCard(20, "Water", "Spell","kienboec");
       // kCard3.setCardType(CardType.SpellCard);
        Card kCard4 = new MonsterCard(28, "Normal","Regular", "kienboec");


        Card aCard1 = new MonsterCard(50, "Normal", "Regular", "altenhof");
        Card aCard2 = new MonsterCard(20, "Normal", "Knight", "altenhof");
        Card aCard3 = new SpellCard(22, "Water", "Spell", "altenhof");
        Card aCard4 = new SpellCard(45, "Normal", "Regular", "altenhof");
        List<Card> mycards = new ArrayList<>();
        mycards.add(kCard1);
        mycards.add(kCard2);
        mycards.add(kCard3);
        mycards.add(kCard4);
        mycards.add(aCard1);
        mycards.add(aCard2);
        mycards.add(aCard3);
        mycards.add(aCard4);

        User users = new User();
      //  System.out.println(users.getDeckArray().get(0)+ "WHATS INSDE");

        System.out.println(mycards);

       // for(int i = 0; i < 100 ; i++) {
       //    Collections.shuffle(mycards);
            fight(kCard1, aCard1);
      //  }


        //User usereins = new User("Ray", "Password");
        //User userzwei = new User("Drake", "PasswordZwei");

    }




}
