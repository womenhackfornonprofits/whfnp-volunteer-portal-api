package com.whfnp.portal.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dionne on 18/01/2016.
 */
@Entity
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public User getNonProfit() {
       return nonProfit;
    }

    public void setNonProfit(User nonProfitId) {
        this.nonProfit = nonProfitId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getNoVolunteersRequired() {
        return noVolunteersRequired;
    }

    public void setNoVolunteersRequired(long noVolunteersRequired) {
        this.noVolunteersRequired = noVolunteersRequired;
    }

    public String getTechnologyStack() {
        return technologyStack;
    }

    public void setTechnologyStack(String technologyStack) {
        this.technologyStack = technologyStack;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", noVolunteersRequired=" + noVolunteersRequired +
                ", technologyStack='" + technologyStack + '\'' +
                ", startDate=" + startDate +
                ", deadline=" + deadline +
                ", approvedBy='" + approvedBy + '\'' +
                ", dateApproved=" + dateApproved +
                ", status='" + status + '\'' +
                '}';
    }
}
