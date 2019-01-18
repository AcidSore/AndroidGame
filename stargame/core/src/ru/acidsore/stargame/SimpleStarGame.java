package ru.acidsore.stargame;

import com.badlogic.gdx.Game;
import ru.acidsore.stargame.screen.MenuScreen;

public class SimpleStarGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen());
    }
}
