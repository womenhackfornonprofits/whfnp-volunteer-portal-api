package com.whfnp.portal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dionne on 18/01/2016.
 */
@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="PROJECT_NAME")
    private String projectName;

    @ManyToOne(optional=false)
    @JoinColumn(name="non_profit_id")
    private User nonProfit;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="NO_OF_VOLUNTEERS_REQ")
    private long noVolunteersRequired;

    @Column(name="TECHNOLOGY_STACK")
    private String technologyStack;

    @Column(name="START_DATE")
    private Date startDate;

    @Column(name="DEADLINE")
    private Date deadline;

    @ManyToOne(optional=true)
    @JoinColumn(name="APPROVED_BY")
    private User approvedBy;

    @Column(name="DATE_APPROVED")
    private Date dateApproved;

    @ManyToOne(optional=false)
    @JoinColumn(name="STATUS_ID")
    private Status status;

    @ManyToMany
    @JoinTable(name="PROJECT_SKILL", joinColumns = {
            @JoinColumn(name="PROJECT_ID", nullable = false)},inverseJoinColumns = {@JoinColumn(name="SKILL_ID", nullable = false)})
    private Set<Skill> requiredProjectSkills = new HashSet<Skill>(0);

    @OneToMany(mappedBy="project")
    private Set<ProjectVolunteer> projectVolunteers;

    /*@ManyToMany
    @JoinTable(name="PROJECT_VOLUNTEER", joinColumns = {
            @JoinColumn(name="PROJECT_ID", nullable=false)},
    inverseJoinColumns = {@JoinColumn(name="USER_ID", nullable=false)})
    private Set<User> projectVolunteers = new HashSet<User>(0);*/

    protected Project(){

    }

    public Project(String projectName, String description,
                   long noVolunteersRequired, String technologyStack,
                   Date startDate, Date deadline) {
        this.projectName = projectName;
        this.description = description;
        this.noVolunteersRequired = noVolunteersRequired;
        this.technologyStack = technologyStack;
        this.startDate = startDate;
        this.deadline = deadline;
    }
}
