package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.roomService;
import com.example.demo.dto.roomDto;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/lobby")
@Slf4j
public class lobbyController {

    @Autowired
    roomService roomService;

    @GetMapping("/list")
    public List<roomDto> getList(){
        // log.info("방목록 호출");
        return roomService.getAll();
    }

    @PostMapping("/create")
    public roomDto postCreate(@RequestBody Map<String, Object> data){
        return roomService.createRoom(data.get("name").toString());
    }
}
