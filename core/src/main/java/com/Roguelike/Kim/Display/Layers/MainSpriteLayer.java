package com.Roguelike.Kim.Display.Layers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainSpriteLayer implements Layer{

    private Batch batch;

    private Viewport spriteViewport;

    final int WIDTH;
    final int HEIGHT;

    final float widthTiles;
    final float heightTiles;

    public MainSpriteLayer(Batch batch, int WIDTH, int HEIGHT, float widthTiles, float heightTiles){
        this.batch = batch;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.widthTiles = widthTiles;
        this.heightTiles = heightTiles;

        spriteViewport = new ExtendViewport(widthTiles, heightTiles);
    }

    @Override
    public void draw(float v){
        spriteViewport.apply();
        batch.setProjectionMatrix(spriteViewport.getCamera().combined);
        batch.begin();
        //draw components here:

        batch.end();
    }

    @Override
    public void addComponent(Actor actor) {}

    @Override
    public void addComponent(Sprite sprite) {
        //TODO
    }

    @Override
    public void update(int i, int i1, boolean b){
        spriteViewport.update(i, i1, b);
    }

    @Override
    public void dispose() {

    }

}
