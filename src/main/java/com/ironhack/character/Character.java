package com.ironhack.character;

import java.util.UUID;

public abstract class Character implements Attacker{
    final private UUID id;
    private String name;
    private Integer hp;
    private boolean isAlive;

    public Character(String name) {
        setName(name);
        setIsAlive(true);
        this.id = UUID.randomUUID();

    }
    //getters
    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public Integer getHp() {
        return hp;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public abstract void setHpRandom();

    public void setHp(int hp){
        this.hp = hp;
    }

    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name +
                '}';
    }

    //public abstract void highAttack(Character enemy);

    //public abstract void lowAttack(Character enemy);

}