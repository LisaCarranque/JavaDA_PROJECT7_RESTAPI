package com.nnk.springboot.services;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class is responsible for managing User data by calling UserRepository methods
 */
@Service
@Log4j2
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    /**
     * This method displays all users by calling findAll method from UserRepository
     *
     * @return a list of all users existing in database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<User> findAll() {
        log.info("Find all users");
        return userRepository.findAll();
    }

    /**
     * This method adds a user by calling save method from UserRepository
     *
     * @param user the user to add
     * @return the new user saved into database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User add(User user) {
        log.info("Add a user");
        return userRepository.save(user);
    }

    /**
     * This method updates a user by calling save method from UserRepository
     *
     * @param user the user to update
     * @return the updated user
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User update(User user) {
        log.info("Update a user");
        return userRepository.save(user);
    }

    /**
     * This method selects an existing user by id from database by calling getOne method of UserRepository
     *
     * @param id the id of the targeted user
     * @return the selected user from database
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public User getById(Integer id) {
        log.info("Get a user by id");
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    }

    /**
     * This method removes a user from database by calling delete method from UserRepository
     *
     * @param user the user to remove
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(User user) {
        log.info("Delete a user");
        userRepository.delete(user);
    }

    /**
     * This method gets a user from database by username by calling getByUsername method from UserRepository
     *
     * @param username the targeted username
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User getByUsername(String username) {
        log.info("Get user by username");
        return userRepository.getByUsername(username);
    }

/*    @Override
    public User checkPassword(String username, String password) {
        log.info("Check user password");
        return userRepository.checkPassword(username, password);
    }*/

    /**
     * This method is responsible for removing all trades from database
     */
    public void clearDataBase() {
        log.info("Clear database");
        userRepository.deleteAll();
    }
}
