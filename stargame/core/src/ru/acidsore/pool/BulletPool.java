package ru.acidsore.pool;

import ru.acidsore.sprite.game.Bullet;
import ru.acidsore.base.SpritesPool;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
