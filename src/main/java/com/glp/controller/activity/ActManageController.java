package com.glp.controller.activity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author zmm
 * @date 2019/11/11
 */
@RestController
public class ActManageController {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private RepositoryService repositoryService;

    /**
     * stencilset：获取编辑器组件及配置项信息
     *
     * @return stencilset.json
     */
    @RequestMapping("/editor/stencilset")
    public String getStencilset() {
        InputStream stencilsetStream = this.getClass().getResourceAsStream("/static/stencilset.json");
        try {

            try {
                ByteArrayOutputStream boa = new ByteArrayOutputStream();
                int len = 0;
                byte[] buffer = new byte[1024];

                while ((len = stencilsetStream.read(buffer)) != -1) {
                    boa.write(buffer, 0, len);
                }
                stencilsetStream.close();
                boa.close();
                byte[] result = boa.toByteArray();

                String temp = new String(result);

//识别编码
                if (temp.contains("utf-8")) {
                    return new String(result, "utf-8");
                } else if (temp.contains("gb2312")) {
                    return new String(result, "gb2312");
                } else {
                    return new String(result, "utf-8");
                }


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }



        } catch (Exception e) {
            throw new ActivitiException("Error while loading stencil set", e);
        }
    }

    /**
     * 模型详情
     *
     * @param modelId
     * @return
     */
    @RequestMapping("/model/{modelId}/json")
    public ObjectNode getEditorJson(@PathVariable String modelId) {
        ObjectNode modelNode = null;

        Model model = repositoryService.getModel(modelId);

        if (model != null) {
            try {
                if (StringUtils.isEmpty(model.getMetaInfo())) {
                    modelNode = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
                } else {
                    modelNode = objectMapper.createObjectNode();
                    modelNode.put("name", model.getName());
                }
                modelNode.put("modelId", model.getId());
                ObjectNode editorJsonNode = (ObjectNode) objectMapper.readTree(
                        new String(repositoryService.getModelEditorSource(model.getId()), "utf-8"));
                modelNode.set("model", editorJsonNode);

            } catch (Exception e) {
                throw new ActivitiException("Error creating model JSON", e);
            }
        }
        return modelNode;
    }


}
