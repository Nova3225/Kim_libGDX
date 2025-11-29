package com.Roguelike.Kim.Game.Filter;

import com.Roguelike.Kim.Game.FightData;

public class DamageFilterChain extends FilterChain<FightData>{

    @Override
    public FightData doFilter(FightData data) {
        for (Filter filter : filterList){
            filter.doFilter(data);
        }
        return data;
    }
}
