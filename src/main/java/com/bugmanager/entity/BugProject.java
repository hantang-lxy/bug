package com.bugmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author 李雪阳
 * @version 1.0
 * @date 2020/7/22  22:09
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BugProject implements Serializable {

    private static final long serialVersionUID = 8072491369315671368L;

    /***
     * 项目编号
     */
    private Integer id;
    /***
     * 项目名称
     */
    private String name;
    /**
     * 所选课程列表
     */
    private List<BugDetail> details;


}
