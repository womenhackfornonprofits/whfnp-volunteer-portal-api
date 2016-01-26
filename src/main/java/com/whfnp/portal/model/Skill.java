package com.whfnp.portal.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dionne on 18/01/2016.
 */
@Entity
public class Skill {

    @Id
    @GeneratedValue
    @Column(name="ID")
    private long id;

    @Column(name="PROJECT_ID")
    private long projectId;

    @Column(name="USER_ID")
    private long user_id;

    @Column(name="SKILL")
    private String skill;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="LEVEL")
    private String level;

    @ManyToMany(mappedBy="requiredProjectSkills")
    private Set<Project> projectsUsingSkill;

    @ManyToMany(mappedBy="userSkills")
    private Set<User> usersWithSkill;




    protected Skill(){

    }

    public Skill(long projectId, long user_id, String skill, String description, String level) {
        this.projectId = projectId;
        this.user_id = user_id;
        this.skill = skill;
        this.description = description;
        this.level = level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
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
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
