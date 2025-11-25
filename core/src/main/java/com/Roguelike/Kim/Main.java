package com.Roguelike.Kim;

import com.Roguelike.Kim.Display.SimplePanel;
import com.Roguelike.Kim.Display.StartMenuPanel;
import com.badlogic.gdx.Game;


/** {@link com.badlogic.gdx.Game} implementation shared by all platforms. */
public class Main extends Game {

    StartMenuPanel startMenuPanel;
    SimplePanel simplePanel;

    @Override
    public void create() {
        startMenuPanel = new StartMenuPanel(this);
        setScreen(startMenuPanel);
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
