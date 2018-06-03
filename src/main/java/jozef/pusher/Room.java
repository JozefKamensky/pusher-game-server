package jozef.pusher;

import java.util.ArrayList;
import java.util.List;

class Room {

    private String roomName;
    private boolean open;
    private List<String> players;
    private String owner;

    Room(String roomName, String ownerName) {
        this.roomName = roomName;
        this.open = true;
        this.owner = ownerName;
        players = new ArrayList<>();
        players.add(ownerName);
    }

    String getRoomName() {
        return this.roomName;
    }

    boolean isOpen() {
        return open;
    }

    void setOpen(boolean open) {
        this.open = open;
    }

    List<String> getPlayers() {
        return players;
    }

    void addPlayer(String playerName) {
        players.add(playerName);
    }

    void removePlayer(String playerName) {
        players.remove(playerName);
    }

    String getOwner() {
        return owner;
    }

    void setOwner(String owner) {
        this.owner = owner;
    }
}
