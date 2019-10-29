package me.hadi.springboothibernate.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.io.Serializable;

@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {


    @CreatedDate
    private Long createdAt;

    @LastModifiedDate
    private Long updatedAt;
}