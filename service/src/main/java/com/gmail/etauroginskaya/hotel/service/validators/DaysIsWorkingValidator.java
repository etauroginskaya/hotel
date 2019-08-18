package com.gmail.etauroginskaya.hotel.service.validators;

import com.gmail.etauroginskaya.hotel.repository.WorkDayRepository;
import com.gmail.etauroginskaya.hotel.service.validators.annotations.IsWorking;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaysIsWorkingValidator implements ConstraintValidator<IsWorking, LocalDate[]> {
    @Autowired
    private WorkDayRepository repository;

    @Override
    public void initialize(IsWorking constraint) {
    }

    @Override
    public boolean isValid(LocalDate[] days, ConstraintValidatorContext cxt) {
        if (days != null) {
            List<String> listDays = new ArrayList<>();
            Arrays.asList(days).forEach(date -> listDays.add(date.toString()));
            for (String day : listDays) {
                if (!repository.existsById(day)) {
                    return false;
                }
            }
        } else return false;
        return true;
    }
}