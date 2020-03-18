package com.angshi.mimicwebpolicy.Entity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Soft {
    private List<String> code;
    private String id;
    private String version;

}
