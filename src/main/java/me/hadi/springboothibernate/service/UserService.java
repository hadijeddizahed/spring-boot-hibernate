package me.hadi.springboothibernate.service;

import me.hadi.springboothibernate.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findById(Long id);

    List<User> findAll();

    void delete(Long id);

}
