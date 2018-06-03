package jozef.pusher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class PlayerController {

    private PlayerService playerService;

    PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/createRoom")
    public HttpResponse createRoom(@RequestParam("room") String roomName, @RequestParam("player") String playerName) {
        return playerService.createRoom(roomName, playerName);
    }

    @RequestMapping(value = "/joinRoom")
    public HttpResponse joinRoom(@RequestParam("room") String roomName, @RequestParam("player") String playerName) {
        return playerService.joinRoom(playerName, roomName);
    }
}
