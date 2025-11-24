package com.Roguelike.Kim.Game;

public class Player extends Entity{

    public XpSystem xpSystem;

    public Player(String name) {
        super(name);
        xpSystem = new XpSystem();
    }

}
