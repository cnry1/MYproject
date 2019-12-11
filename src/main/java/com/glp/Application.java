package com.glp;

import com.glp.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


/**
 * @author zmm
 * @date 2019/10/30
 */
@Slf4j

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = "com.glp")
@Import(SpringUtils.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        log.info("服务启动。。。。");
    }
}
