package com.example.springwebsocket.Controller;

import com.example.springwebsocket.models.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    //send message to this url
    @MessageMapping("/message")
    //this means who ever subscribe this url , will get the message
    @SendTo("/topic/return-to")
    public Message getContent(@RequestBody Message message){
        try {
            //if we want to do some processing before sending the message
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message;

    }
}
