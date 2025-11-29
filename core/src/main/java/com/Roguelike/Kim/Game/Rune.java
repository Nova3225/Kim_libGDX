package com.Roguelike.Kim.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rune{

    String name;
    int attack;
    Map<String, Skill> skillList;

    public Rune(String name, int attack){
        this.name = name;
        this.attack = attack;
        skillList = new HashMap<>();
    }

    public void setAttribute(String names){
        Skill skill = new Skill(names);
        skillList.put(names, skill);
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

}
