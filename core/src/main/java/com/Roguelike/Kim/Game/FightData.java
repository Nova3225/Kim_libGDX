package com.Roguelike.Kim.Game;

public class FightData {

    public Player player;
    public Monster monster;

    public int range;

    public int originDamage;
    public int finalDamage;

    public FightData(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
        this.range = 1;
        originDamage = player.attack;
        finalDamage = originDamage;
    }



}
