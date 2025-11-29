package com.Roguelike.Kim.Game;

import com.badlogic.gdx.math.MathUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class RuneSystem {

    Logger logger;

    int runeSlot;
    final int maxRuneSlots;
    Map<String, Rune> runeBag;
    Map<String, Rune> currentRune;


    public RuneSystem() {
        //init
        runeSlot = 2;
        maxRuneSlots = 9;
        runeBag = new HashMap<>();

    }

    //
    public int getRuneSlot() {
        return runeSlot;
    }

    public void setRuneSlot(int runeSlot) {
        this.runeSlot = MathUtils.clamp(runeSlot, 0, maxRuneSlots);
    }

    //
    public int getMaxRuneSlots() {
        return maxRuneSlots;
    }

    public int getRuneCount() {
        return runeBag.size();
    }

    //
    public void addRuneInBag(String name, Rune rune) {
        if (runeBag.size() == 30) {
            logger.info("符石包已有大于30个非空符石！");
            return;
        }
        runeBag.put(name, rune);
    }

    public void removeRuneInBag(String name) {
        if (runeBag.isEmpty()) {
            logger.info("符石包已空！无法删除符石");
            return;
        }
        if (runeBag.get(name) == null) {
            logger.info("包里没有你要删除的符石");
        }
        runeBag.remove(name);
    }

    public Map<String, Rune> getRuneBag() {
        return runeBag;
    }

    //
    public void addRuneInSlot(String name, Rune rune) {
        if (currentRune.size() == runeSlot) {
            logger.info("符石槽已满");
        }
        currentRune.put(name, rune);
    }

    public void removeRuneSlot(String name) {
        if (currentRune.isEmpty()) {
            logger.info("符石槽位已空！无法删除符石");
            return;
        }
        if (currentRune.get(name) == null) {
            logger.info("槽位里没有你要删除的符石");
        }
        currentRune.remove(name);
    }

    //
    public Map<String, Rune> getRuneInSlots() {
        return currentRune;
    }

    //
    public Rune getRuneInBag(String name) {
        return runeBag.get(name);
    }

}
