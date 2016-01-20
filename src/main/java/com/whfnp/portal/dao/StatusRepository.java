package com.whfnp.portal.dao;

import com.whfnp.portal.model.Status;

/**
 * Created by Dionne on 20/01/2016.
 */
public interface StatusRepository {

    public Status findByStatusName(String statusName);

}
