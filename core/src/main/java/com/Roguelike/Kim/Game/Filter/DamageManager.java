package com.Roguelike.Kim.Game.Filter;

import com.Roguelike.Kim.Game.FightData;

public class DamageManager {

    DamageFilterChain damageFilterChain;

    public DamageManager(){
        damageFilterChain = new DamageFilterChain();
        damageFilterChain.addFilter(new TestDoubleDamageFilter());
    }

    public int getDamage(FightData data){
        return damageFilterChain.doFilter(data).finalDamage;
    }

}
