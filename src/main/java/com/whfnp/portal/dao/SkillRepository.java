package com.whfnp.portal.dao;

import com.whfnp.portal.model.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by Dionne on 20/01/2016.
 */
@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {

    public Skill findBySkill(String skill);

}
