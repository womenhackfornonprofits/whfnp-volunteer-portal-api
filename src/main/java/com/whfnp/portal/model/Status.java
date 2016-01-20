package com.whfnp.portal.model;

import javax.persistence.*;

/**
 * Created by Dionne on 18/01/2016.
 */
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="STATUS_NAME")
    private String statusName;

    protected Status(){

    }

    public Status(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }


}
