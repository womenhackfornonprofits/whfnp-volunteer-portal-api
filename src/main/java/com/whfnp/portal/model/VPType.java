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

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="FIELD_NAME")
    private String fieldName;

    @Column(name="FIELD_VALUE")
    private String fieldValue;

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

}
