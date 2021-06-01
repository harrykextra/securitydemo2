package com.harryman.securitydemo2.service;

import com.harryman.securitydemo2.data.UserDto;
import com.harryman.securitydemo2.data.exception.RegistrationException;
import com.harryman.securitydemo2.data.model.user.User;
import com.harryman.securitydemo2.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void register(UserDto userDto) throws RegistrationException {

        User user = new User();

        checkForDuplicateValue(userDto);

        user.setFirstname(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);
    }

    public  void checkForDuplicateValue(UserDto userDto) throws RegistrationException{
        User user = userRepository.findByEmail(userDto.getEmail());
        if (user != null){
            throw new RegistrationException("The user with this email is already existing");
        }


    }

//    @Transactional(rollbackFor = Exception.class)
//    public String saveDto(UserDto userDto) {
//        userDto.setPassword(bCryptPasswordEncoder
//                .encode(userDto.getPassword()));
//        return save(new User(userDto)).getId();
//    }
}
