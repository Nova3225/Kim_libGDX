package com.Roguelike.Kim;

import com.Roguelike.Kim.Display.StartMenu;
import com.badlogic.gdx.Game;


/** {@link com.badlogic.gdx.Game} implementation shared by all platforms. */
public class Main extends Game {

    StartMenu startMenu;

    @Override
    public void create() {
        startMenu = new StartMenu(this);
        setScreen(startMenu);
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
        startMenu.dispose();
    }
}
