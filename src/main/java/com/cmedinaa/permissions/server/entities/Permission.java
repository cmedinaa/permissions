package com.cmedinaa.permissions.server.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "permission", schema = "auth")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 9)
    @Column(nullable = false, length = 12)
    private String code;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
