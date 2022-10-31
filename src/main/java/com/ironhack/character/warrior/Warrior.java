package com.ironhack.character.warrior;
import com.ironhack.character.Character;
import com.ironhack.character.Stats;

import java.util.Random;

public class Warrior extends Character {
    private Integer stamina;
    private Integer strength;

    public Warrior(String name) {
        super(name);
        setHpRandom();
        setStaminaRandom();
        setStrengthRandom();
    }

    //getters
    public Integer getStamina() {
        return stamina;
    }

    public Integer getStrength() {
        return strength;
    }

    //setters
    public void setHpRandom(){
        Stats stats = new Stats(100, 200);
        setHp(stats.getValue());
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    public void setStaminaRandom(){
        Stats stats = new Stats(10, 50);
        setStamina(stats.getValue());
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }
    public void setStrengthRandom(){
        Stats stats = new Stats(1,10);
        setStrength(stats.getValue());
    }
    @Override
    public void highAttack(Character enemy) {
        if (getStamina() >= 5){
            System.out.println("Heavy attack");
            Integer damage = getStrength();
            Integer newStamina = getStamina() - 5;
            setStamina(newStamina);
            enemy.setHp(enemy.getHp() - damage);
            System.out.println("damage: "+damage);
        }else {
            int damage = lowAttack(enemy);
            System.out.println("damage: "+damage);
        }
    }

    @Override
    public int lowAttack(Character enemy) {
        System.out.println("Not enough stamina");
        System.out.println("Weak attack");
        Integer damage = getStrength() / 2;       //modify
        Integer newStamina = getStamina() + 1;
        setStamina(newStamina);
        enemy.setHp(enemy.getHp() - damage);
        return damage;
    }

}
