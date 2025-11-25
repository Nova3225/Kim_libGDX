package com.Roguelike.Kim.Display.Input;

import com.Roguelike.Kim.Main;
import com.Roguelike.Kim.SoundManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Movement {

    float verticalSpeed;
    float gravity = 30f;

    public Movement(){
        verticalSpeed = 0;
    }

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

    public void moveWithWASDGravity(Sprite player, float horizentalSpeed, float deltaTime){
        verticalSpeed -= deltaTime * gravity;
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            verticalSpeed = 10f;
            SoundManager.playSound("Sound/Crash.mp3");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {

        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.translateX(-horizentalSpeed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.translateX(horizentalSpeed * deltaTime);
        }
        player.translateY(verticalSpeed * deltaTime);
    }

    public void limitedInScreen(Sprite player){
        if (player.getY() < 0) {
            player.setY(0);
            verticalSpeed = 0;
        }
        if (player.getX() < 0) {
            player.setX(0);
        }
        if (player.getX() > Main.WIDTHTILES - player.getWidth()){
            player.setX(Main.WIDTHTILES - player.getWidth());
        }
        if (player.getY() > Main.HEIGHTTILES - player.getHeight()){
            player.setY(Main.HEIGHTTILES - player.getHeight());
            verticalSpeed = 0;
        }
    }

}
