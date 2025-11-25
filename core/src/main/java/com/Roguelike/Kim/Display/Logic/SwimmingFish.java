package com.Roguelike.Kim.Display.Logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

public class SwimmingFish {

    Random random = new Random();
    float timer = 0;

    int a = -1;
    float xVariation;
    float yVariation;
    float sinVariation;
    boolean started = false;

    public void acrossAnimation(Sprite fish, Viewport viewport, float sinSpeed, float moveSpeed, float sinAmount, int num){
        timer += Gdx.graphics.getDeltaTime();
        if (!started){
            if (timer < num / 4.0f){
                return;
            }else{
                sinVariation = random.nextFloat(0,3.14f);
                started = true;
            }
        }
        if (a == -1){
            a = random.nextInt(0, 4);
            if (a == 0){
                xVariation = random.nextFloat(1, 16 - 1 - fish.getWidth());
            }else if (a == 1){
                yVariation = random.nextFloat(1, 10 - 1 - fish.getHeight());
            }else if (a == 2){
                xVariation = random.nextFloat(1, 16 - 1 - fish.getWidth());
            }else if (a == 3){
                yVariation = random.nextFloat(1, 10 - 1 - fish.getHeight());
            }
        }
        if (a == 0){ // X
            fish.setX((float)Math.sin(sinSpeed * timer + sinVariation) + xVariation);
            fish.translateY(Gdx.graphics.getDeltaTime() * moveSpeed);
        }else if (a == 1){
            fish.setY((float)Math.sin(sinSpeed * timer + sinVariation) + yVariation);
            fish.translateX(Gdx.graphics.getDeltaTime() * moveSpeed);
        } else if (a == 2){
            fish.setX((float)Math.sin(sinSpeed * timer + sinVariation) + xVariation);
            fish.translateY(- Gdx.graphics.getDeltaTime() * moveSpeed);
        } else if (a == 3){
            fish.setY((float)Math.sin(sinSpeed * timer + sinVariation) + yVariation);
            fish.translateX(- Gdx.graphics.getDeltaTime() * moveSpeed);
        }
        if (fish.getX() > 16){
            fish.setX(- fish.getWidth());
            fish.setY(- fish.getHeight());
            a = -1;
        }
        if (fish.getY() > 10){
            fish.setX(- fish.getWidth());
            fish.setY(- fish.getHeight());
            a = -1;
        }
        if (fish.getX() < - fish.getWidth()){
            fish.setX(16);
            fish.setY(10);
            a = -1;
        }
        if (fish.getY() < - fish.getHeight()){
            fish.setX(16);
            fish.setY(10);
            a = -1;
        }
    }
}
