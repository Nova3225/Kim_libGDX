package com.Roguelike.Kim.Display.Factory;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ImageButtonFactory {

    public static ImageButton createWoodImageButton(float x, float y, float width, float height){
        Texture buttonTexture = new Texture("Button/button_brown.png");
        Texture buttonTextureDown = new Texture("Button/button_brown_close.png");
        return createImageButton(buttonTexture, buttonTextureDown, buttonTextureDown, x, y, width, height);
    }

    public static ImageButton createImageButton(Texture imageUp, Texture imageDown, Texture imageOver , float x, float y, float width, float height){
        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.imageUp = new TextureRegionDrawable(new TextureRegion(imageUp)){
            {
                setMinSize(width, height);
            }
        };
        style.imageDown = new TextureRegionDrawable(new TextureRegion(imageDown)){
            {
                setMinSize(width, height);
            }
        };
        style.imageOver = new TextureRegionDrawable(new TextureRegion(imageOver)){
            {
                setMinSize(width, height);
            }
        };
        ImageButton button = new ImageButton(style);
        button.setPosition(x, y);
        button.setSize(width, height);
        return button;
     }

     public static Label createLabelOnButton(ImageButton button, String text){
         Label.LabelStyle style = new Label.LabelStyle();
         style.font = new BitmapFont();
         style.font.getData().setScale(5f);
         style.font.getRegion().getTexture().setFilter(
             Texture.TextureFilter.Nearest, // 放大时使用最近邻
             Texture.TextureFilter.Nearest  // 缩小时使用最近邻
         );
         style.fontColor = Color.BROWN;

         Label label = new Label(text, style);
         label.setAlignment(1);
         label.setSize(button.getWidth() / 2, button.getHeight() / 2);
         label.setPosition(button.getX() + button.getWidth()/2 - label.getWidth()/2, button.getY() + button.getHeight()/2 - label.getHeight()/2);

         label.setTouchable(null);
         return label;
     }

}
