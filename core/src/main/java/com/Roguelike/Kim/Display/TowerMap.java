package com.Roguelike.Kim.Display;

import com.Roguelike.Kim.Display.EntityDisplay.PlayerDisplay;
import com.Roguelike.Kim.Display.Input.Movement;
import com.Roguelike.Kim.Display.Layers.Layer;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;


public class TowerMap extends Panel{

    TiledGameMapManager tiledGameMapManager;

    PlayerDisplay playerDisplay;
    Texture playerTexture;
    Movement movement;


    public TowerMap(Game game){
        super(game);

        init();
        arrangement();
    }

    protected void init() {
        tiledGameMapManager = new TiledGameMapManager("Map/test.tmx");
        playerTexture = new Texture("player.png");

        movement = new Movement();
    }

    @Override
    protected void arrangement() {

    }

    protected void spriteArrangement(){
        playerDisplay = new PlayerDisplay(playerTexture,1,1 , 1, 1, 4);
        mainSpriteLayer.addComponent(playerDisplay);
    }

    @Override
    public void show() {
        super.show();
        spriteArrangement();
    }

    @Override
    public void render(float v) {
        input();
        logic();
        draw(v);
    }

    @Override
    protected void input() {
        movement.moveWithWASDGravity(playerDisplay, playerDisplay.getSpeed(), Gdx.graphics.getDeltaTime());
        movement.limitedInScreen(playerDisplay);
    }

    @Override
    protected void logic() {


    }

    @Override
    protected void draw(float v) {
        ScreenUtils.clear(Color.BLACK);

        tiledGameMapManager.update();
        tiledGameMapManager.render();

        for (Layer layer : layers){
            layer.draw(v);
        }
    }

    @Override
    public void resize(int i, int i1) {
        for (Layer layer : layers){
            layer.update(i, i1, true);
        }

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        super.dispose();
        tiledGameMapManager.dispose();
    }

}
