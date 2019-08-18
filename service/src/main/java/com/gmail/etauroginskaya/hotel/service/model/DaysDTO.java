package com.gmail.etauroginskaya.hotel.service.model;

import com.gmail.etauroginskaya.hotel.service.validators.annotations.IsWorking;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class DaysDTO {
    public interface New {
    }

    public interface Existing {
    }

    @NotEmpty(groups = {New.class, Existing.class})
    @IsWorking(groups = {Existing.class})
    private LocalDate[] days;

    public LocalDate[] getDays() {
        return days;
    }

    public void setDays(LocalDate[] days) {
        this.days = days;
    }
}