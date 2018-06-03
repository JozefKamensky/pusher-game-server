package jozef.pusher;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HttpResponseStatus {

    ROOM_CREATED(100),
    ROOM_ALREADY_EXISTS(101),
    ROOM_JOINED(102),
    CANNOT_JOIN_ROOM(103);

    private int code;

    HttpResponseStatus(int code) {
        this.code = code;
    }

    @JsonValue
    public int getCode() {
        return code;
    }
}
