package com.nnk.springboot.services;

import com.nnk.springboot.domain.User;

import java.util.List;

public interface IUserService {

    public List<User> findAll();

    public User add(User user);

    public User update(User user);

    public User getById(Integer id);

    public void delete(User user);

    User getByUsername(String username);
}
