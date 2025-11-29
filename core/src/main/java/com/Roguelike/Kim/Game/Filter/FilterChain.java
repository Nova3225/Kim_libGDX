package com.Roguelike.Kim.Game.Filter;

import java.util.ArrayList;
import java.util.List;

public abstract class FilterChain<T> {

    List<Filter> filterList = new ArrayList<>();

    public FilterChain addFilter(Filter filter){
        this.filterList.add(filter);
        return this;
    }

    public abstract T doFilter(T data);

}
