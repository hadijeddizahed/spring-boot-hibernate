package me.hadi.springboothibernate.user;

import me.hadi.springboothibernate.controller.model.AddressDto;
import me.hadi.springboothibernate.controller.model.UserDto;
import me.hadi.springboothibernate.entity.User;
import me.hadi.springboothibernate.repository.UserRepository;
import me.hadi.springboothibernate.service.AddressRepository;
import me.hadi.springboothibernate.service.UserService;
import me.hadi.springboothibernate.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;


@SpringBootTest
public class UserServiceTest {


    @Mock
    private UserRepository userRepository;

    @Mock
    private AddressRepository addressRepository;

    private UserService userService;

    private UserDto userDto;
    private AddressDto addressDto;
    private User user;

    @BeforeEach
    public void init() {
        addressDto = new AddressDto();
        userDto = new UserDto("Ali", "Daie", "ali@gmail.com", addressDto);
        user = new User();
        BeanUtils.copyProperties(userDto, user);

        userService = new UserServiceImpl(userRepository, addressRepository);
        when(userRepository.save(user)).thenReturn(user);
    }


    @Test
    @DisplayName("save a new userDto")
    public void saveUser() {
        userService.save(userDto);
        Assertions.assertNotNull(userDto, "userDto saved in database!");
    }
}
