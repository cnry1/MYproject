package com.glp.bussiness;

import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.Oneway;

/**
 * @author zmm
 * @date 2019/11/9
 */

@Component
public class ActivityLogic {

    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;
    @Autowired
    HistoryService historyService;
    @Autowired
    IdentityService identityService;
    @Autowired
    RepositoryService repositoryService;

    public  void  submit(){
        ProcessInstance demo1 = runtimeService.startProcessInstanceByKey("myProcess");
        repositoryService.addCandidateStarterGroup("manger","liming");

        taskService.addCandidateGroup("manger","liming");
        taskService.addCandidateUser("sss","ssss");
    }

}
