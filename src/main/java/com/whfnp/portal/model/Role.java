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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
