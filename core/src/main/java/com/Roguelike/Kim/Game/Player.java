package com.Roguelike.Kim.Game;

/*
    攻击力由符石和自身决定
    共有三十个空符石
    每次行动可以使用符合符石槽的符石
 */
public class Player extends Entity{

    public RuneSystem runeSystem;
    public XpSystem xpSystem;

    public Player(){
        super();
        runeSystem = new RuneSystem();
        xpSystem = new XpSystem();
    }

    public Player(String name, int health, int maxHealth, int attack){
        super(name, health, maxHealth, attack);
        runeSystem = new RuneSystem();
        xpSystem = new XpSystem();
    }

}
