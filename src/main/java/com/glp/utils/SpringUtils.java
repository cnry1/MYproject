package com.glp.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zmm
 * @date 2019/11/11
 */
@Component
public class SpringUtils implements ApplicationContextAware {


        /**
         * 当前IOC
         */
        private static ApplicationContext applicationContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
        }

        /**
         * 输出当前容器中所有被装配的类的id/bean名称
         */
        public static void showClass(){
            String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
            for(String beanDefinitionName : beanDefinitionNames){
                System.out.println(beanDefinitionName);
            }
        }
    }

