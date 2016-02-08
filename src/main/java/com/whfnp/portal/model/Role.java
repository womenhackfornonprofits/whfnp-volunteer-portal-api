package com.whfnp.portal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dionne on 18/01/2016.
 */
@Entity
@Data
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="ROLE_NAME")
    private String roleName;

    @ManyToMany(mappedBy="userRoles",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<User> roleUsers = new HashSet<>();

    protected Role(){

    }

    public Role(String roleName){
        this.roleName = roleName;
    }

    /*public void setRoleUsers(Set<User> roleUsers){
        this.roleUsers = roleUsers;
    }*/



}
