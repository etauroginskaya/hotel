package com.gmail.etauroginskaya.hotel.web.controller;

import com.gmail.etauroginskaya.hotel.service.RoomService;
import com.gmail.etauroginskaya.hotel.service.model.RoomDTO;
import com.gmail.etauroginskaya.hotel.service.model.DaysDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class RoomAPIController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/private/rooms")
    public ResponseEntity addRoom(@Validated(RoomDTO.New.class) @RequestBody RoomDTO roomDTO,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(getErrors(bindingResult).toString(), HttpStatus.BAD_REQUEST);
        }
        roomService.saveRoom(roomDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/private/rooms")
    public ResponseEntity updateRoom(@Validated(RoomDTO.Update.class) @RequestBody RoomDTO roomDTO,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(getErrors(bindingResult).toString(), HttpStatus.BAD_REQUEST);
        }
        roomService.saveRoom(roomDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    private Map<String, String> getErrors(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    @PostMapping("/private/rooms/days")
    public ResponseEntity addWorkDays(@Validated(DaysDTO.New.class) @RequestBody DaysDTO daysDTO,
                                      BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(getErrors(bindingResult).toString(), HttpStatus.BAD_REQUEST);
        }
        roomService.saveWorkDays(daysDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/rooms")
    public ResponseEntity getFreeRooms(@Validated(DaysDTO.Existing.class) @RequestBody DaysDTO dto) {
        return new ResponseEntity(roomService.getFreeRooms(dto), HttpStatus.OK);
    }

    @PostMapping("/reservations")
    public ResponseEntity reservationRoom(@RequestParam(value = "roomID") String roomID,
                                          @Validated(DaysDTO.Existing.class) @RequestBody DaysDTO dto,
                                          BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(getErrors(bindingResult).toString(), HttpStatus.BAD_REQUEST);
        }
        roomService.saveReservation(roomID, dto);
        return new ResponseEntity(HttpStatus.OK);
    }
}