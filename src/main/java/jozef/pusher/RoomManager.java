package jozef.pusher;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomManager {

    private Map<String, Room> rooms;

    public RoomManager() {
        rooms = new HashMap<>();
    }

    public boolean createRoom(String roomName, String ownerName) {
        if (rooms.containsKey(roomName)) return false;
        Room room = new Room(roomName, ownerName);
        System.out.println("Room " + room.getRoomName() + " created!");
        this.rooms.put(roomName, room);
        return true;
    }

    public List<String> addPlayerToRoom(String playerName, String roomName) {
        if (!rooms.containsKey(roomName)) return Collections.emptyList();
        Room r = rooms.get(roomName);
        r.addPlayer(playerName);
        return Collections.unmodifiableList(r.getPlayers());
    }

}
