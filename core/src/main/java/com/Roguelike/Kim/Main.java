package com.Roguelike.Kim;

import com.Roguelike.Kim.Display.SimplePanel;
import com.Roguelike.Kim.Display.StartMenuPanel;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;


/** {@link com.badlogic.gdx.Game} implementation shared by all platforms. */
public class Main extends Game {

    StartMenuPanel startMenuPanel;
    SimplePanel simplePanel;

    SoundManager soundManager;

    public static final float WIDTHTILES = 16;
    public static final float HEIGHTTILES = 10;

    @Override
    public void create() {
        startMenuPanel = new StartMenuPanel(this);
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
