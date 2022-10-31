package com.ironhack.character;

import java.util.Random;

public class Stats {
    private int min;
    private int max;
    private int value;

    public Stats(int min, int max) {
        setMin(min);
        setMax(max);
        this.value = randomize(max,min);

    }

    public int randomize(int min, int max){
        Random random = new Random();
        int randomNumber = (int)Math.floor(Math.random()*(max-min+1)+min);
        return randomNumber;
    }

    public void setMax(int max){
        this.max=max;
    }
    public void setMin(int min){
        this.min=min;
    }
    public int getValue(){
        return value;
    }
}
