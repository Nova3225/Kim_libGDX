package com.Roguelike.Kim.Game.Filter;

import com.Roguelike.Kim.Game.FightData;

public class TestDoubleDamageFilter extends Filter<FightData>{


    @Override
    public void doFilter(FightData data) {
        data.finalDamage *= 2;
    }
}
