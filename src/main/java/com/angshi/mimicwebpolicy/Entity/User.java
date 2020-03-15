package com.angshi.mimicwebpolicy.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @Author Brouseli
 * @Date 2020年3月15日 14：20
 * @Description 测试实体
 * @Classname User
 */
@Getter
@Setter
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -3628469724795296287L;
    private String userId;
    private String userName;
    private String email;
}
