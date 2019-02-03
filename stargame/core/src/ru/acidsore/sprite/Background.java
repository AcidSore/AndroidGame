package ru.acidsore.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.acidsore.base.Sprite;
import ru.acidsore.math.Rect;

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
