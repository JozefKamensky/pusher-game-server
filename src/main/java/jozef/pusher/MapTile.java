package jozef.pusher;

public class MapTile {
    private MapTileType type;
    private int difficulty;
    private boolean cleared;
    private MapTile north;
    private MapTile south;
    private MapTile east;
    private MapTile west;

    public MapTile(MapTileType type, int difficulty) {
        this.type = type;
        this.difficulty = difficulty;
        this.cleared = false;
    }

    public MapTileType getType() {
        return type;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public boolean isCleared() {
        return cleared;
    }

    public MapTile getNorth() {
        return north;
    }

    public MapTile getEast() {
        return east;
    }

    public MapTile getSouth() {
        return south;
    }

    public MapTile getWest() {
        return west;
    }

    public void setNorth(MapTile north) {
        this.north = north;
    }

    public void setEast(MapTile east) {
        this.east = east;
    }

    public void setSouth(MapTile south) {
        this.south = south;
    }

    public void setWest(MapTile west) {
        this.west = west;
    }
}
