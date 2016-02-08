package com.whfnp.portal.service;

import com.whfnp.portal.model.User;
import com.whfnp.portal.model.VPType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Dionne on 27/01/2016.
 */
@Service
public interface ProfileService {

    public User registerProfile(User userInput);
    public Iterable<User> getProfiles(String type);
    public User getProfile(long id);

}
