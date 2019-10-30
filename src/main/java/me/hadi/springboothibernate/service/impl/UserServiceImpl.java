package me.hadi.springboothibernate.service.impl;

import me.hadi.springboothibernate.controller.model.UserDto;
import me.hadi.springboothibernate.entity.Address;
import me.hadi.springboothibernate.entity.User;
import me.hadi.springboothibernate.repository.UserRepository;
import me.hadi.springboothibernate.service.AddressRepository;
import me.hadi.springboothibernate.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private AddressRepository addressRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void save(UserDto user) {
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);

        Address address = new Address();
        address.setTitle(user.getAddress().getTitle());
        user1.setAddress(address);
        userRepository.save(user1);

        address.setUser(user1);
        addressRepository.save(address);

    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(findById(id));
    }
}
