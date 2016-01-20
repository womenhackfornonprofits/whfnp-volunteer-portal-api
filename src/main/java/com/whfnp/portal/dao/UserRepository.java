package com.whfnp.portal.dao;

import com.whfnp.portal.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dionne on 18/01/2016.
 */public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);
}
