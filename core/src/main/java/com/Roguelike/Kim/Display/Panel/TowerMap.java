package com.Roguelike.Kim.Display.Panel;

import com.Roguelike.Kim.Display.Animation.Overlay;
import com.Roguelike.Kim.Display.EntityDisplay.Info;
import com.Roguelike.Kim.Display.EntityDisplay.PlayerDisplay;
import com.Roguelike.Kim.Display.Factory.ImageButtonFactory;
import com.Roguelike.Kim.Display.Input.Movement;
import com.Roguelike.Kim.Display.Layers.Layer;
import com.Roguelike.Kim.Display.SoundManager;
import com.Roguelike.Kim.GameManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;


public class TowerMap extends Panel{

    PlayerDisplay playerDisplay;
    Texture playerTexture;
    Movement movement;

    Button buttonLoad;

    Group group;

    public TowerMap(Game game, GameManager gameManager){
        super(game, gameManager);

        init();
        arrangement();
    }

    protected void init() {
        playerTexture = new Texture("player.png");

        movement = new Movement();
        group = new Group();
        gameManager.fight();
    }

    int ya = 1;

    @Override
    protected void arrangement() {
        buttonLoad = ImageButtonFactory.createWoodImageButton(WIDTH / 24 * 3, HEIGHT / 4, WIDTH / 12, HEIGHT / 8);
        buttonLoad.addListener(new ClickListener()  {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                /*
                group.remove();
                gameManager.playerAttack();
                Info info = new Info(gameManager.player);
                Label label = info.showInfoWithLabel(1);
                group.addActor(label);
                info = new Info(gameManager.monster);
                label = info.showInfoWithLabel(2);
                label.setPosition(label.getX(), label.getY() + ya);
                group.addActor(label);
                uiLayer.addComponent(group);
                单独拎出来两个Label来删除。
                 */

            }
        });
        uiLayer.addComponent(buttonLoad);
    }

    protected void spriteArrangement(){
        playerDisplay = new PlayerDisplay(playerTexture,1,1 , 1, 1, 4);
        mainSpriteLayer.addComponent(playerDisplay);
    }

    @Override
    public void show() {
        super.show();
        spriteArrangement();
    }

    @Override
    public void render(float v) {
        input();
        logic();
        draw(v);
    }

    @Override
    protected void input() {
        movement.moveWithWASDGravity(playerDisplay, playerDisplay.getSpeed(), Gdx.graphics.getDeltaTime());
        movement.limitedInScreen(playerDisplay);
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
        super.dispose();
    }

}
