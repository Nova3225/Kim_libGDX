package com.Roguelike.Kim;

import com.Roguelike.Kim.Display.Panel.SimplePanel;
import com.Roguelike.Kim.Display.SoundManager;
import com.Roguelike.Kim.Display.Panel.StartMenuPanel;
import com.badlogic.gdx.Game;


/** {@link com.badlogic.gdx.Game} implementation shared by all platforms. */
public class Main extends Game {

    StartMenuPanel startMenuPanel;
    SimplePanel simplePanel;

    SoundManager soundManager;

    public static final float WIDTHTILES = 16;
    public static final float HEIGHTTILES = 10;

    GameManager gameManager;

    @Override
    public void create() {
        gameManager = new GameManager();
        startMenuPanel = new StartMenuPanel(this, gameManager);
        setScreen(startMenuPanel);

        //soundManager = new SoundManager();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        startMenuPanel.dispose();
    }


}
