package com.whfnp.portal.dao;

import com.whfnp.portal.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dionne on 20/01/2016.
 */
@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {

    public Status findByStatusName(String statusName);

}
