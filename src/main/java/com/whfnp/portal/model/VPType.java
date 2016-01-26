package com.whfnp.portal.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dionne on 06/01/2016.
 */

@Entity
public class VPType {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @ManyToOne(optional=false)
    @JoinColumn(name="USER_ID")
    private User user;

    @Column(name="FIELD_NAME",nullable = false)
    private String fieldName;

    @Column(name="FIELD_VALUE", nullable = true)
    private String fieldValue;

    protected VPType() {}

    public VPType(String fieldName, String fieldValue){
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    @Override
    public String toString() {
        return "VPType{" +
                "id=" + id +
                ", user=" + user +
                ", fieldName='" + fieldName + '\'' +
                ", fieldValue='" + fieldValue + '\'' +
                '}';
    }
}
