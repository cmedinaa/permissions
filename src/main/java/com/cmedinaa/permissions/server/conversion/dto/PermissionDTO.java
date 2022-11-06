package com.cmedinaa.permissions.server.conversion.dto;

import javax.validation.constraints.Size;

public class PermissionDTO {
    private Long id;

    @Size(max = 9)
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
