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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainInfoPanel extends Panel{

    ImageButton buttonLoad;

    public MainInfoPanel(Game game, GameManager gameManager){
        super(game, gameManager);

        init();
        arrangement();
    }

    protected void init() {
    }

    protected void arrangement() {
        backgroundLayer.setBackground("Background/Start.png");

        buttonLoad = ImageButtonFactory.createWoodImageButton(
            WIDTH /2 - WIDTH / 6, 0,
            WIDTH / 3, HEIGHT / 6
        );
        buttonLoad.addListener(new ClickListener()  {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                SoundManager.playClickSound();
                Overlay.fadeOutAnimation(0.5f, () -> {
                    TowerPanel towerPanel = new TowerPanel(game, gameManager);
                    game.setScreen(towerPanel);
                    Overlay.fadeInAnimation(0.5f, () -> {}, towerPanel.uiLayer.stage);
                    dispose();
                }, uiLayer.stage);

            }
        });
        uiLayer.addComponent(buttonLoad);
        uiLayer.addComponent(ImageButtonFactory.createLabelOnButton(buttonLoad, "Return"));
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
