package com.Roguelike.Kim.Display.Layers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class UiLayer implements Layer{
    private Batch batch;

    private Viewport uiViewport;
    public Stage stage;

    private final int WIDTH;
    private final int HEIGHT;

    public UiLayer(Batch batch, int WIDTH, int HEIGHT){
        this.batch = batch;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        uiViewport = new FitViewport(WIDTH, HEIGHT);
        stage = new Stage(uiViewport, batch);
    }

    @Override
    public void draw(float v){
        uiViewport.apply();
        stage.act(v);
        stage.draw();
    }

    @Override
    public void addComponent(Actor actor) {
        stage.addActor(actor);
    }

    @Override
    public void addComponent(Sprite sprite) {}

    @Override
    public void update(int i, int i1, boolean b) {
        uiViewport.update(i, i1, b);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
