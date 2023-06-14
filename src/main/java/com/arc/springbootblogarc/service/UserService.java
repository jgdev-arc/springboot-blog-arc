package com.arc.springbootblogarc.service;

import com.arc.springbootblogarc.dto.RegistrationDTO;
import com.arc.springbootblogarc.entity.User;

public interface UserService {
    void saveUser(RegistrationDTO registrationDTO);

    User findByEmail(String email);
}
