package com.whfnp.portal.dao;

import com.whfnp.portal.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dionne on 19/01/2016.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
     Role findByRoleName(String roleName);
}
