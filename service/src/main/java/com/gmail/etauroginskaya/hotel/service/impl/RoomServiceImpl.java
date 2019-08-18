package com.gmail.etauroginskaya.hotel.service.impl;

import com.gmail.etauroginskaya.hotel.repository.ReservationRepository;
import com.gmail.etauroginskaya.hotel.repository.RoomRepository;
import com.gmail.etauroginskaya.hotel.repository.WorkDayRepository;
import com.gmail.etauroginskaya.hotel.repository.model.Book;
import com.gmail.etauroginskaya.hotel.repository.model.Reservation;
import com.gmail.etauroginskaya.hotel.repository.model.Room;
import com.gmail.etauroginskaya.hotel.repository.model.WorkDay;
import com.gmail.etauroginskaya.hotel.service.RoomService;
import com.gmail.etauroginskaya.hotel.service.converter.RoomConverter;
import com.gmail.etauroginskaya.hotel.service.exceptions.ServiceException;
import com.gmail.etauroginskaya.hotel.service.model.RoomDTO;
import com.gmail.etauroginskaya.hotel.service.model.DaysDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomConverter roomConverter;
    @Autowired
    private WorkDayRepository workDayRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void saveRoom(RoomDTO dto) {
        roomRepository.save(roomConverter.fromDTO(dto));
    }

    @Override
    public List<RoomDTO> getFreeRooms(DaysDTO dto) {
        List<Room> rooms = roomRepository.findAll();
        List<String> freeRoomsID = new ArrayList<>();
        Book book = new Book();
        for (Room room : rooms) {
            book.setRoomID(room.getId());
            for (LocalDate day : dto.getDays()) {
                book.setDay(day.toString());
                if (!reservationRepository.existsById(book)) {
                    freeRoomsID.add(book.getRoomID());
                }
            }
        }
        List<RoomDTO> freeRoom = new ArrayList<>();
        for (Room room : roomRepository.findAllById(freeRoomsID)) {
            freeRoom.add(roomConverter.toDTO(room));
        }
        return freeRoom;
    }

    @Override
    public void saveWorkDays(DaysDTO daysDTO) {
        workDayRepository.saveAll(getListWorkDays(daysDTO.getDays()));
    }

    private List<WorkDay> getListWorkDays(LocalDate[] array) {
        List<WorkDay> workDayList = new ArrayList<>();
        Arrays.asList(array).forEach(date -> workDayList.add(new WorkDay(date.toString())));
        return workDayList;
    }

    @Override
    public void saveReservation(String roomID, DaysDTO dto) {
        List<Reservation> reservationList = new ArrayList<>();
        Book book = new Book();
        Reservation reservation = new Reservation();
        for (LocalDate day : dto.getDays()) {
            book.setDay(day.toString());
            book.setRoomID(roomID);
            reservation.setBook(book);
            if (reservationRepository.existsById(book)) {
                throw new ServiceException
                        (String.format("Room booked on %s", day));
            }
            reservationList.add(reservation);
        }
        reservationRepository.saveAll(reservationList);
    }
}