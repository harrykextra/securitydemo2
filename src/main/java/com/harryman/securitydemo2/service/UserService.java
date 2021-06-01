package com.harryman.securitydemo2.service;

import com.harryman.securitydemo2.data.UserDto;
import com.harryman.securitydemo2.data.exception.RegistrationException;
import com.harryman.securitydemo2.data.model.user.User;

public interface UserService {
    void register(UserDto userDto) throws RegistrationException;
//    void saveUser(User user);
//    void updateUser(User user);
//    User findUserById(Integer id);
}
