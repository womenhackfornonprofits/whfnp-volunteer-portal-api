package com.whfnp.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dionne on 06/01/2016.
 */

@Entity
@Data
public class VPType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @Column(name="FIELD_NAME")
    private String fieldName;

    @Column(name="FIELD_VALUE")
    private String fieldValue;

    protected VPType() {}

    public VPType(String fieldName, String fieldValue){
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}

