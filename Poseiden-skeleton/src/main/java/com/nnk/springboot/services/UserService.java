package com.nnk.springboot.services;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        log.info("Find all users");
        return userRepository.findAll();
    }

    @Override
    public User add(User user) {
        log.info("Add a user");
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        log.info("Update a user");
        return userRepository.save(user);
    }

    @Override
    public User getById(Integer id) {
        log.info("Get a user by id");
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }

    @Override
    public void delete(User user) {
        log.info("Delete a user");
        userRepository.delete(user);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    /**
     * This method is responsible for removing all trades from database
     */
    public void clearDataBase() {
        userRepository.deleteAll();
    }
}
