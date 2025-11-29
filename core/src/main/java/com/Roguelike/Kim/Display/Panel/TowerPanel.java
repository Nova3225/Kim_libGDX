package com.Roguelike.Kim.Display.Panel;

import com.Roguelike.Kim.Display.Animation.Overlay;
import com.Roguelike.Kim.Display.Factory.ImageButtonFactory;
import com.Roguelike.Kim.Display.Layers.Layer;
import com.Roguelike.Kim.Display.SoundManager;
import com.Roguelike.Kim.GameManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class TowerPanel extends Panel{

    ImageButton buttonLoad;

    public TowerPanel(Game game, GameManager gameManager){
        super(game, gameManager);

        init();
        arrangement();
    }

    protected void init() {
        backgroundLayer.setBackground("Background/Start.png");
    }

    protected void arrangement() {
        buttonLoad = ImageButtonFactory.createWoodImageButton(0, HEIGHT / 2, WIDTH / 3, HEIGHT / 7);
        buttonLoad.addListener(new ClickListener()  {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SoundManager.playClickSound();
                Overlay.fadeOutAnimation(0.5f, () -> {
                    TowerMap towerMap = new TowerMap(game, gameManager);
                    game.setScreen(towerMap);
                    Overlay.fadeInAnimation(0.5f, () -> {}, towerMap.uiLayer.stage);
                    dispose();
                }, uiLayer.stage);
            }
        });
        uiLayer.addComponent(buttonLoad);
        Label label = ImageButtonFactory.createLabelOnButton(buttonLoad, "Fight");
        uiLayer.addComponent(label);

        buttonLoad = ImageButtonFactory.createWoodImageButton(WIDTH / 3, HEIGHT / 2, WIDTH / 3, HEIGHT / 7);
        buttonLoad.addListener(new ClickListener()  {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SoundManager.playClickSound();
                Overlay.fadeOutAnimation(0.5f, () -> {
                    MainInfoPanel mainInfoPanel = new MainInfoPanel(game, gameManager);
                    game.setScreen(mainInfoPanel);
                    Overlay.fadeInAnimation(0.5f, () -> {}, mainInfoPanel.uiLayer.stage);
                    dispose();
                }, uiLayer.stage);
            }
        });
        uiLayer.addComponent(buttonLoad);
        label = ImageButtonFactory.createLabelOnButton(buttonLoad, "Info");
        uiLayer.addComponent(label);

        buttonLoad = ImageButtonFactory.createWoodImageButton(WIDTH / 3 * 2, HEIGHT / 2, WIDTH / 3, HEIGHT / 7);
        buttonLoad.addListener(new ClickListener()  {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SoundManager.playClickSound();
                Overlay.fadeOutAnimation(0.5f, () -> {
                    StartMenuPanel startMenuPanel = new StartMenuPanel(game, gameManager);
                    game.setScreen(startMenuPanel);
                    Overlay.fadeInAnimation(0.5f, () -> {}, startMenuPanel.uiLayer.stage);
                    dispose();
                }, uiLayer.stage);
            }
        });
        uiLayer.addComponent(buttonLoad);
        label = ImageButtonFactory.createLabelOnButton(buttonLoad, "Quit");
        uiLayer.addComponent(label);
    }

    @Override
    public void show() {
        Overlay.fadeInAnimation(0.5f, () -> {}, uiLayer.stage);
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
    }

}
