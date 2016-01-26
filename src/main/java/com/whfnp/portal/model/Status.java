package com.whfnp.portal.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dionne on 18/01/2016.
 */
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="STATUS_NAME")
    private String statusName;

    @OneToMany(mappedBy="status")
    private Set<Project> projects;

    @OneToMany(mappedBy="status")
    private Set<ProjectVolunteer> projectVolunteers;

    protected Status(){

    }

    public Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }


}
