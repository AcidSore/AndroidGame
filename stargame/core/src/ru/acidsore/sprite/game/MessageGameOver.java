package ru.acidsore.sprite.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.acidsore.base.Sprite;

    public class MessageGameOver extends Sprite {

        public MessageGameOver(TextureAtlas atlas) {
            super(atlas.findRegion("message_game_over"));
            setHeightProportion(0.07f);
            setBottom(0.009f);
        }

}
