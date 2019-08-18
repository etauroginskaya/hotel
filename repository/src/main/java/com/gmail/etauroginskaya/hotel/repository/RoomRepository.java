package com.gmail.etauroginskaya.hotel.repository;

import com.gmail.etauroginskaya.hotel.repository.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}
