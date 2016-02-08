package com.whfnp.portal.dao;

import com.whfnp.portal.model.VPType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dionne on 20/01/2016.
 */
@Repository
public interface VPTypeRepository extends CrudRepository<VPType, Long> {

    public VPType findByFieldNameAndUser(String fieldName, long userId);
}
