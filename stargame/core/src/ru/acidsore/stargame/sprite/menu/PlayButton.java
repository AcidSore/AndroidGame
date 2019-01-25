package ru.acidsore.stargame.sprite.menu;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.acidsore.stargame.screen.GameScreen;
import ru.acidsore.stargame.screen.MenuScreen;

public class PlayButton extends ScaledTouchUpButton {

    private static final float PRESS_SCALE = .3f;
    private int pointer;
    private boolean isPressed;
    private Vector2 touch;

    public PlayButton(TextureAtlas atlas) {
        super(atlas.findRegion("btPlay"));
    }

    public boolean touchDown(Vector2 touch, int pointer) {
        if (isPressed || !isMe(touch)) {
            return false;
        }
        this.pointer = pointer;
        this.scale = PRESS_SCALE*0.5f;
        this.isPressed = true;
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        if (this.pointer != pointer || !isPressed) {
            return false;
        }
        if (isMe(touch)) {
            action();
        }
        this.isPressed = false;
        scale = PRESS_SCALE;
        action();
        return super.touchUp(touch, pointer);
    }

    @Override
    public void action() {
        MenuScreen.game.setScreen(new GameScreen());
    }
}
