package cn.pzh.websocket.demo.entity.response;

public class ServerResponse {

    private String respMessage;

    public ServerResponse() {
    }

    public ServerResponse(String respMessage) {
        this.respMessage = respMessage;
    }

    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }
}

