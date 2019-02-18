package ru.acidsore.sprite.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.acidsore.screen.GameScreen;
import ru.acidsore.sprite.menu.ScaledTouchUpButton;

public class StartNewGame extends ScaledTouchUpButton {

    private GameScreen gameScreen;

    public StartNewGame(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
        setHeightProportion(0.05f);
        setTop(-0.012f);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}
