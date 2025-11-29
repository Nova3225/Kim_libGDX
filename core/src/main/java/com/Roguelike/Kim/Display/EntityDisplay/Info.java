package com.Roguelike.Kim.Display.EntityDisplay;

import com.Roguelike.Kim.Game.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;


public class Info {

    int health;
    int attack;
    int maxHealth;

    Group group;

    public Info(Entity entity){
        health = entity.getHealth();
        maxHealth = entity.getMaxHealth();
        attack = entity.getAttack();
    }

    public Label showInfoWithLabel(int side){//1 for left; 2 for right.

        float width = Gdx.graphics.getWidth() / 8f * 3;
        float height = Gdx.graphics.getHeight() / 2f;
        float x;
        float y = Gdx.graphics.getHeight() / 4f;

        x = switch (side) {
            case 1 -> Gdx.graphics.getWidth() / 16f;
            case 2 -> Gdx.graphics.getWidth() / 2f + Gdx.graphics.getWidth() / 16f;
            default -> Gdx.graphics.getWidth() / 16f;
        };

        Label.LabelStyle style = new Label.LabelStyle();
        style.font = new BitmapFont();
        style.font.getData().setScale(5f);
        style.font.getRegion().getTexture().setFilter(
            Texture.TextureFilter.Nearest, // 放大时使用最近邻
            Texture.TextureFilter.Nearest  // 缩小时使用最近邻
        );
        style.fontColor = Color.BROWN;

        String text = "Health:" + health + "/" + maxHealth + "\n" +
            "Attack:" + attack;
        Label label = new Label(text, style);
        label.setAlignment(1);
        label.setSize(width, height);
        label.setPosition(x, y);

        label.setTouchable(null);
        return label;
    }

}
