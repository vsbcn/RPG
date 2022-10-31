package com.ironhack.character;

import com.ironhack.character.Character;

public interface Attacker {
    void highAttack(Character enemy);
    int lowAttack(Character enemy);
}
