package jozef.pusher;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    private PlayerService playerService;

    public TestController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "/createSituation")
    public Situation createRoom() {
        return this.playerService.generateTestSituation();
    }

    @RequestMapping(value = "/sendEvent")
    public void sendTestEvent(@RequestParam("room") String roomName, @RequestParam("name") String eventName) {
        playerService.sendTestEvent(roomName, eventName);
    }

    @RequestMapping(value = "/sendMoveEvent")
    public void sendTestMoveEvent(@RequestParam("room") String roomName) {
        playerService.sendMoveEvent(roomName);
    }

    @RequestMapping(value = "/moveNorth")
    public void testMoveNorth(@RequestParam("room") String roomName) {
        playerService.moveNorth(roomName);
    }
}
