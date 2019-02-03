package ru.acidsore.pool;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import ru.acidsore.base.SpritesPool;
import ru.acidsore.math.Rect;
import ru.acidsore.sprite.game.Enemy;

public class EnemyPool extends SpritesPool<Enemy> {

    private Sound shootSound;
    private BulletPool bulletPool;
    private Rect worldBounds;

    public EnemyPool(BulletPool bulletPool, Rect worldBounce) {
        this.shootSound = Gdx.audio.newSound(Gdx.files.internal("music/shot.mp3"));
        this.bulletPool = bulletPool;
        this.worldBounds = worldBounce;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(shootSound, bulletPool, worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        shootSound.dispose();
    }
}

