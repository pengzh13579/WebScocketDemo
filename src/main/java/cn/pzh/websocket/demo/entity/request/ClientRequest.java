package cn.pzh.websocket.demo.entity.request;

public class ClientRequest {

    private String message;

    public ClientRequest() {
    }

    public ClientRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
