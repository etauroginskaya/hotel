package com.gmail.etauroginskaya.hotel.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "works_days_schedule")
public class WorkDay {
    @Id
    private String day;

    public WorkDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
