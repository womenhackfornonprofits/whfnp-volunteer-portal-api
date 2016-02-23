package com.whfnp.portal.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Dionne on 18/01/2016.
 */
@Entity
@Data
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


}
