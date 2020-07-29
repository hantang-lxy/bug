package com.bugmanager.controller;

import com.alibaba.fastjson.JSON;
import com.bugmanager.entity.BugDetail;
import com.bugmanager.entity.BugProject;
import com.bugmanager.module.ErrorInfo;
import com.bugmanager.service.BugService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * @author 李雪阳
 * @version 1.0
 * @date 2020/7/22  23:36
 */
@Controller
@RequestMapping
public class BugController {
    @Autowired
    private BugService bugService;
    private Logger logger = Logger.getLogger(BugController.class);

    @GetMapping("getBugList")
    public ModelAndView getBugList(@RequestParam(required = false) Integer projectId) {
        ModelAndView view = new ModelAndView("buglist");
        List<BugDetail> bugList = bugService.getBugList(projectId);
        logger.info("bugList：" + JSON.toJSONString(bugList));
        List<BugProject> projectList = bugService.getBugProjectList();
        logger.info("projectList：" + JSON.toJSONString(projectList));
        view.addObject("projectId", projectId);
        view.addObject("projectList", projectList);
        view.addObject("bugList", bugList);
        //把枚举数据存进来带到前端
        view.addObject("errorList", ErrorInfo.values());
        return view;
    }

    @GetMapping("add.html")
    public String add(Model model) {
        List<BugProject> projectList = bugService.getBugProjectList();
        model.addAttribute("projectList", projectList);
        return "add";
    }

    @PostMapping("add.html")
    @ResponseBody
    public String addBugDetail(BugDetail detail) {
        Date date = new Date();
        detail.setCreateDate(date);
        int count = bugService.addBugDetail(detail);
        if (count > 0) {
            return "ok";
        }
        return "failed";

    }


}
