package com.whfnp.portal.service;

import com.whfnp.portal.dao.RoleRepository;
import com.whfnp.portal.dao.UserRepository;
import com.whfnp.portal.dao.VPTypeRepository;
import com.whfnp.portal.model.Role;
import com.whfnp.portal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dionne on 27/01/2016.
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User registerProfile(User userInput) {

        //check if roles have been selected for the user
        if(userInput.getUserRoles().isEmpty()){
            //assign a default role
            Set<Role> userRoles = new HashSet<Role>();
            userRoles.add(roleRepository.findByRoleName("user"));
            userInput.setUserRoles(userRoles);
        }

        //save the user profile details
        userRepository.save(userInput);

        return userRepository.findOne(userInput.getId());
    }
    @Override
    public Iterable<User> getProfiles(String type) {
        return userRepository.findByType(type);
    }

    @Override
    public User getProfile(long id) {
        return null;
    }
}
