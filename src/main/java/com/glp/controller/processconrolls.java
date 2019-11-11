package com.glp.controller;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zmm
 * @date 2019/11/8
 */
public class processconrolls {

    @Autowired
    RuntimeService runtimeService;
    @Autowired
    RepositoryService repositoryService;
    public static void main(String[] args) {


    }


}
