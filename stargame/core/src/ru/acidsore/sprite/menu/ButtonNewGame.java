package ru.acidsore.sprite.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.acidsore.math.Rect;
import ru.acidsore.screen.GameScreen;

public class ButtonNewGame extends ScaledTouchUpButton {

    private Game game;

    public ButtonNewGame(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("button_new_game"));
        this.game = game;
        setHeightProportion(0.15f);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setTop(worldBounds.getHalfHeight());
        setRight(worldBounds.getRight() - 0.02f);
    }

    @Override
    public void action() {
        game.setScreen(new GameScreen());
    }

}
