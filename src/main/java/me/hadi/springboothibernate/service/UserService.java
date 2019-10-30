package me.hadi.springboothibernate.service;

import me.hadi.springboothibernate.controller.model.UserDto;
import me.hadi.springboothibernate.entity.User;

import java.util.List;

public interface UserService {

    void save(UserDto user);

    User findById(Long id);

    List<User> findAll();

    void delete(Long id);

}
