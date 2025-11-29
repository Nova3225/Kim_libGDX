package com.Roguelike.Kim.Display.Panel;

import com.Roguelike.Kim.Display.Animation.Overlay;
import com.Roguelike.Kim.Display.Factory.ImageButtonFactory;
import com.Roguelike.Kim.Display.Layers.Layer;
import com.Roguelike.Kim.Display.Logic.SwimmingFish;
import com.Roguelike.Kim.Display.SoundManager;
import com.Roguelike.Kim.GameManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StartMenuPanel extends Panel {


    ImageButton ButtonLoad;

    Texture fishTexture;

    List<Sprite> fishes;
    List<SwimmingFish> swimmingFishes;
    Random random;
    float timer = 0;

    public StartMenuPanel(Game game, GameManager gameManager){
        super(game, gameManager);

        init();
        arrangement();
    }

    protected void init(){
        //初始化变量


        fishTexture = new Texture("FloatObj/float1.png");
        random = new Random();
        fishes = new ArrayList<>();
        swimmingFishes = new ArrayList<>();


    }

    @Override
    protected void arrangement() {
        //对层进行设置
        backgroundLayer.setBackground("Background/Start.png");

        ButtonLoad = ImageButtonFactory.createWoodImageButton(WIDTH / 3, HEIGHT / 2, WIDTH / 3, HEIGHT / 7);
        ButtonLoad.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SoundManager.playClickSound();
                Overlay.fadeOutAnimation(0.5f, () -> {
                    game.setScreen(new TowerPanel(game, gameManager));
                }, uiLayer.stage);
            }
        });
        uiLayer.addComponent(ButtonLoad);
        uiLayer.addComponent(ImageButtonFactory.createLabelOnButton(ButtonLoad, "Start Game!"));

        ButtonLoad = ImageButtonFactory.createWoodImageButton(WIDTH / 3, HEIGHT / 4, WIDTH / 3, HEIGHT / 7);
        ButtonLoad.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SoundManager.playClickSound();
                Overlay.fadeOutAnimation(0.5f, () -> {
                    Gdx.app.exit();
                }, uiLayer.stage);
            }
        });
        uiLayer.addComponent(ButtonLoad);
        uiLayer.addComponent(ImageButtonFactory.createLabelOnButton(ButtonLoad, "Quit"));
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
