package com.whfnp.portal.dao;

import com.whfnp.portal.model.VPType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dionne on 20/01/2016.
 */
public interface VPTypeRepository extends CrudRepository<VPType, Long> {

    public VPType findByFieldNameAndUser(String fieldName, long userId);
}
