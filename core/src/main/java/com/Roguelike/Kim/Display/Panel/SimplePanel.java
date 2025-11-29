package com.Roguelike.Kim.Display.Panel;

import com.Roguelike.Kim.Display.Animation.Overlay;
import com.Roguelike.Kim.Display.Input.Movement;
import com.Roguelike.Kim.Display.Logic.Display;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class SimplePanel implements Screen {
    final Game game;

    //主要显示对象
    private SpriteBatch batch;
    private FitViewport viewport;
    Stage stage;

    //显示部件
    private Texture background;
    private Texture image;
    private Sprite player;

    //数据工具
    private Vector2 vector;

    //显示参数
    float viewportWidth;
    float viewportHeight;

    public SimplePanel(Game game) {
        this.game = game;
    }

    @Override
    public void show() {


        batch = new SpriteBatch();
        viewport = new FitViewport(16,10);

        viewportWidth = viewport.getWorldWidth();
        viewportHeight = viewport.getWorldHeight();

        stage = new Stage(viewport, batch);

        image = new Texture("player.png");
        player = new Sprite(image);
        player.setPosition(0, 0);
        player.setSize(3, 3);
        vector = new Vector2();

        Overlay.fadeInAnimation(1, () -> {
            System.out.println(1);
        }, stage);

    }

    @Override
    public void render(float v) {
        input();
        logic();
        draw();
    }

    private void input() {
        float speed = 5f;
        float deltaTime = Gdx.graphics.getDeltaTime();

        Movement movement = new Movement();
        movement.moveWithWASD(player, speed, deltaTime);
    }

    private void logic() {
        Display.limitInScreen(player, viewport);
    }


    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        batch.draw(player, player.getX(), player.getY(), player.getWidth(), player.getHeight());

        batch.end();
    }

    @Override
    public void resize(int i, int i1) {
        viewport.update(i, i1,true);
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
        batch.dispose();
        image.dispose();
        player.getTexture().dispose();
    }
}
