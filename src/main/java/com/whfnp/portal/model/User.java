package com.whfnp.portal.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Dionne on 06/01/2016.
 */
@Entity(name="USER")
public class User {

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

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
    //private Date dateCreated;

    @Column(name="TYPE")
    private String type;

    @OneToMany(mappedBy="user")
    private List<VPType> vpTypes;

    @OneToMany(mappedBy="nonProfit")
    private Set<Project> projectsSubmitted;

    @OneToMany(mappedBy="approvedBy")
    private Set<Project> projectsApproved;

    @OneToMany(mappedBy="user")
    private Set<ProjectVolunteer> userProjects;

    /*@ManyToMany(mappedBy = "projectVolunteers")
    private Set<Project> userProjects;*/

    @ManyToMany
    @JoinTable(name="VOLUNTEERSKILL", joinColumns = {
            @JoinColumn(name="USER_ID", nullable = false)},
    inverseJoinColumns = {@JoinColumn(name="SKILL_ID", nullable = false)})
    private Set<Skill> userSkills;


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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", role=" + role +
                ", type='" + type + '\''+
                '}';
    }
}
