package com.Roguelike.Kim.Game.Filter;

import com.Roguelike.Kim.Game.FightData;

public class FinalFilter extends Filter<FightData>{
    @Override
    public void doFilter(FightData data) {
        data.monster.setHealth(data.monster.getHealth() - data.finalDamage);
    }
}
