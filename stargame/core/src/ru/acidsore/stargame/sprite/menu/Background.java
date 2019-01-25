package ru.acidsore.stargame.sprite.menu;

import ru.acidsore.stargame.base.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.acidsore.stargame.math.Rect;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    public void resize(Rect worldBounds) {
        pos.set(worldBounds.pos);
        setHeightProportion(worldBounds.getHeight());
    }

}
