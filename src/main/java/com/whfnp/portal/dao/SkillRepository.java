package com.whfnp.portal.dao;

import com.whfnp.portal.model.Skill;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dionne on 20/01/2016.
 */
public interface SkillRepository extends CrudRepository<Skill, Long> {

    public Skill findBySkillName(String skillName);

}
