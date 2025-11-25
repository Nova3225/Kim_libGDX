package com.Roguelike.Kim.Display.Layers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class BackgroundLayer implements Layer{

    private Batch batch;

    private Viewport uiViewport;
    private Stage stage;

    final float WIDTH;
    final float HEIGHT;

    private Texture background;
    private Image backgroundImage;

    public BackgroundLayer(Batch batch, float WIDTH, float HEIGHT) {
        this.batch = batch;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        uiViewport = new FillViewport(WIDTH, HEIGHT);
        this.stage = new Stage(uiViewport);
    }


    public void setBackground(String src){
        background = new Texture(src);
        backgroundImage = new Image(background);
        backgroundImage.setPosition(0, 0);
        backgroundImage.setSize(WIDTH, HEIGHT);
        backgroundImage.setFillParent(true);
        stage.addActor(backgroundImage);
    }



    @Override
    public void draw(float v){
        stage.getViewport().apply();
        stage.act(v);
        stage.draw();
    }

    @Override
    public void addComponent(Actor actor) {}

    @Override
    public void addComponent(Sprite sprite) {}

    @Override
    public void update(int i, int i1, boolean b){
        stage.getViewport().update(i, i1, b);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
