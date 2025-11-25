package com.Roguelike.Kim.Display;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TiledGameMap {
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    public TiledGameMap(String mapFile) {
        // 使用内置的 TmxMapLoader
        tiledMap = new TmxMapLoader().load(mapFile);
        renderer = new OrthogonalTiledMapRenderer(tiledMap);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 16*16, 16*10);
    }

    public void render() {
        renderer.setView(camera);
        renderer.render();
    }

    public void update(float delta, float playerX, float playerY) {
        // 相机跟随玩家（限制边界）
        float cameraX = Math.max(camera.viewportWidth / 2,
            Math.min(playerX, getMapWidth() - camera.viewportWidth / 2));
        float cameraY = Math.max(camera.viewportHeight / 2,
            Math.min(playerY, getMapHeight() - camera.viewportHeight / 2));

        camera.position.set(cameraX, cameraY, 0);
        camera.update();
    }

    public float getMapWidth() {
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
    }

    public float getMapHeight() {
        return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight();
    }

    public void dispose() {
        tiledMap.dispose();
        renderer.dispose();
    }
}
