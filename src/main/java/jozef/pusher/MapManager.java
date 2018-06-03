package jozef.pusher;

public interface MapManager {

    MapTile getActualTile();
    MapTile moveNorth();
    MapTile moveSouth();
    MapTile moveEast();
    MapTile moveWest();

}
