package com.angshi.mimicwebpolicy.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operation {

    private String type;

    private Integer delay;

    private String  reason;
}
