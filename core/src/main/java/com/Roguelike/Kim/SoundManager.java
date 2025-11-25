package com.Roguelike.Kim;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {

    static Sound sound = Gdx.audio.newSound(Gdx.files.internal("Sound/ClickFilteredSaw.mp3"));

    Music music;

    public SoundManager(){
        music = Gdx.audio.newMusic(Gdx.files.internal("BGM/Lifted.mp3"));
        music.setLooping(true);
        music.play();
        music.setVolume(0.2f);
    }

    public static void playSound(String src){
        Sound tempSound;
        try {
            tempSound = Gdx.audio.newSound(Gdx.files.internal(src));
        } catch (Exception e) {
            tempSound = Gdx.audio.newSound(Gdx.files.internal("Sound/ClickFilteredSaw.mp3"));
        }
        tempSound.play();
    }

    public static void playClickSound(){
        sound.play();
    }
}
