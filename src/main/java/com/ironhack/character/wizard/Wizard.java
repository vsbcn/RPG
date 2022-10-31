package com.ironhack.character.wizard;
import com.ironhack.character.Character;
import com.ironhack.character.Stats;

public class Wizard extends Character {
    private Integer mana;
    private Integer intelligence;

    public Wizard(String name) {
        super(name);
        setHpRandom();
        setManaRandom();
        setIntelligenceRandom();
    }

    //getters
    public Integer getMana() {
        return mana;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    //setters
    public void setHpRandom(){
        Stats stats = new Stats(50, 100);
        setHp(stats.getValue());
    }
    public void setMana(Integer mana) {
        this.mana = mana;
    }
    public void setManaRandom(){
        Stats stats = new Stats(10, 50);
        setMana(stats.getValue());
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }
    public void setIntelligenceRandom(){
        Stats stats = new Stats(1, 50);
        setIntelligence(stats.getValue());
    }

    @Override
    public void highAttack(Character enemy) {
        if (getMana() >= 5){
            System.out.println("Fireball");
            Integer damage = getIntelligence();
            Integer newMana = getMana() + 5;    //mana cost
            setMana(newMana);
            enemy.setHp(enemy.getHp() - damage);
            System.out.println("damage: "+damage);

        }else {
            int damage = lowAttack(enemy);
            System.out.println("damage: "+damage);
        }
    }

    @Override
    public int lowAttack(Character enemy) {
        System.out.println("Not enough mana");
        System.out.println("Staff hit");
        Integer damage = 2;
        Integer newMana = getMana() + 1;
        setMana(newMana);
        enemy.setHp(enemy.getHp() - damage);
        return damage;
    }

}