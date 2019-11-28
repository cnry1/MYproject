package com.glp.utils;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author zmm
 * @date 2019/11/11
 */
@Service("wfStartNodeTaskOnCreateListener")
public class WfStartNodeTaskOnCreateListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {

    }
}
