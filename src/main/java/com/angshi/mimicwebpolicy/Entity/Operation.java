package com.angshi.mimicwebpolicy.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Operation {

    private String type;

    private Integer delay;

    private String  reason;
}
