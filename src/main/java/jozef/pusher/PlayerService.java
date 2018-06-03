package jozef.pusher;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerService {

    private EventSender eventSender;
    private RoomManager roomManager;
    private SituationGenerator situationGenerator;
    private MapManager mapManager;

    public PlayerService(EventSender eventSender,
                         RoomManager roomManager,
                         SituationGenerator situationGenerator,
                         RandomMapManager randomMapManager) {
        this.eventSender = eventSender;
        this.roomManager = roomManager;
        this.situationGenerator = situationGenerator;
        this.mapManager = randomMapManager;
    }

    public HttpResponse createRoom(String roomName, String ownerName) {
        boolean success = roomManager.createRoom(roomName, ownerName);
        if (success) {
            return new HttpResponse(
                    HttpResponseStatus.ROOM_CREATED,
                    "Room was successfully created!");
        }
        return new HttpResponse(
                HttpResponseStatus.ROOM_ALREADY_EXISTS,
                "Room cannot be created (room with same name already exists)!");
    }

    public HttpResponse joinRoom(String playerName, String roomName) {
        List<String> players = roomManager.addPlayerToRoom(playerName, roomName);
        if (players.size() > 0) {
            eventSender.sendEvent(roomName, "players", players);
            return new HttpResponse(
                    HttpResponseStatus.ROOM_JOINED,
                    "You successfully joined the room " + roomName);
        }
        return new HttpResponse(
                HttpResponseStatus.CANNOT_JOIN_ROOM,
                "Could not join the room " + roomName);
    }

    public Situation generateTestSituation() {
        return situationGenerator.generateTestSituation();
    }

    public void sendTestEvent(String roomName, String eventName) {
        Map<String, Object> testEventData = new HashMap<>();
        testEventData.put("message", "Test event message");
        testEventData.put("status", "OK");
        testEventData.put("errorCode", "0");
        eventSender.sendEvent(roomName, eventName, testEventData);
    }

    public void sendMoveEvent(String roomName) {
        eventSender.sendEvent(roomName, "move", mapManager.getActualTile());
    }

    public void moveNorth(String roomName) {
        System.out.println("moveNorth()");
        mapManager.moveNorth();
        sendMoveEvent(roomName);
    }

}
