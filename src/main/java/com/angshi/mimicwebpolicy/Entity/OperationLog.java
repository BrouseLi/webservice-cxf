package com.angshi.mimicwebpolicy.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OperationLog {
    private String srcUserType;
    private String srcUserCert;
    private String srcUserName;
    private String srcAddress;
    private String srcUserUintId;
    private String srcUserUnit;
    private Enum catBehavior;
    private String destAddress;
    private String catOutCome;
}
