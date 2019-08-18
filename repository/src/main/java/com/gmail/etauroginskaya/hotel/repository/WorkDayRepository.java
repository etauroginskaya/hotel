package com.gmail.etauroginskaya.hotel.repository;

import com.gmail.etauroginskaya.hotel.repository.model.WorkDay;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkDayRepository extends MongoRepository<WorkDay, String> {
}
