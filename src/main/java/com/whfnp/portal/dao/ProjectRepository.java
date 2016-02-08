package com.whfnp.portal.dao;

import com.whfnp.portal.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dionne on 20/01/2016.
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

    public Project findByProjectName(String projectName);

}
