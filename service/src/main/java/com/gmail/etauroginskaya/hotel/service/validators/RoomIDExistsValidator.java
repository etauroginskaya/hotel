package com.gmail.etauroginskaya.hotel.service.validators;

import com.gmail.etauroginskaya.hotel.repository.RoomRepository;
import com.gmail.etauroginskaya.hotel.service.validators.annotations.RoomIDExists;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoomIDExistsValidator implements ConstraintValidator<RoomIDExists, String> {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void initialize(RoomIDExists constraint) {
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext cxt) {
        if (id == null || !roomRepository.findById(id).isPresent())
            return false;
        return true;
    }
}