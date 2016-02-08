package com.whfnp.portal.api;

import com.whfnp.portal.dao.RoleRepository;
import com.whfnp.portal.dao.SkillRepository;
import com.whfnp.portal.dao.StatusRepository;
import com.whfnp.portal.dao.UserRepository;
import com.whfnp.portal.model.Role;
import com.whfnp.portal.model.Skill;
import com.whfnp.portal.model.Status;
import com.whfnp.portal.model.User;
import com.whfnp.portal.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Dionne on 28/01/2016.
 */
@RestController
@RequestMapping(value="/api")
public class ProfileAPI {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping(value="/register/{type}",method=RequestMethod.POST, headers={"Content-type=application/json"})
    @ResponseBody
    public User registerProfile(@PathVariable("type") String String, @RequestBody User profile){
        return profileService.registerProfile(profile);
    }

    @RequestMapping(value="/profiles/{type}",method=RequestMethod.GET, headers={"Content-type=application/json"})
    @ResponseBody
    public Iterable<User> getAllProfilesByType(@PathVariable("type") String type){
        return profileService.getProfiles(type);
    }

    @RequestMapping(value="/statuses", method=RequestMethod.GET, headers={"Content-type=application/json"})
    @ResponseBody
    public Iterable<Status> getAllStatuses(){
        return statusRepository.findAll();
    }

    @RequestMapping(value="/roles", method=RequestMethod.GET, headers={"Content-type=application/json"})
    @ResponseBody
    public Iterable<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    @RequestMapping(value="/skills", method=RequestMethod.GET, headers={"Content-type=application/json"})
    @ResponseBody
    public Iterable<Skill> getAllSkills(){
        return skillRepository.findAll();
    }


}
