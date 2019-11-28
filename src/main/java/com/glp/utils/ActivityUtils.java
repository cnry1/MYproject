package com.glp.utils;

import com.alibaba.druid.util.StringUtils;
import org.activiti.bpmn.model.*;
import org.activiti.engine.*;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;

/**
 * @author zmm
 * @date 2019/11/2
 */

@Component
@Configuration
public class ActivityUtils {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private ProcessEngineConfiguration processEngineConfiguration;

    /**
     * 启动流程
     * @param bizId 业务id
     */
    public void startProcesses(String bizId) {

        Map<String,Object> map = new HashMap<>();
        map.put("isFirstCredit",0);
        map.put("isFirstCredit",0);
        map.put("approveStatus",0);
        map.put("isNeedCMC",0);
        map.put("procInstCreateUserRole","ROLE_COLLIE_BD");
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(bizId,map);//流程图id，业务表id

        System.out.println("流程启动成功，流程id:"+pi.getId());
    }

    /**
     *
     * <p>描述: 根据用户id查询待办任务列表</p>
     * @author 范相如
     * @date 2018年2月25日
     */
    public List<Task> findTasksByUserId(String userId) {
        List<Task> resultTask = taskService.createTaskQuery().processDefinitionKey("demo5").taskCandidateOrAssigned(userId).list();
        return resultTask;
    }

    /**
     *
     * <p>描述:任务审批 	（通过/拒接） </p>
     * @author 范相如
     * @date 2018年2月25日
     * @param taskId 任务id
     * @param userId 用户id
     * @param result false OR true
     */
    public void completeTask(String taskId,String userId,String result) {
        //获取流程实例
        taskService.claim(taskId, userId);

        Map<String,Object> vars = new HashMap<String,Object>();
        vars.put("sign", "true");
        taskService.complete(taskId, vars);
    }

    /**
     * 更改业务流程状态#{ActivityDemoServiceImpl.updateBizStatus(execution,"tj")}
     * @param execution
     * @param status
     */
    public void updateBizStatus(DelegateExecution execution, String status) {
        String bizId = execution.getProcessInstanceBusinessKey();
        //根据业务id自行处理业务表
        System.out.println("业务表["+bizId+"]状态更改成功，状态更改为："+status);
    }


    //流程节点权限用户列表${ActivityDemoServiceImpl.findUsers(execution,sign)}
    public List<String> findUsersForSL(DelegateExecution execution){
        return Arrays.asList("sly1","sly2");
    }

    //流程节点权限用户列表${ActivityDemoServiceImpl.findUsers(execution,sign)}
    public List<String> findUsersForSP(DelegateExecution execution){
        return Arrays.asList("spy1","uspy2");
    }

    /**
     *
     * <p>描述:  生成流程图
     * 首先启动流程，获取processInstanceId，替换即可生成</p>
     * @author 范相如
     * @date 2018年2月25日
     * @param processInstanceId
     * @throws Exception
     */
    public void queryProImg(String processInstanceId) throws Exception {
        //获取历史流程实例
        HistoricProcessInstance processInstance =  historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

        //根据流程定义获取输入流
        InputStream is = repositoryService.getProcessDiagram(processInstance.getProcessDefinitionId());
        BufferedImage bi = ImageIO.read(is);
        File file = new File("demo2.png");
        if(!file.exists()) file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        ImageIO.write(bi, "png", fos);
        fos.close();
        is.close();
        System.out.println("图片生成成功");

        List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("userId").list();
        for(Task t : tasks) {
            System.out.println(t.getName());
        }
    }
  /* 创建用户任务
     * @param id  任务id
     * @param name 任务名称
     * @param assignee  任务所属人员
     * @return
             */
    public static UserTask CREATEUSERTASK(String id, String name, String assignee) {
        UserTask userTask = new UserTask();
        userTask.setName(name);
        userTask.setId(id);
        userTask.setAssignee(assignee);
        return userTask;
    }

    /**
     * 连接线
     * @param from 开始任务id
     * @param to  连接任务id
     * @return
     */
    public static SequenceFlow CREATESEQUEBCEFLOW(String from, String to, String name, String condition) {
        SequenceFlow flow = new SequenceFlow();
        flow.setSourceRef(from);
        flow.setTargetRef(to);
        flow.setName(name);

        if(!StringUtils.isEmpty(condition)){
            flow.setConditionExpression(condition);
        }
        return flow;
    }
    public static SequenceFlow CREATESEQUEBCEFLOW(String from, String to) {
        SequenceFlow flow = new SequenceFlow();
        flow.setSourceRef(from);
        flow.setTargetRef(to);
        return flow;
    }

    /**
     * 开始任务
     * @return
     */
    public static StartEvent CREATESTARTEVENT() {
        StartEvent startEvent = new StartEvent();
        startEvent.setId("start");
        return startEvent;
    }

    /**
     * 结束任务
     * @return
     */
    public static EndEvent CREATEENDEVENT() {
        EndEvent endEvent = new EndEvent();
        endEvent.setId("end");
        return endEvent;
    }

   // 删除流程 流程实例  联通关系的数据都删除
    public void deleteInstanceById( String Id ) {
        runtimeService.deleteProcessInstance(Id,"");
    }

    public void deleteProcInfoByKey(String s) {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition processDefinition : list) {
            repositoryService.deleteDeployment(processDefinition.getDeploymentId());
        }
    }
}






