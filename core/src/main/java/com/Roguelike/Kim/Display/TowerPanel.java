package com.Roguelike.Kim.Display;

import com.Roguelike.Kim.Display.Animation.Overlay;
import com.Roguelike.Kim.Display.Layers.Layer;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class TowerPanel extends Panel{

    ImageButton buttonLoad;
    Texture buttonTexture;
    Texture buttonTextureDown;

    public TowerPanel(Game game){
        super(game);

        init();
        Arrangement();
    }

    protected void init() {
        backgroundLayer.setBackground("Background/Start.png");
        buttonTexture = new Texture("Button/button_brown.png");
        buttonTextureDown = new Texture("Button/button_brown_close.png");
    }

    protected void Arrangement() {
        buttonLoad = ImageButtonFactory.createImageButton(
            buttonTexture,
            buttonTextureDown,
            buttonTextureDown,
            0, HEIGHT / 2,
            WIDTH / 3, HEIGHT / 7
        );
        uiLayer.addComponent(buttonLoad);
        Label label = ImageButtonFactory.createLabelOnButton(buttonLoad, "Fight");
        uiLayer.addComponent(label);

        buttonLoad = ImageButtonFactory.createImageButton(
            buttonTexture,
            buttonTextureDown,
            buttonTextureDown,
            WIDTH / 3, HEIGHT / 2,
            WIDTH / 3, HEIGHT / 7
        );
        buttonLoad.addListener(new ClickListener()  {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Overlay.fadeOutAnimation(0.5f, () -> {
                    MainInfoPanel mainInfoPanel = new MainInfoPanel(game);
                    game.setScreen(mainInfoPanel);
                    Overlay.fadeInAnimation(0.5f, () -> {}, mainInfoPanel.uiLayer.stage);
                    dispose();
                }, uiLayer.stage);
            }
        });
        uiLayer.addComponent(buttonLoad);
        label = ImageButtonFactory.createLabelOnButton(buttonLoad, "Info");
        uiLayer.addComponent(label);

        buttonLoad = ImageButtonFactory.createImageButton(
            buttonTexture,
            buttonTextureDown,
            buttonTextureDown,
            WIDTH / 3 * 2, HEIGHT / 2,
            WIDTH / 3, HEIGHT / 7
        );
        buttonLoad.addListener(new ClickListener()  {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Overlay.fadeOutAnimation(0.5f, () -> {
                    StartMenuPanel startMenuPanel = new StartMenuPanel(game);
                    game.setScreen(startMenuPanel);
                    Overlay.fadeInAnimation(0.5f, () -> {}, startMenuPanel.uiLayer.stage);
                    dispose();
//                    dispose();
//                    Gdx.app.exit();
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
