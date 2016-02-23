package com.whfnp.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dionne on 06/01/2016.
 */
@Entity(name="USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name="TELEPHONE_NUMBER")
    private String telephoneNumber;

    @Column(name="TYPE")
    private String type;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name="STATUS_ID")
    private Status status;

    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    private Set<VPType> vptypes;

    @OneToMany(mappedBy="nonProfit")
    private Set<Project> projectsSubmitted;

    @OneToMany(mappedBy="approvedBy")
    private Set<Project> projectsApproved;

    @OneToMany(mappedBy="user")
    private Set<ProjectVolunteer> userProjects;

    @ManyToMany
    @JoinTable(name="USER_ROLE", joinColumns = {
            @JoinColumn(name="USER_ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID")})
    private Set<Role> userRoles = new HashSet<Role>();

    @ManyToMany
    @JoinTable(name="VOLUNTEER_SKILL", joinColumns = {
            @JoinColumn(name="USER_ID")},
    inverseJoinColumns = {@JoinColumn(name="SKILL_ID")})
    private Set<Skill> userSkills = new HashSet<Skill>();


    protected User(){}

    public User(String firstName, String lastName, String emailAddress,  String telephoneNumber, String type){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.telephoneNumber = telephoneNumber;
        this.type = type;
    }

    public long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUserRoles(Set<Role> userRoles){

        this.userRoles = userRoles;

    }

    public Set<Role> getUserRoles(){
        return userRoles;
    }

    public Set<VPType> getVptypes() {
        return vptypes;
    }


    public void setVptypes(Set<VPType> vptypes) {

        for (VPType vptype : vptypes) {
            vptype.setUser(this);
        }
        this.vptypes = vptypes;
    }

    public Set<Project> getProjectsSubmitted() {
        return projectsSubmitted;
    }

    public void setProjectsSubmitted(Set<Project> projectsSubmitted) {
        this.projectsSubmitted = projectsSubmitted;
    }

    public Set<Project> getProjectsApproved() {
        return projectsApproved;
    }

    public void setProjectsApproved(Set<Project> projectsApproved) {
        this.projectsApproved = projectsApproved;
    }

    public Set<ProjectVolunteer> getUserProjects() {
        return userProjects;
    }

    public void setUserProjects(Set<ProjectVolunteer> userProjects) {
        this.userProjects = userProjects;
    }

    public Set<Skill> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(Set<Skill> userSkills) {
        this.userSkills = userSkills;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", type='" + type + '\''+
                '}';
    }

}
