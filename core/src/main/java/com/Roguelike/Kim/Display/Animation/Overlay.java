package com.Roguelike.Kim.Display.Animation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Overlay {

    public static void fadeOutAnimation(float seconds, Runnable runnable, Stage stage){
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK); // 最终变为
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        Image overlay = new Image(texture);
        overlay.setColor(0, 0, 0, 0); // 初始透明
        overlay.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getWidth());
        overlay.setPosition(0, 0);

        // 添加到UI层的最上面
        stage.addActor(overlay);

        // 执行淡出动画
        overlay.addAction(Actions.sequence(
            Actions.fadeIn(seconds),
            Actions.run(() ->
                Gdx.app.postRunnable(() -> {
                    overlay.remove();
                    runnable.run();
                })
            )
        ));
    }

    public static void fadeInAnimation(float seconds, Runnable runnable, Stage stage){
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK); // 从黑色开始
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        Image overlay = new Image(texture);
        overlay.setColor(1, 1, 1, 1); // 初始全黑
        overlay.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getWidth());
        overlay.setPosition(0, 0);

        // 添加到UI层的最上面
        stage.addActor(overlay);

        // 执行淡出动画
        overlay.addAction(Actions.sequence(
            Actions.fadeOut(seconds),
            Actions.run(() ->
                Gdx.app.postRunnable(() -> {
                    overlay.remove();
                    runnable.run();
                })
            )
        ));
    }
}
