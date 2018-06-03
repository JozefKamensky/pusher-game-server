package jozef.pusher;

public class HttpResponse {

    private HttpResponseStatus status;
    private String message;

    public HttpResponse(HttpResponseStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpResponseStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
