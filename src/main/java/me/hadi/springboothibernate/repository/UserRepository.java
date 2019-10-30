package me.hadi.springboothibernate.repository;

import me.hadi.springboothibernate.entity.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    User findById(Long id);

    List<User> findAll();

    User delete(User user);
}
