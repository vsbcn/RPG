package com.ironhack.graveyard;

import com.ironhack.character.Character;

import java.util.ArrayList;

public class Graveyard {
    static private ArrayList<Character> blueCorpsesArray = new ArrayList<>();
    static private ArrayList<Character> redCorpsesArray = new ArrayList<>();

    public ArrayList<Character> getBlueCorpsesArray() {
        return blueCorpsesArray;
    }

    public ArrayList<Character> getRedCorpsesArray() {
        return redCorpsesArray;
    }

    public void setBlueCorpse(Character blueCorpse) {
        blueCorpsesArray.add(blueCorpse);
    }

    public void setRedCorpse(Character redCorpse) {
        redCorpsesArray.add(redCorpse);
    }
}
