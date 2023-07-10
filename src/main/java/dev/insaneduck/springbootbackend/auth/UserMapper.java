package dev.insaneduck.springbootbackend.auth;

import dev.insaneduck.springbootbackend.auth.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDto(User user);
}
