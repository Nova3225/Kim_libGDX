package com.Roguelike.Kim.Display.Logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Display {

    public static void limitInScreen(Sprite sprite, Viewport viewport){
        float viewportWidth = viewport.getWorldWidth();
        float viewportHeight = viewport.getWorldHeight();

        if (sprite.getX() > viewportWidth) {
            sprite.setX(-sprite.getWidth());
        }
        if (sprite.getX() < -sprite.getWidth()) {
            sprite.setX(viewportWidth);
        }
        if (sprite.getY() > viewportHeight) {
            sprite.setY(-sprite.getHeight());
        }
        if (sprite.getY() < -sprite.getHeight()) {
            sprite.setY(viewportHeight);
        }
    }

}
