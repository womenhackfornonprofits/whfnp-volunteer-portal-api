package com.whfnp.portal.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dionne on 18/01/2016.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="ROLE_NAME")
    private String roleName;

    @OneToMany(mappedBy="role")
    private Set<User> user;

    protected Role(){}

    public Role(String roleName){
        this.roleName = roleName;
    }
}
