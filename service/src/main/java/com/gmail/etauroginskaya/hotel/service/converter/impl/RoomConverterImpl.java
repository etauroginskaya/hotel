package com.gmail.etauroginskaya.hotel.service.converter.impl;

import com.gmail.etauroginskaya.hotel.repository.model.Room;
import com.gmail.etauroginskaya.hotel.service.converter.RoomConverter;
import com.gmail.etauroginskaya.hotel.service.model.RoomDTO;
import org.springframework.stereotype.Component;

@Component
public class RoomConverterImpl implements RoomConverter {

    @Override
    public RoomDTO toDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setName(room.getName());
        roomDTO.setNumberOfBeds(room.getNumberOfBeds());
        roomDTO.setPrice(room.getPrice());
        return roomDTO;
    }

    @Override
    public Room fromDTO(RoomDTO roomDTO) {
        Room room = new Room();
        if (roomDTO.getId() != null) {
            room.setId(roomDTO.getId());
        }
        room.setName(roomDTO.getName());
        room.setNumberOfBeds(roomDTO.getNumberOfBeds());
        room.setPrice(roomDTO.getPrice());
        return room;
    }
}