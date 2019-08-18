package com.gmail.etauroginskaya.hotel.service;

import com.gmail.etauroginskaya.hotel.service.model.DaysDTO;
import com.gmail.etauroginskaya.hotel.service.model.RoomDTO;

import java.util.List;

public interface RoomService {
    void saveRoom(RoomDTO roomDTO);

    List<RoomDTO> getFreeRooms(DaysDTO dto);

    void saveWorkDays(DaysDTO daysDTO);

    void saveReservation(String roomID, DaysDTO dto);
}
