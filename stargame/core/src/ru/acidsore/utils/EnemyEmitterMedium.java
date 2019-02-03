package ru.acidsore.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.acidsore.math.Rect;
import ru.acidsore.math.Rnd;
import ru.acidsore.pool.EnemyPool;
import ru.acidsore.sprite.game.Enemy;

    public class EnemyEmitterMedium {

        private static final float ENEMY_MEDIUM_HEIGHT = 0.1f;
        private static final float ENEMY_MEDIUM_BULLET_HEIGHT = 0.02f;
        private static final float ENEMY_MEDIUM_BULLET_VY = -0.4f;
        private static final int ENEMY_MEDIUM_DAMAGE = 2;
        private static final float ENEMY_MEDIUM_RELOAD_INTERVAL = 15f;
        private static final int ENEMY_MEDIUM_HP = 3;

        private Vector2 enemyMediumV = new Vector2(0, -0.3f);

        private TextureRegion[] enemyMediumRegion;

        private TextureRegion bulletRegion;

        private float generateInterval = 12f;
        private float generateTimer;

        private EnemyPool enemyPool;

        private Rect worldBounds;

        public EnemyEmitterMedium(TextureAtlas atlas, EnemyPool enemyPool, Rect worldBounds) {
            this.enemyPool = enemyPool;
            TextureRegion textureRegion = atlas.findRegion("enemy1");
            this.enemyMediumRegion = Regions.split(textureRegion, 1,2,2);
            this.bulletRegion = atlas.findRegion("bulletEnemy");
            this.worldBounds = worldBounds;
        }

        public void generate(float delta) {
            generateTimer += delta;
            if (generateTimer >= generateInterval) {
                generateTimer = 0f;
                Enemy enemy = enemyPool.obtain();
                enemy.set(
                        enemyMediumRegion,
                        enemyMediumV,
                        bulletRegion,
                        ENEMY_MEDIUM_BULLET_HEIGHT,
                        ENEMY_MEDIUM_BULLET_VY,
                        ENEMY_MEDIUM_DAMAGE,
                        ENEMY_MEDIUM_RELOAD_INTERVAL,
                        ENEMY_MEDIUM_HEIGHT,
                        ENEMY_MEDIUM_HP
                );
                enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
                enemy.setBottom(worldBounds.getTop());
            }
        }
    }

