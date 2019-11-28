package com.glp.utils;

import lombok.AllArgsConstructor;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author zmm
 * @date 2019/11/11
 */

@AllArgsConstructor
@Service
public class StartNodeTaskOnCreateListener implements TaskListener ,Serializable {
    @Override
    public void notify(DelegateTask delegateTask) {

    }
}
