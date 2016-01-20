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

    @Column(name="NON_PROFIT_ID")
    private long nonProfitId;

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

    @Column(name="APPROVED_BY")
    private String approvedBy;

    @Column(name="DATE_APPROVED")
    private Date dateApproved;

    @Column(name="STATUS")
    private String status;

    @ManyToMany
    @JoinTable(name="project_volunteers", joinColumns = {
            @JoinColumn(name="project_id", nullable=false)},
    inverseJoinColumns = {@JoinColumn(name="user_id", nullable=false)})
    private Set<User> users = new HashSet<User>(0);

    protected Project(){

    }

    public Project(String projectName, long nonProfitId, String description,
                   long noVolunteersRequired, String technologyStack,
                   Date startDate, Date deadline, String approvedBy,
                   Date dateApproved, String status) {
        this.projectName = projectName;
        this.nonProfitId = nonProfitId;
        this.description = description;
        this.noVolunteersRequired = noVolunteersRequired;
        this.technologyStack = technologyStack;
        this.startDate = startDate;
        this.deadline = deadline;
        this.approvedBy = approvedBy;
        this.dateApproved = dateApproved;
        this.status = status;
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

    public long getNonProfitId() {
        return nonProfitId;
    }

    public void setNonProfitId(long nonProfitId) {
        this.nonProfitId = nonProfitId;
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

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", nonProfitId=" + nonProfitId +
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
