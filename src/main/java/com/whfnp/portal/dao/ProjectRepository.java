package com.whfnp.portal.dao;

import com.whfnp.portal.model.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dionne on 20/01/2016.
 */
public interface ProjectRepository extends CrudRepository<Project, Long>{

    public Project findByProjectName(String projectName);

}
