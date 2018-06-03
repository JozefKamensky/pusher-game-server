package jozef.pusher;

import com.pusher.rest.Pusher;
import org.springframework.stereotype.Component;

@Component
public class EventSender {

    private static EventSender ourInstance = new EventSender();
    private Pusher pusher;

    public static EventSender getInstance() {
        return ourInstance;
    }

    private EventSender() {
        pusher = new Pusher("528791", "334cf521870c48ddeb7d", "bcb9d5afe4fb1c8c672c");
        pusher.setCluster("eu");
        pusher.setEncrypted(true);
    }

    public void sendEvent(String channelName, String eventName, Object data) {
        pusher.trigger(channelName, eventName, data);
    }
}
