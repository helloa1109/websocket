package com.example.demo.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


import com.example.demo.dto.roomDto;

import java.util.*;

@Service
public class roomService {

    private Map<String, roomDto> rooms;

    @PostConstruct
    private void init(){
        rooms=new LinkedHashMap<>();
    }

    public List<roomDto> getAll(){
        List<roomDto> res = new ArrayList<>(rooms.values());
        Collections.reverse(res);
        return res;
    }

    public roomDto createRoom(String name){
        roomDto r = roomDto.create(name);
        rooms.put(r.getRoomId(),r);
        return r;
    }

    public roomDto getRoom(String roomId){
        return rooms.get(roomId);
    }
}
