package com.Roguelike.Kim.Display;

import com.Roguelike.Kim.Display.Layers.BackgroundLayer;
import com.Roguelike.Kim.Display.Layers.Layer;
import com.Roguelike.Kim.Display.Layers.MainSpriteLayer;
import com.Roguelike.Kim.Display.Layers.UiLayer;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public abstract class Panel implements Screen {

    protected final Game game;
    protected SpriteBatch batch;
    protected BackgroundLayer backgroundLayer;
    protected MainSpriteLayer mainSpriteLayer;
    protected UiLayer uiLayer;
    protected ArrayList<Layer> layers;
    public final float WIDTH;
    public final float HEIGHT;

    public Panel(Game game){
        //导入游戏数据
        this.game = game;
        //常量
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        //批次
        batch = new SpriteBatch();
        //初始化层
        backgroundLayer = new BackgroundLayer(batch, WIDTH, HEIGHT);
        mainSpriteLayer = new MainSpriteLayer(batch, WIDTH, HEIGHT);
        uiLayer = new UiLayer(batch, WIDTH, HEIGHT);
        layers = new ArrayList<>();
        layers.add(backgroundLayer);
        layers.add(mainSpriteLayer);
        layers.add(uiLayer);


        init();
        arrangement();
    }

    protected abstract void init();

    protected abstract void arrangement();

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

    protected void input() {

    }

    protected void logic() {

    }

    protected void draw(float v) {
        ScreenUtils.clear(Color.BLACK);
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
        batch.dispose();
        for (Layer layer : layers) {
            layer.dispose();
        }
    }

}
