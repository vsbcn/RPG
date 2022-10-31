package com.ironhack.party;

import com.ironhack.character.Character;

import java.util.ArrayList;
import java.util.List;

public class Party {


    static private String nameColor; //team blue or red
    static private int size;
    private List<Character> partyList = new ArrayList<>();


    public Party(String name,List<Character> partyList) {
        setName(name);
        setPartyList(partyList);
        this.size = partyList.size();
    }

    public Party(List<Character> partyList){
        setPartyList(partyList);
    }

    public Party(){
    }

    public List<Character> getPartyList() {
        return partyList;
    }

    public void setPartyList(List<Character> partyList) {
        this.partyList = partyList;
    }

    public void setPartyMember(Character member) {
        partyList.add(member);
    }

    public Character getPartyMember(Character member){
        return member;
    }

    public String getName() {
        return nameColor;
    }

    public void setName(String name) {
        this.nameColor = name;
    }

    @Override
    public String toString() {
        return "Party{" +
                "party=" + partyList +
                '}';
    }

    public int getSize() {
        return this.size;
    }
}
