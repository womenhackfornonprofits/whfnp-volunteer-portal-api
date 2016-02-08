package com.whfnp.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dionne on 18/01/2016.
 */
@Entity
@Data
public class Skill {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private long id;

    @Column(name="SKILL")
    private String skill;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="PROFICIENCY_LEVEL")
    private String proficiencyLevel;

    @ManyToMany(mappedBy="requiredProjectSkills", fetch=FetchType.EAGER)
    @JsonIgnore
    private Set<Project> projectsUsingSkill;

    @ManyToMany(mappedBy="userSkills", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonIgnore
    private Set<User> usersWithSkill;

    protected Skill(){

    }

    public Skill(String skill, String description, String proficiencyLevel) {
        this.skill = skill;
        this.description = description;
        this.proficiencyLevel = proficiencyLevel;
    }
/*
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return proficiencyLevel;
    }

    public void setLevel(String level) {
        this.proficiencyLevel = proficiencyLevel;
    }*/
}
