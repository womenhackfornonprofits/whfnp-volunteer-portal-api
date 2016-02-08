package com.whfnp.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Dionne on 18/01/2016.
 */
@Entity
public class Status implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="STATUS_NAME")
    private String statusName;

    @OneToMany(mappedBy="status", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<User> users;

    @OneToMany(mappedBy="status")
    @JsonIgnore
    private Set<Project> projects;

    @OneToMany(mappedBy="status")
    @JsonIgnore
    private Set<ProjectVolunteer> projectVolunteers;

    protected Status(){

    }

    public Status(String statusName) {
        this.statusName = statusName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<ProjectVolunteer> getProjectVolunteers() {
        return projectVolunteers;
    }

    public void setProjectVolunteers(Set<ProjectVolunteer> projectVolunteers) {
        this.projectVolunteers = projectVolunteers;
    }
}
