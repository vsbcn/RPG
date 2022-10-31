package com.ironhack.battle;

import com.ironhack.character.Character;
import com.ironhack.graveyard.Graveyard;
import java.util.ArrayList;

public class Battle {

/*
    public Graveyard graveyard = new Graveyard();

    public ArrayList<Character> blueParty; //the parties should be empty at the start of the battle
    public ArrayList<Character> redParty;



    public void allDuels(ArrayList<Duel> duelArrayList) {
        System.out.println("the battle is about to start.");
        for (int k = 0; k < duelArrayList.size(); k++) {
            Character blueFighter = duelArrayList.get(k).getBlueFighter();
            Character redFighter = duelArrayList.get(k).getRedFighter();
            System.out.println("the duel number "+(k+1)+" is about to start:");
            System.out.println("the fighters for this duel are :"+blueFighter.getName()+" (blue party), and "+redFighter.getName()+" (red party.");

            ArrayList<Integer> rounds = new ArrayList<Integer>();       //create an unspecified list of rounds
            // the battle start
            int i = 1;
            while (blueFighter.getHp() > 0 && redFighter.getHp() > 0) {
                rounds.add(i);  //we add a round and a number
                System.out.println("Round " + i);
                blueFighter.highAttack(redFighter);
                redFighter.highAttack(blueFighter);
*/

    public static Graveyard graveyard = new Graveyard();
    public static Party blueParty = new Party();
    public static Party redParty = new Party();

    public static void duelStart(ArrayList<Duel> duelList) {
        for (Duel k : duelList) { //run list of duels
            Character fighterBlue = k.getBlueFighter();
            //-------->System.out.println(fighterBlue.getName());
            Character fighterRed = k.getRedFighter();

            ArrayList<Integer> rounds = new ArrayList<>();       //create an unspecified list of rounds
            // the battle start
            int i = 0;
            System.out.println(fighterBlue.getHp());   ////borrar
            while (fighterBlue.getHp() > 0 && fighterRed.getHp() > 0) {
                rounds.add(i);
                System.out.println("Round "+rounds.get(i));
                System.out.println(fighterBlue.getName()+" hits "+fighterRed.getName());
                fighterBlue.highAttack(fighterRed);
                System.out.println(fighterRed.getName()+" hits "+fighterBlue.getName());
                fighterRed.highAttack(fighterBlue);

                i++;
            }

            //results of  the battle

            if (blueFighter.getHp() <= 0 && redFighter.getHp() <= 0) { //check te hp
                blueFighter.setIsAlive(false);
                redFighter.setIsAlive(false);
                graveyard.setBlueCorpse(blueFighter);   //send to graveyard
                graveyard.setRedCorpse(redFighter);
                System.out.println("The battle is a Draw!");
            } else if (blueFighter.getHp() <= 0) {
                blueFighter.setIsAlive(false);
                graveyard.setBlueCorpse(blueFighter);
                System.out.println("The winner is: " + redFighter.getName());
                redParty.add(redFighter);   //return of the winner to the Red party
            } else if (redFighter.getHp() <= 0) {
                redFighter.setIsAlive(false);
                graveyard.setRedCorpse(redFighter);
                System.out.println("The winner is: " + blueFighter.getName());
                blueParty.add(blueFighter);  //return the winner to the Blue party
            }

            //show graveyard
            showGraveyard();



        }
    }

        //to show the fighters in the graveyard
        public void showGraveyard() {
            System.out.println("this is the graveyard..");
            System.out.println("the fighter of the blue party :"+graveyard.getBlueCorpsesArray());
            System.out.println("the fighter of the red party"+graveyard.getRedCorpsesArray());
            System.out.println("====================================================");
        }
}

