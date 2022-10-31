package com.ironhack;

import com.ironhack.battle.Battle;
import com.ironhack.battle.Duel;
import com.ironhack.character.Character;
import com.ironhack.party.Party;
import com.ironhack.party.PartyFactory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static PartyFactory _partyFactory;
    private static List<Character> _userCharacters;
    private static List<Character> _enemyCharacters;
    private static Party _userParty;
    private static Party _enemyParty;
    private static ArrayList<Duel> duelArrayList = new ArrayList<>();
    private static Battle battle = new Battle();
    public static void main(String[] args) throws FileNotFoundException {
        initDependencies();
        // init with creating party from csv or manually
        init(_userCharacters);
        //then create random party to fight against the user
        //randomPartyCreation();
        init2(_enemyCharacters);
        //optional: csv created with parties

        //user selects the champs to fight in every round

        ArrayList<Character> blueParty = new ArrayList<>(); //aqui deberiamos teher las dos partis creadas
        ArrayList<Character> redParty = new ArrayList<>();
        ArrayList<Duel> duelArrayList;
        duelArrayList= createDuels(blueParty,redParty); //aqui hay que meterle las dos parties

        //init fight
        Battle battle = new Battle();
        battle.allDuels(duelArrayList); // llamo al metodo y le paso la lista de duelos
                                        // battle deberia terminar con dos partys, la q tenga mas characters gana

        //show winner
        showWinner();
        //show graveyard ??
        showGraveyard();
        //want to play again?

        //optional: randomize fight
    }

    /**
     * Method to init dependencies needed
     */
    public static void initDependencies(){
        _partyFactory = new PartyFactory();
        _userCharacters = new ArrayList<>();
        _enemyCharacters = new ArrayList<>();
    }

    /**
     * Initialize game, creation of user parties
     * @param _userCharacters
     * @throws FileNotFoundException
     */
    public static void init(List _userCharacters) throws FileNotFoundException {
        _userParty = _partyFactory.selectCreationMethod1(_userCharacters);
    };

    public static void init2(List _enemyCharacters) throws FileNotFoundException {
        _enemyParty = _partyFactory.selectCreationMethod2(_enemyCharacters);
    };

    /**
     * Creates a random party to fight against user
     */
/*    public static void randomPartyCreation(){
        Main._enemyParty = _partyFactory.createRandomParty(_userParty.getSize());
        System.out.println("================================");
        System.out.println("This are the enemies (Red Party:");
        System.out.println(Main._enemyParty);
        System.out.println("================================");
    };
*/

/* // to check conflic - develop main

    public static void csvPartyCreator(){};

    public static ArrayList<Duel> createDuels(ArrayList<Character> blueParty, ArrayList<Character> redParty){

        int numberDuels = blueParty.size();
        ArrayList<Duel> duelArrayList = new ArrayList<>(numberDuels); // we create a list of duels of the same size as one of the parties
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        System.out.println("the are "+numberDuels+" number of fighter in each team, we need to create "+numberDuels+ " duels.");
        while (i<numberDuels){

            Duel duel = new Duel(numberDuels); //create new duel
            System.out.println("chose 2 fighters, one from each team that you want to have a duel.");
            showParty(blueParty,redParty);
            System.out.println("chose one fighter from the blue team by writing the name: ");

            for (int k = 0; k<blueParty.size(); k++ ) {  // we check the whole list
                if (blueParty.get(k).getName() == scanner.nextLine()){ //when it find the name
                    duel.setId(numberDuels); //assign a number to the duel
                    duelArrayList.add(duel); //a this duel to a list of duels
                    duel.setBlueFighter( blueParty.get(k) );  //introcude the blue fighter into the duel
                    blueParty.remove(i);    //take out of the bluelist
                }
            }
            System.out.println("chose one fighter from the red team by writing the name: ");
            for (int j = 0; j<redParty.size(); j++ ) {  // we check the whole list
                if (redParty.get(j).getName() == scanner.nextLine()){ //when it find the name
                    duel.setRedFighter( redParty.get(j) );  //introcude the red fighter into the duel
                    redParty.remove(j);    //take out of the redlist
                }
            }
            System.out.println("the fighters for the duel number "+duel.getId()+" are:");
            System.out.println(duel.getBlueFighter()+" vs "+duel.getRedFighter() );
        }
        System.out.println("we finished at creating the duels, the battle is ready to start!");
        return duelArrayList;
    }


    public static void showParty(ArrayList<Character> blueParty, ArrayList<Character> redParty){
        System.out.println("the members on the party blue:");
        for (Character j : blueParty) {
            System.out.println(blueParty);    //esto hay q acomodarlo para que lo imprima bien
        }
        System.out.println("=======================================");
        System.out.println("the members on the party red:");
        for (Character j : redParty) {
            System.out.println(redParty);
            */
            

    /**
     * select fighters to fight agains from each party
     */
    public static ArrayList<Duel> selectFightersFromParties(Party _userParty, Party _enemyParty, int n){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Duel> duelList = new ArrayList<>();
        for (int k=0; k<n; k++) {

            Duel duel = new Duel(k);     //create a new duel to later add then to a list of Duels
            System.out.println("========================================================");
            System.out.println("chose 2 fighters, one from each team that you want to have a duel.");
            System.out.println("Now chose one fighter from the 'Blue' team by writing the name: ");
            System.out.println(_userParty);
            String fighterBlueName = scanner.nextLine();
            for (int i = 0; i < _userParty.getPartyList().size(); i++) {  // we check the whole list
                if (_userParty.getPartyList().get(i).getName().equalsIgnoreCase(fighterBlueName)) { //when it find the name
                    duel.setBlueFighter(_userParty.getPartyList().get(i));  //introcude the blue fighter into the duel
                    _userParty.getPartyList().remove(i);    //take out of the bluelist
                    break;
                }
            }
            System.out.println("Now chose one fighter from the 'Red' team by writing the name: ");
            System.out.println(_enemyParty);
            String fighterRedName = scanner.nextLine();
            for (int j = 0; j < _enemyParty.getPartyList().size(); j++) {  // we check the whole list
                if (_enemyParty.getPartyList().get(j).getName().equalsIgnoreCase(fighterRedName)) { //when it find the name
                    duel.setRedFighter(_enemyParty.getPartyList().get(j));  //introcude the red fighter into the duel
                    _enemyParty.getPartyList().remove(j);    //take out of the redlist
                    break;
                }
            }
            System.out.print("the fighters for the duel number " + duel.getId() + " are: ");
            System.out.println(duel.getBlueFighter() + " vs " + duel.getRedFighter());
            duelList.add(duel);
        }
        System.out.println(duelList);
        return duelList;
    }

    public static void initFight(ArrayList<Duel> duelArrayList){
        Battle.duelStart(duelArrayList);
    }

    public static void showWinner() {
        System.out.println(Battle.blueParty);
        System.out.println(Battle.redParty);
        if (Battle.blueParty.getPartyList().size() > Battle.redParty.getSize()){
            System.out.println("the winner is the 'Blue' party!");
            System.out.println(Battle.blueParty);
        } else if (Battle.blueParty.getSize()<Battle.redParty.getSize()){
            System.out.println("The winner is the 'Red' party!");
            System.out.println(Battle.redParty);
        } else {
            System.out.println("there is no bigger party to show the winner party");

        }

    }

    public static void showGraveyard(){
        System.out.println("the graveyard end up as follow:");
        System.out.println("Blue team: "+Battle.graveyard.getBlueCorpsesArray());
        System.out.println("Red team: "+Battle.graveyard.getRedCorpsesArray());
    }


    public static void startFight(Battle battle){

    public static void csvPartyCreator(){};
    
   //conflic check develop - main public static void startFight(){
   
    }

}