package com.Roguelike.Kim.Display;

import com.Roguelike.Kim.Display.Layers.BackgroundLayer;
import com.Roguelike.Kim.Display.Layers.Layer;
import com.Roguelike.Kim.Display.Layers.MainSpriteLayer;
import com.Roguelike.Kim.Display.Layers.UiLayer;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class StartMenu implements Screen {
    final Game game;
    private SpriteBatch batch;
    private BackgroundLayer backgroundLayer;
    private MainSpriteLayer mainSpriteLayer;
    private UiLayer uiLayer;
    private ArrayList<Layer> layers;
    ImageButtonStyle style;
    Texture buttonTextureDown;
    Texture buttonTextureUp;
    ImageButton StartButton;

    public final int WIDTH;
    public final int HEIGHT;

    public StartMenu(Game game){
        //导入游戏数据
        this.game = game;
        //常量
        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();
        //批次
        batch = new SpriteBatch();
        //初始化变量
        style = new ImageButtonStyle();
        buttonTextureDown = new Texture("Button/button_brown_close.png");
        buttonTextureUp = new Texture("Button/button_brown.png");
        //初始化层
        backgroundLayer = new BackgroundLayer(batch, WIDTH, HEIGHT);
        mainSpriteLayer = new MainSpriteLayer(batch, WIDTH, HEIGHT, 16f, 10f);
        uiLayer = new UiLayer(batch, WIDTH, HEIGHT);
        layers = new ArrayList<>();
        layers.add(backgroundLayer);
        layers.add(mainSpriteLayer);
        layers.add(uiLayer);
        //开始菜单排列
        StartMenuArrangement();
    }

    private void StartMenuArrangement() {
        //对层进行设置
        backgroundLayer.setBackground("Background/Start.png");
        style.imageUp = new TextureRegionDrawable(new Texture("Button/button_brown.png"));
        style.imageUp.setMinSize(WIDTH / 5, HEIGHT / 10);
        style.imageDown = new TextureRegionDrawable(new Texture("Button/button_brown_close.png"));
        style.imageDown.setMinSize(WIDTH / 5, HEIGHT / 10);
        StartButton = new ImageButton(style);
        StartButton.setSize(WIDTH / 5, HEIGHT / 10);
        StartButton.setPosition(WIDTH / 2 - StartButton.getWidth() / 2, HEIGHT / 2 - StartButton.getHeight() / 2);
        StartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Simple(game));
            }
        });
        uiLayer.addComponent(StartButton);
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

    private void input() {

    }

    private void logic() {

    }

    private void draw(float v) {
        ScreenUtils.clear(Color.BLACK);
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
        for (Layer layer : layers){
            layer.dispose();
        }
    }
}
