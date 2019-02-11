package ru.acidsore.pool;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import ru.acidsore.base.SpritesPool;
import ru.acidsore.math.Rect;
import ru.acidsore.sprite.game.Enemy;
import ru.acidsore.sprite.game.MainShip;

public class EnemyPool extends SpritesPool<Enemy> {

    private Sound shootSound;
    private BulletPool bulletPool;
    private Rect worldBounds;
    private ExplosionPool explosionPool;
    private MainShip mainShip;

    public EnemyPool(BulletPool bulletPool, Rect worldBounds, ExplosionPool explosionPool, MainShip mainShip) {
        this.shootSound = Gdx.audio.newSound(Gdx.files.internal("music/shot.mp3"));
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.worldBounds = worldBounds;
        this.mainShip = mainShip;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(shootSound, bulletPool, explosionPool, worldBounds, mainShip);
    }

    @Override
    public void dispose() {
        super.dispose();
        shootSound.dispose();
    }
}

