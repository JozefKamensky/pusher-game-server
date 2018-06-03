package jozef.pusher;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomMapManager implements MapManager {

    private MapTile actualTile;
    private static Random rng = new Random();

    public RandomMapManager() {
        this.actualTile = generateRandomTile();
        this.actualTile.setNorth(generateRandomTile());
        this.actualTile.setSouth(generateRandomTile());
        this.actualTile.setEast(generateRandomTile());
        this.actualTile.setWest(generateRandomTile());
    }

    @Override
    public MapTile getActualTile() {
        return this.actualTile;
    }

    @Override
    public MapTile moveNorth() {
        MapTile tmp = new MapTile(actualTile.getType(), actualTile.getDifficulty());
        actualTile = actualTile.getNorth();
        actualTile.setNorth(generateRandomTile());
        actualTile.setSouth(tmp);
        actualTile.setEast(generateRandomTile());
        actualTile.setWest(generateRandomTile());
        return actualTile;
    }

    @Override
    public MapTile moveSouth() {
        MapTile tmp = new MapTile(actualTile.getType(), actualTile.getDifficulty());
        actualTile = actualTile.getSouth();
        actualTile.setNorth(tmp);
        actualTile.setSouth(generateRandomTile());
        actualTile.setEast(generateRandomTile());
        actualTile.setWest(generateRandomTile());
        return actualTile;
    }

    @Override
    public MapTile moveEast() {
        MapTile tmp = new MapTile(actualTile.getType(), actualTile.getDifficulty());
        actualTile = actualTile.getEast();
        actualTile.setNorth(generateRandomTile());
        actualTile.setSouth(generateRandomTile());
        actualTile.setEast(generateRandomTile());
        actualTile.setWest(tmp);
        return actualTile;
    }

    @Override
    public MapTile moveWest() {
        MapTile tmp = new MapTile(actualTile.getType(), actualTile.getDifficulty());
        actualTile = actualTile.getWest();
        actualTile.setNorth(generateRandomTile());
        actualTile.setSouth(generateRandomTile());
        actualTile.setEast(tmp);
        actualTile.setWest(generateRandomTile());
        return actualTile;
    }

    private MapTile generateRandomTile() {
        int mapTileTypesCount = MapTileType.values().length;
        MapTileType tileType = MapTileType.values()[rng.nextInt(mapTileTypesCount)];
        int difficulty = rng.nextInt(5) + 1;
        return new MapTile(tileType, difficulty);
    }
}
