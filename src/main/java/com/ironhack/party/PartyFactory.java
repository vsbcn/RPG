package com.ironhack.party;

import com.ironhack.character.Character;
import com.ironhack.character.factory.CharacterFactory;
import com.ironhack.character.factory.CharacterType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartyFactory {
    private CharacterFactory _characterFactory = new CharacterFactory();
    private Party _userParty;
    private Party _enemyParty;

    /**
     * Let user decide how to create a party and creates according to the method
     * @param _userCharacters
     * @return Party user party created
     * @throws FileNotFoundException
     */
    public Party selectCreationMethod1(List _userCharacters) throws FileNotFoundException {
        int creatingMethod;
        System.out.println("================================");
        System.out.println("Hello! Welcome to Assassins Git");
        System.out.println("Choose how you want to create the characters: ");
        System.out.println("Press 1 to import a CSV");
        System.out.println("Press 2 to write manually");
        System.out.println("================================");

        Scanner in = new Scanner(System.in);

        //creatingMethod = in.nextInt();
        creatingMethod = 1;
        if(creatingMethod == 1){
            //user create party, input output
            _userParty = csvPartyReader(_userCharacters);
        } else if (creatingMethod == 2) {
            //user import csv
            _userParty = userPartyCreation(_userCharacters);
        } else {
            System.out.println("Method not found");
            return null;
        }
        System.out.println("this are your characters (Blue Party): ");
        System.out.println(_userParty);
        return _userParty;
    }

    public Party selectCreationMethod2(List _enemyCharacters) throws FileNotFoundException {
        int creatingMethod;
        System.out.println("================================");
        System.out.println("Choose how you want to create the characters for the enemy team: ");
        System.out.println("Press 1 to import a CSV");
        System.out.println("Press 2 to write manually");
        System.out.println("================================");

        Scanner in = new Scanner(System.in);

        //creatingMethod = in.nextInt();
        creatingMethod = 1;
        if(creatingMethod == 1){
            //enemy create party, input output
            _enemyParty = csvPartyReader2(_enemyCharacters);
        } else if (creatingMethod == 2) {
            //enemy import csv
            _enemyParty = enemyPartyCreation(_enemyCharacters);
        } else {
            System.out.println("Method not found");
            return null;
        }
        System.out.println("this are your characters (Red Party): ");
        System.out.println(_enemyParty);
        return _enemyParty;
    }


    /**
     * Reads the CSV from te User to create a party of Characters
     * @throws FileNotFoundException
     */
    public Party csvPartyReader(List _userCharacters) throws FileNotFoundException {
        System.out.println("Tell me the path and name of the CSV, ex: party.csv");
        Scanner in = new Scanner(System.in);
        //String route = "src/" + in.nextLine();
        String route = "src/party.csv";
        File userCsv = new File(route);

        Scanner myReader = new Scanner(userCsv);

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] characterInfo = data.split(",");
            Character character = _characterFactory.create(CharacterType.valueOf(characterInfo[0]), characterInfo[1]);
            _userCharacters.add(character);
        }
        _userParty = new Party("blue",_userCharacters);
        myReader.close();
        return _userParty;
    };

    public Party csvPartyReader2(List _enemyCharacters) throws FileNotFoundException {
        System.out.println("Tell me the path and name of the CSV, ex: party2.csv");
        Scanner in = new Scanner(System.in);
        //String route = "src/" + in.nextLine();
        String route = "src/party2.csv";
        File userCsv = new File(route);

        Scanner myReader = new Scanner(userCsv);

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] characterInfo = data.split(",");
            Character character = _characterFactory.create(CharacterType.valueOf(characterInfo[0]), characterInfo[1]);
            _enemyCharacters.add(character);
        }
        _enemyParty = new Party("Red",_enemyCharacters);
        myReader.close();
        return _enemyParty;
    };

    /**
     * Method to create each character manually from user input and add to the party
     */
    public Party userPartyCreation(List _userCharacters){
        Scanner in = new Scanner(System.in);
        int keepAdding = 1;

        while(keepAdding == 1) {
            System.out.println("Introduce warrior or wizard");
            String characterType = in.nextLine();
            System.out.println("Now introduce the name of your " + characterType);
            String characterName = in.nextLine();
            Character character = _characterFactory.create(CharacterType.valueOf(characterType), characterName);
            _userCharacters.add(character);
            System.out.println("You want to keep introducing characters? Press 0 to finish or 1 to continue");
            keepAdding = in.nextInt();
            in.nextLine();
        }
        _userParty = new Party("blue", _userCharacters);
        return _userParty;
    };

    public Party enemyPartyCreation(List _enemyCharacters){
        Scanner in = new Scanner(System.in);
        int keepAdding = 1;

        while(keepAdding == 1) {
            System.out.println("Introduce warrior or wizard");
            String characterType = in.nextLine();
            System.out.println("Now introduce the name of your " + characterType);
            String characterName = in.nextLine();
            Character character = _characterFactory.create(CharacterType.valueOf(characterType), characterName);
            _enemyCharacters.add(character);
            System.out.println("You want to keep introducing characters? Press 0 to finish or 1 to continue");
            keepAdding = in.nextInt();
            in.nextLine();
        }
        _enemyParty = new Party("Red", _enemyCharacters);
        return _enemyParty;
    };


/*    public Party enemyPartyCreation(List _enemyCharacters){
        Scanner in = new Scanner(System.in);
        int keepAdding = 1;

        while(keepAdding == 1) {
            System.out.println("Introduce warrior or wizard");
            String characterType = in.nextLine();
            System.out.println("Now introduce the name of your " + characterType);
            String characterName = in.nextLine();
            Character character = _characterFactory.create(CharacterType.valueOf(characterType), characterName);
            _enemyCharacters.add(character);
            System.out.println("You want to keep introducing characters? Press 0 to finish or 1 to continue");
            keepAdding = in.nextInt();
            in.nextLine();
        }
        _enemyParty = new Party("blue", _enemyCharacters);
        return _enemyParty;
    };
*/
    /**
     * Creates a random party to fight against user
     * @param length
     * @return Party
     */
  /*  public Party createRandomParty(int length){
        List<Character> randomPartyList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Character character = _characterFactory.createRandom();
            randomPartyList.add(character);
        }
        Party randomParty = new Party("red",randomPartyList);
        return randomParty;
    }

   */
}
