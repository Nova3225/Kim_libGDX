package com.Roguelike.Kim.Display;

import com.Roguelike.Kim.Display.Animation.Overlay;
import com.Roguelike.Kim.Display.Factory.ImageButtonFactory;
import com.Roguelike.Kim.Display.Layers.Layer;
import com.Roguelike.Kim.Display.Logic.SwimmingFish;
import com.Roguelike.Kim.SoundManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StartMenuPanel extends Panel {

    ImageButtonStyle style;
    Texture buttonTextureDown;
    Texture buttonTextureUp;
    ImageButton StartButton;

    Texture fishTexture;

    List<Sprite> fishes;
    List<SwimmingFish> swimmingFishes;
    Random random;
    float timer = 0;

    public StartMenuPanel(Game game){
        super(game);

        init();
        arrangement();
    }

    protected void init(){
        //初始化变量
        style = new ImageButtonStyle();
        buttonTextureDown = new Texture("Button/button_brown_close.png");
        buttonTextureUp = new Texture("Button/button_brown.png");

        fishTexture = new Texture("FloatObj/float1.png");
        random = new Random();
        fishes = new ArrayList<>();
        swimmingFishes = new ArrayList<>();
    }

    @Override
    protected void arrangement() {
        //对层进行设置
        backgroundLayer.setBackground("Background/Start.png");

        StartButton = ImageButtonFactory.createImageButton(
            buttonTextureUp,
            buttonTextureDown,
            buttonTextureDown,
            WIDTH / 3, HEIGHT / 2,
            WIDTH / 3, HEIGHT / 7
            );
        StartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SoundManager.playClickSound();
                Overlay.fadeOutAnimation(0.5f, () -> {
                    game.setScreen(new TowerPanel(game));

                }, uiLayer.stage);
            }
        });
        uiLayer.addComponent(StartButton);
        uiLayer.addComponent(ImageButtonFactory.createLabelOnButton(StartButton, "Start Game!"));




    }

    protected void spriteArrangement(){
        for (int i = 0; i < 8; i++) {
            Sprite fish = new Sprite(fishTexture);
            fish.setSize(0.2f, 0.2f);
            fish.setPosition(- fish.getWidth(), - fish.getHeight());
            fish.setOriginCenter();
            mainSpriteLayer.addComponent(fish);
            fishes.add(fish);
            SwimmingFish swimmingFish = new SwimmingFish();
            swimmingFishes.add(swimmingFish);
        }
    }

    @Override
    public void show() {
        super.show();
        spriteArrangement();
    }


    @Override
    protected void input() {

    }

    protected void logic() {
        timer += Gdx.graphics.getDeltaTime();
        for (int i = 0; i < fishes.size(); i++){
            swimmingFishes.get(i).acrossAnimation(fishes.get(i), mainSpriteLayer.spriteViewport, 2, 8, 0, i);
        }
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
        for (Layer layer : layers){
            layer.dispose();
        }
    }
}
