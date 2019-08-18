package com.gmail.etauroginskaya.hotel.repository;

import com.gmail.etauroginskaya.hotel.repository.model.Book;
import com.gmail.etauroginskaya.hotel.repository.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, Book> {
}
