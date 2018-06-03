import com.pusher.rest.Pusher;

import java.util.Collections;

public class EventSender {

    private Pusher pusher;

    public EventSender() {
        pusher = new Pusher("528791", "334cf521870c48ddeb7d", "bcb9d5afe4fb1c8c672c");
        pusher.setCluster("eu");
        pusher.setEncrypted(true);
    }

    public void sendEvent() {
        pusher.trigger("my-channel", "my-event", Collections.singletonMap("message", "hello world"));
    }

}
