package com.whfnp.portal.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dionne on 25/01/2016.
 */
@Entity
@IdClass(ProjectVolunteerId.class)
public @Data class ProjectVolunteer implements Serializable {

    @EmbeddedId
    private ProjectVolunteerId id = new ProjectVolunteerId();

    @Column(name="user_id")
    private User user;

    @Column(name="project_id")
    private Project project;

    @Column(name="role_on_project", nullable=true)
    private long roleOnProject;

    @ManyToOne(optional=true)
    @JoinColumn(name="status", nullable=true)
    private Status status;

}

@Embeddable
class ProjectVolunteerId implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(optional=false)
    private User user;

    @ManyToOne(optional=false)
    private Project project;

}


