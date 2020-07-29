package com.bugmanager.service;

import com.bugmanager.entity.BugDetail;
import com.bugmanager.entity.BugProject;

import java.util.List;

/**
 * @author 李雪阳
 * @version 1.0
 * @date 2020/7/28  13:32
 */
public interface BugService {
    /**
     * 获取bug列表
     *
     * @param projectId
     * @return List<BugDetail>
     */
    List<BugDetail> getBugList(Integer projectId);

    /**
     * 添加一条bug
     *
     * @param detail
     * @return int
     */
    int addBugDetail(BugDetail detail);

    /**
     * 获取项目列表
     *
     * @return List<BugProject>
     */
    List<BugProject> getBugProjectList();


}