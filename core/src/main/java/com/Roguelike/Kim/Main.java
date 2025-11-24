package com.Roguelike.Kim;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.security.Key;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main implements ApplicationListener {
    private SpriteBatch batch;
    private FitViewport viewport;

    private Texture image;
    private Sprite player;

    private Vector2 vector;

    @Override
    public void create() {
        batch = new SpriteBatch();
        viewport = new FitViewport(16,10);


        image = new Texture("libgdx.png");
        player = new Sprite(image);
        player.setPosition(0, 0);
        vector = new Vector2();
    }

    @Override
    public void resize(int i, int i1) {
        viewport.update(i, i1,true);
    }

    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    private void input() {
        float speed = 5f;
        float deltaTime = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            player.translateY(speed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            player.translateY(-speed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.translateX(-speed * deltaTime);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.translateX(speed * deltaTime);
        }
    }

    private void logic() {

    }


    private void draw() {
        float viewportWidth = viewport.getWorldWidth();
        float viewportHeight = viewport.getWorldHeight();

        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();

        batch.draw(player, player.getX(), player.getY(), 8, 2);

        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
