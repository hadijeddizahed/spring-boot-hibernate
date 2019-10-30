package me.hadi.springboothibernate.user;

import me.hadi.springboothibernate.entity.User;
import me.hadi.springboothibernate.repository.UserRepository;
import me.hadi.springboothibernate.service.UserService;
import me.hadi.springboothibernate.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;


@SpringBootTest
public class UserServiceTest {


    @Mock
    private UserRepository userRepository;

    private UserService userService;

    private User user;

    @BeforeEach
    public void init() {
        user = new User(1l, "Ali", "Daie", "ali@gmail.com");
        userService = new UserServiceImpl(userRepository);
        when(userRepository.save(user)).thenReturn(user);
    }


    @Test
    @DisplayName("save a new user")
    public void saveUser() {
        userService.save(user);
        Assertions.assertNotNull(user, "user saved in database!");
    }
}
