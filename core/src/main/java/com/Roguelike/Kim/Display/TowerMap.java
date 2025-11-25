package com.Roguelike.Kim.Display;

import com.Roguelike.Kim.Display.Layers.Layer;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

public class TowerMap extends Panel{

    TiledGameMap tiledGameMap;

    public TowerMap(Game game){
        super(game);

        init();
        Arrangement();
    }

    protected void init() {
        tiledGameMap = new TiledGameMap("Map/test.tmx");
    }

    protected void Arrangement() {

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(uiLayer.stage);
    }

    @Override
    public void render(float v) {
        input();
        logic();
        draw(v);
    }

    @Override
    protected void input() {

    }

    @Override
    protected void logic() {
    }

    @Override
    protected void draw(float v) {
        ScreenUtils.clear(Color.BLACK);

        tiledGameMap.update(v, tiledGameMap.getMapWidth()/2, tiledGameMap.getMapHeight()/2);
        tiledGameMap.render();
        for (Layer layer : layers){
            layer.draw(v);
        }
    }

    @Override
    public void resize(int i, int i1) {
        backgroundLayer.update(i, i1, true);
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
        tiledGameMap.dispose();
    }

}
