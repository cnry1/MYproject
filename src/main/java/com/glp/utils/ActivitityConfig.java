package com.glp.utils;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.*;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.xml.ws.WebEndpoint;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * @author zmm
 * @date 2019/11/1
 */
@Slf4j
@Configuration
public class ActivitityConfig {


//    @Bean("startNodeTaskOnCreateListener")
//    public TaskListener getTaskListenner(){
//
//        return new TaskListener() {
//            @Override
//            public void notify(DelegateTask delegateTask) {
//
//            }
//        };
//    }
    @Bean
    public ProcessEngine intidataBase() {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();
        //连接数据库的配置
        //配置数据库驱动:对应不同数据库类型的驱动
        processEngineConfiguration.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        //配置数据库的JDBC URL
        processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/activity?useSSL=false&serverTimezone=UTC");
        //配置连接数据库的用户名
        processEngineConfiguration.setJdbcUsername("root");
        //配置连接数据库的密码
        processEngineConfiguration.setJdbcPassword("root");
        /**
         public static final String DB_SCHEMA_UPDATE_FALSE = "false";不能自动创建表，需要表存在
         public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";先删除表再创建表
         public static final String DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
         */
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        //工作流的核心对象，ProcessEnginee对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        try {
            //  第一步 部署流程
            Deployment deployment = processEngine.getRepositoryService()//获取流程定义和部署对象相关的Service
                    .createDeployment()//创建部署对象
                    .name("Panbb")//声明流程的名称
                    //.addZipInputStream(new ZipInputStream(this.getClass().getClassLoader().getResourceAsStream("processes/creditApply.zip")))
                    .addClasspathResource(  new String("processes/PlanB.bpmn".getBytes("utf-8") ) )  //加载资源文件，一次只能加载一个文件
                    .deploy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return processEngine;

    }





}
