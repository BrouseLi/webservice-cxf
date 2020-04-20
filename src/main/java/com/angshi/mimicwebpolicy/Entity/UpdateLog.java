package com.angshi.mimicwebpolicy.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class UpdateLog {
    private String srcUserType;
    private String srcUserCert;
    private String srcUserName;
    private String srcAddress;
    private String srcUserUintId;
    private String srcUserUnit;
    private String catBehavior;
    private String upGradeType;
    private String upGradeName;
    private String upGradeVersion;
    private String upgradeLevelId;
    private String destAddress;
    private String catOutCome;
}
