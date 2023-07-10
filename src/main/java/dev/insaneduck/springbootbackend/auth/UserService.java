package dev.insaneduck.springbootbackend.auth;

import dev.insaneduck.springbootbackend.auth.entities.User;
import dev.insaneduck.springbootbackend.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserDTO findByLogin(String login)
    {
        try{
            User user = userRepository.findByUserName(login);
            return userMapper.toUserDto(user);
        } catch (RuntimeException runtimeException)
        {
            throw new AppException("Unknown user", HttpStatus.NOT_FOUND);
        }

    }
}
