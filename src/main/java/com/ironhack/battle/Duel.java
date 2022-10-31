package com.ironhack.battle;

import com.ironhack.character.Character;

public class Duel {
    private int id;
    private Character blueFighter;
    private Character redFighter;

    public Duel(int id){

        setId(id);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Character getBlueFighter() {
        return blueFighter;
    }

    public void setBlueFighter(Character blueFighter) {
        this.blueFighter = blueFighter;
    }

    public Character getRedFighter() {
        return redFighter;
    }

    public void setRedFighter(Character redFighter) {
        this.redFighter = redFighter;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
