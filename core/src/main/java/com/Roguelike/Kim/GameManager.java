package com.Roguelike.Kim;

import com.Roguelike.Kim.Game.FightData;
import com.Roguelike.Kim.Game.Filter.DamageManager;
import com.Roguelike.Kim.Game.Monster;
import com.Roguelike.Kim.Game.Player;

public class GameManager {

    public Player player;
    public Monster monster;

    public FightData fightData;

    public GameManager(){
        player = new Player("Kim", 1000, 1000, 10);
    }

    public void fight(){
        monster = new Monster("Slime", 500, 500, 10);
        fightData = new FightData(player, monster);
    }

    public int playerAttack(){
        DamageManager damageManager = new DamageManager();
        int damage = damageManager.getDamage(fightData);
        fightData = new FightData(player, monster);
        return damage;
    }

}
