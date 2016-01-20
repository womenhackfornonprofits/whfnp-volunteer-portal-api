package com.whfnp.portal;

import com.whfnp.portal.dao.RoleRepository;
import com.whfnp.portal.dao.UserRepository;
import com.whfnp.portal.model.Role;
import com.whfnp.portal.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Dionne on 16/01/2016.
 */
@SpringBootApplication
public class Application{

    private static final Logger log =LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){ SpringApplication.run(Application.class); }

    @Bean
    public CommandLineRunner demo1(UserRepository userRepository, RoleRepository roleRepository) {
        return (args) -> {

            //save a few roles
            Role role1 = new Role("user");
            Role role2 = new Role("admin");
            roleRepository.save(role1);
            roleRepository.save(role2);

            //save a few users
            User user1 = new User("Dee", "Condor","dee@dcfhosting.co.uk","01234567890","volunteer");
            user1.setRole(roleRepository.findByRoleName("user"));
            userRepository.save(user1);

            User user2 = new User("Fatricia", "Farrell","Fatricia@dcfhosting.co.uk","01345678902","volunteer");
            user2.setRole(roleRepository.findByRoleName("user"));
            userRepository.save(user2);

            User user3 = new User("Elaine", "Farrell","elaine@dcfhosting.co.uk","01456789023","volunteer");
            user3.setRole(roleRepository.findByRoleName("user"));
            userRepository.save(user3);

            //Set role on user record by user.setRole(roleRepository.findByRoleName("user"))

            //fetch all users
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User user : userRepository.findAll()) {
                log.info(user.toString());
            }
            log.info("");
            //fetch an individual user by ID
            User user = userRepository.findOne(1L);
            log.info("Users found by findOne(1L):");
            log.info("-------------------------------");
            log.info(user.toString());
            log.info("");

            //fetch users by lastName
            log.info("Users found with findbyLastName('Farrell'):");
            log.info("-----------------------------------------------");
            for (User farrell : userRepository.findByLastName("Farrell")) {
                log.info(farrell.toString());
            }
            log.info("");
        };
    }
}
