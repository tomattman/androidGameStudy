package com.gmail.tomattman.game.managers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextManager {
    static BitmapFont font;
    static float width,height;
    static String text;


    public static void init(float width, float height){
        TextManager.width = width;
        TextManager.height= height;

        font = new BitmapFont();
        font.setColor(Color.CORAL);
        font.getData().setScale(width / 800f);
    }

    public static void render(SpriteBatch batch){
        if(text != null && !text.isEmpty()) {
            GlyphLayout layout = new GlyphLayout();
            layout.setText(font, text);
            font.draw(batch, layout, (width / 2 - layout.width / 2), height - 50 -layout.height / 2);
        }

    }

    public static void changeState(String message){
        text = message;
    }
}
