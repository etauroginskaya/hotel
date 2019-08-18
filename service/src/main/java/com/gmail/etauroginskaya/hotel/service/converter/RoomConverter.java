package com.gmail.etauroginskaya.hotel.service.converter;

import com.gmail.etauroginskaya.hotel.repository.model.Room;
import com.gmail.etauroginskaya.hotel.service.model.RoomDTO;

public interface RoomConverter {
    RoomDTO toDTO(Room room);

    Room fromDTO(RoomDTO roomDTO);
}