package com.Roguelike.Kim.Game;

import com.badlogic.gdx.math.MathUtils;

public abstract class Entity {

    private String name;

    private int health; // 数值范围：0 ~ maxHealth
    private int maxHealth;
    private int attack;

    public Entity(String name){
        this.name = name;
        maxHealth = 1000;
        health = maxHealth;
        attack = 100;
    }

    public void recoverHealth(int amount){
        setHealth(getHealth() + amount);
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int finalHealth){
        health = MathUtils.clamp(finalHealth, 0, maxHealth);
    }

    public int getMaxHealth(){
        return maxHealth;
    }

    public void setMaxHealth(int finalMaxHealth){
        maxHealth = MathUtils.clamp(finalMaxHealth, 0, 9999999);
    }

}
