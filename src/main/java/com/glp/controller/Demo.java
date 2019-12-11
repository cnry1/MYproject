package com.glp.controller;

import com.glp.bussiness.ActivityLogic;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zmm
 * @date 2019/11/9
 */

@RestController

public class Demo {
    @Autowired
    ActivityLogic activityLogic;

    //    @Autowired
//    RuntimeService runtimeService;
    @RequestMapping(path = "/test1", method = RequestMethod.GET)
    public void test1() {

 activityLogic.submit();
    }
}
