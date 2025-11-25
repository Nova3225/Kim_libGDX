package com.Roguelike.Kim.Display.Layers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.List;

public class MainSpriteLayer implements Layer{

    private Batch batch;

    public Viewport spriteViewport;

    final float WIDTH;
    final float HEIGHT;

    public final float widthTiles;
    public final float heightTiles;

    List<Sprite> sprites;

    public MainSpriteLayer(Batch batch, float WIDTH, float HEIGHT, float widthTiles, float heightTiles){
        this.batch = batch;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.widthTiles = widthTiles;
        this.heightTiles = heightTiles;

        spriteViewport = new FitViewport(widthTiles, heightTiles);

        sprites = new ArrayList<>();
    }

    @Override
    public void draw(float v){
        spriteViewport.apply();
        batch.setProjectionMatrix(spriteViewport.getCamera().combined);

        batch.begin();
        //draw components here:
        for (Sprite sprite : sprites){
            sprite.draw(batch);
        }
        batch.end();
    }

    @Override
    public void addComponent(Actor actor) {}

    @Override
    public void addComponent(Sprite sprite) {
        //TODO
        sprites.add(sprite);
    }

    @Override
    public void update(int i, int i1, boolean b){
        spriteViewport.update(i, i1, b);
    }

    @Override
    public void dispose() {
        for (Sprite sprite : sprites){
            sprite.getTexture().dispose();
        }
    }

}
