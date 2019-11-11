package com.glp;

import com.glp.utils.ActivitityConfig;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author zmm
 * @date 2019/10/30
 */
@Slf4j

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
        ActivitityConfig configs= new ActivitityConfig();

        //  初始花流程定义
        ProcessEngine processEngine = configs.intidataBase();

        ProcessInstance demo1 = processEngine.getRuntimeService().startProcessInstanceByKey("myProcess");


        log.info("服务启动。。。。");
    }
}
