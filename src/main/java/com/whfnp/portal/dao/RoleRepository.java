package com.whfnp.portal.dao;

import com.whfnp.portal.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dionne on 19/01/2016.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
     Role findByRoleName(String roleName);
}
