package com.example.demo.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.msgDto;
@RestController
@RequiredArgsConstructor
@Slf4j
public class msgController {

    private final SimpMessageSendingOperations sendingOperations;

    @MessageMapping("/msg")
    public void msg(msgDto msg){
        switch (msg.getType()){
            case "ENTER":
                msg.setMsg(msg.getUserName() + "님이 입장하셨습니다");
                break;
            case "CHAT":
                break;
            default:
                break;
        }
        sendingOperations.convertAndSend("/sub/room"+msg.getRoomId(), msg);
    }
}
