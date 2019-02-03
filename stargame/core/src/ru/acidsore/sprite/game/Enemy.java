package ru.acidsore.sprite.game;

import ru.acidsore.base.Sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.acidsore.math.Rect;
import ru.acidsore.pool.BulletPool;


public class Enemy extends Ship {

    private Vector2 v0 = new Vector2();

    private Rect worldBounds;
    private Vector2 v = new Vector2();
    private int damage;
    private Object owner;


    public Enemy(Sound shootSound, BulletPool bulletPool, Rect worldBounds) {
        super();
        this.shootSound = shootSound;
        this.bulletPool = bulletPool;
        this.v.set(v0);
        this.bulletV = new Vector2();
        this.shootSound= Gdx.audio.newSound(Gdx.files.internal("music/bullet.wav"));
        this.reloadInterval = 0.3f;
        this.worldBounds = worldBounds;
        this.owner = owner;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        this.pos.mulAdd(v, delta);
        reloadTimer += delta;
           if (reloadTimer >= reloadInterval)
           {
               reloadTimer = 0f;
               shoot();
           }
        if (getBottom()< worldBounds.getBottom()) {
            destroy();
        }
    }


    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            float bulletVY,
            int bulletDamage,
            float reloadInterval,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(0, bulletVY);
        this.damage = bulletDamage;
        this.reloadInterval = reloadInterval;
        setHeightProportion(height);
        this.hp = hp;
        reloadTimer = reloadInterval;
        v.set(v0);
    }
    public void shoot() {
        Bullet bulletEnemy = bulletPool.obtain();
        bulletEnemy.set(this, bulletRegion, pos, new Vector2(0, -0.5f), 0.01f, worldBounds, 1);
        shootSound.play();
    }
}

