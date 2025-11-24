package com.Roguelike.Kim.Display.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Movement {

    public void moveWithWASD(Sprite player, float speed, float deltaTime){
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.translateY(speed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.translateY(-speed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.translateX(-speed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.translateX(speed * deltaTime);
        }
    }

}
