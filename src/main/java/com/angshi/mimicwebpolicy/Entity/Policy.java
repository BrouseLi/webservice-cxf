package com.angshi.mimicwebpolicy.Entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Policy {
    private String name;
    private List<String> ip;
}
