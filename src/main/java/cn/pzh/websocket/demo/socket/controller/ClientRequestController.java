package cn.pzh.websocket.demo.socket.controller;

import cn.pzh.websocket.demo.entity.request.ClientRequest;
import cn.pzh.websocket.demo.entity.response.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientRequestController {

    @Autowired
    public SimpMessagingTemplate template;

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/user")
    public String user(){
        return "user";
    }

    @MessageMapping("/connect")
    @SendTo("/socketSend/info")
    public ServerResponse connect(ClientRequest clientRequest){
        System.out.println(clientRequest.getMessage());
        return new ServerResponse("welcome " + clientRequest.getMessage());
    }

    @RequestMapping("/connectUser")
    public void sendUser(ClientRequest clientRequest){
        int i = 0;
        while(true){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            template.convertAndSendToUser("user1", "/message", i);
            i++;
        }
    }

}
