package ru.acidsore;

import com.badlogic.gdx.Game;

import ru.acidsore.screen.MenuScreen;

public class Star2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
