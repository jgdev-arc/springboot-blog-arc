package com.arc.springbootblogarc.service.implementation;

import com.arc.springbootblogarc.dto.RegistrationDTO;
import com.arc.springbootblogarc.entity.Role;
import com.arc.springbootblogarc.entity.User;
import com.arc.springbootblogarc.repository.RoleRepository;
import com.arc.springbootblogarc.repository.UserRepository;
import com.arc.springbootblogarc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDTO registrationDTO) {
        User user = new User();
        user.setName(registrationDTO.getFirstName() + " " + registrationDTO.getLastName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        Role role = roleRepository.findByName("ROLE_GUEST");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
