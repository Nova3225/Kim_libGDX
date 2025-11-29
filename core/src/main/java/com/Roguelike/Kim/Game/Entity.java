package com.Roguelike.Kim.Game;

public class Entity{

    String name;
    int health;
    int maxHealth;
    int attack;

    public Entity(){

    }

    public Entity(String name, int health, int maxHealth, int attack){
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }


}
