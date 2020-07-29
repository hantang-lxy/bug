package com.bugmanager.service.impl;

import com.bugmanager.dao.BugMapper;
import com.bugmanager.entity.BugDetail;
import com.bugmanager.entity.BugProject;
import com.bugmanager.service.BugService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 李雪阳
 * @version 1.0
 * @date 2020/7/22  23:25
 */
@Service
public class BugServiceImpl implements BugService {
    @Autowired
    private BugMapper bugMapper;
    private Logger logger = Logger.getLogger(BugServiceImpl.class);

    /**
     * 获取bug列表
     *
     * @return
     */
    @Override
    public List<BugDetail> getBugList(Integer projectId) {
        List<BugDetail> details = bugMapper.selectBugList(projectId);
        for (BugDetail detail : details) {
            logger.info("bug标题：" + detail.getTitle());
        }

        return details;
    }

    /**
     * 添加一条bug
     *
     * @param detail
     * @return int
     */
    @Override
    public int addBugDetail(BugDetail detail) {
        int count = bugMapper.insertBugDetail(detail);
        logger.info("添加bug结果：" + count);
        return count;
    }

    /**
     * 获取项目列表
     *
     * @return List<BugProject>
     */
    @Override
    public List<BugProject> getBugProjectList() {
        return bugMapper.selectBugProjectList();
    }
}
