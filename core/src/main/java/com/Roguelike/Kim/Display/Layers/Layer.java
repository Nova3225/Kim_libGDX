package com.Roguelike.Kim.Display.Layers;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public interface Layer {
    void draw(float v);
    void addComponent(Actor actor);
    void addComponent(Sprite sprite);


    void update(int i, int i1, boolean b);

    void dispose();
}
