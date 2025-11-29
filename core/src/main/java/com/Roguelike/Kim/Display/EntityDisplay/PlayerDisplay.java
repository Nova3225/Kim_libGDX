package com.Roguelike.Kim.Display.EntityDisplay;

import com.Roguelike.Kim.Game.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerDisplay extends Sprite {

    float speed;

    public PlayerDisplay(Texture texture, float x, float y, float width, float height, float speed) {
        super(texture);
        setPosition(x, y);
        setSize(width, height);
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
