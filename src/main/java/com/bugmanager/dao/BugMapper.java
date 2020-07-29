package com.bugmanager.dao;

import com.bugmanager.entity.BugDetail;
import com.bugmanager.entity.BugProject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李雪阳
 * @version 1.0
 * @date 2020/7/22  21:50
 */
public interface BugMapper {
    /**
     * 查询bug列表
     *
     * @param projectId
     * @return List<BugDetail>
     */
    List<BugDetail> selectBugList(@Param("projectId") Integer projectId);

    /**
     * 添加一条bug
     *
     * @param detail
     * @return int
     */
    int insertBugDetail(BugDetail detail);

    /**
     * 查询BUG项目列表
     *
     * @return List<BugProject>
     */
    List<BugProject> selectBugProjectList();

}
