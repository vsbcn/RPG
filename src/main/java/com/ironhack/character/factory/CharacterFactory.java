package com.ironhack.character.factory;

import com.github.javafaker.Faker;
import com.ironhack.character.Character;
import com.ironhack.character.warrior.Warrior;
import com.ironhack.character.wizard.Wizard;
import com.ironhack.party.Party;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.ironhack.character.factory.CharacterType.values;

public class CharacterFactory {
    private Random random = new Random();
    /**
     * Method to create Characters - Warrior or Wizard
     * @param type if it is warrior or wizard
     * @param name of the character
     * @return Character
     */
    public Character create(CharacterType type, String name){
        switch(type){
            case warrior:
                return new Warrior(name);
            case wizard:
                return new Wizard(name);
            default:
                return null;
        }
    }
/*
    public Character createRandom(){
        String name = generateRandomName();
        CharacterType type = values()[random.nextInt(values().length)];
        return create(type,name);
    }

    public Party createRandomParty(int length){
        List<Character> randomPartyList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Character character = createRandom();
            randomPartyList.add(character);
        }
        Party randomParty = new Party(randomPartyList);
        return randomParty;
    }

    private String generateRandomName(){
        Faker faker = new Faker(new Locale("es"));
        return faker.superhero().name();
    }


 */
}
