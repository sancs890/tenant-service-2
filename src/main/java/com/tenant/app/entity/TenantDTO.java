package com.tenant.app.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TenantDTO {

    private String email;

    private String orgName;

    private String firstName;

    private String lastName;

    private String instanceName;

}