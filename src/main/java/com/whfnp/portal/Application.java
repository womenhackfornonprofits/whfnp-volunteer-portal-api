package com.whfnp.portal;

import com.whfnp.portal.dao.RoleRepository;
import com.whfnp.portal.dao.SkillRepository;
import com.whfnp.portal.dao.StatusRepository;
import com.whfnp.portal.dao.UserRepository;
import com.whfnp.portal.model.Role;
import com.whfnp.portal.model.Skill;
import com.whfnp.portal.model.Status;
import com.whfnp.portal.model.User;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dionne on 16/01/2016.
 */
@SpringBootApplication
public class Application{

    private static final Logger log =LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){ SpringApplication.run(Application.class); }

    @Bean
    public CommandLineRunner demo1(UserRepository userRepository, RoleRepository roleRepository,
                                   StatusRepository statusRepository,
                                   SkillRepository skillRepository) {
        return (args) -> {

            //create some statuses in the database
            Status status1 = new Status("AVAILABLE");
            Status status2 = new Status("UNAVAILABLE");
            Status status3 = new Status("ACTIVE");
            Status status4 = new Status("DISABLED");
            statusRepository.save(status1);
            statusRepository.save(status2);
            statusRepository.save(status3);
            statusRepository.save(status4);

            //create some skills in the database
            Skill skill1 = new Skill("Java", "Java Programming","3");
            Skill skill2 = new Skill("MySQL", "MySQL Database Development","3");
            Skill skill3 = new Skill("Redis", "Redis Configuration","3");

            skillRepository.save(skill1);
            skillRepository.save(skill2);
            skillRepository.save(skill3);



            //create some role in the database
            Role role1= new Role("user");
            Role role2 = new Role("admin");
            roleRepository.save(role1);
            roleRepository.save(role2);

            Set<Role> userRoles = new HashSet();
            userRoles.add(roleRepository.findByRoleName("user"));

            //save a few users
            User user1 = new User("Dee", "Condor","dee@dcfhosting.co.uk","01234567890","volunteer");
            user1.setStatus(statusRepository.findByStatusName("AVAILABLE"));
            Set<Skill> userSkills1 = new HashSet<Skill>();
            userSkills1.add(skillRepository.findBySkill("Java"));
            user1.setUserSkills(userSkills1);

            user1.setUserRoles(userRoles);
            userRepository.save(user1);// Save the user role

            User user2 = new User("Fatricia", "Farrell","Fatricia@dcfhosting.co.uk","01345678902","volunteer");
            user2.setStatus(statusRepository.findByStatusName("AVAILABLE"));
            Set<Skill> userSkills2 = new HashSet<Skill>();
            userSkills2.add(skillRepository.findBySkill("Java"));
            user1.setUserSkills(userSkills2);


            user2.setUserRoles(userRoles);
            userRepository.save(user2);

            User user3 = new User("Elaine", "Farrell","elaine@dcfhosting.co.uk","01456789023","volunteer");
            user3.setStatus(statusRepository.findByStatusName("AVAILABLE"));

            Set<Skill> userSkills3 = new HashSet<Skill>();
            userSkills3.add(skillRepository.findBySkill("MySQL"));
            user1.setUserSkills(userSkills3);

            user3.setUserRoles(userRoles);
            userRepository.save(user3);

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
