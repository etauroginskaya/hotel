package com.gmail.etauroginskaya.hotel.service.impl;

import com.gmail.etauroginskaya.hotel.repository.UserRepository;
import com.gmail.etauroginskaya.hotel.repository.model.RoleEnum;
import com.gmail.etauroginskaya.hotel.repository.model.User;
import com.gmail.etauroginskaya.hotel.service.model.AppUserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);
    @Autowired
    private UserRepository repository;

    @PostConstruct
    private void addUsers() {
        repository.save(new User("1", "administrator",
                "$2a$12$yJC/IQ2QYg/3FjNPoNiRfexcu3emdwhHBURzsMXL.GTs2i5tFkmZS", RoleEnum.ADMINISTRATOR));
        repository.save(new User("2", "user",
                "$2a$12$yJC/IQ2QYg/3FjNPoNiRfexcu3emdwhHBURzsMXL.GTs2i5tFkmZS", RoleEnum.USER));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = repository.findByUsername(username);
        if (user == null) {
            logger.info("User with username: {} doesn't exist", username);
            throw new UsernameNotFoundException(String.format("User with username: %s doesn't exist", username));
        }
        return new AppUserPrincipal(user);
    }
}