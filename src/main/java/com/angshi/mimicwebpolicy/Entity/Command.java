package com.angshi.mimicwebpolicy.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Command {
    private Operation operation;
    private String code;
    private String version;
    private String mode;
    private String id;
    private String description;
}
