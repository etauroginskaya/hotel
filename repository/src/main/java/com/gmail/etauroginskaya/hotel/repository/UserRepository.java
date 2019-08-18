package com.gmail.etauroginskaya.hotel.repository;

import com.gmail.etauroginskaya.hotel.repository.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
