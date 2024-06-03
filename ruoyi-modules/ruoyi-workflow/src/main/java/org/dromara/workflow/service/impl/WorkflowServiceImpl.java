package org.dromara.workflow.service.impl;

import lombok.RequiredArgsConstructor;
import org.dromara.workflow.service.IActProcessInstanceService;
import org.dromara.workflow.service.WorkflowService;
import org.dromara.workflow.utils.WorkflowUtils;
import org.flowable.engine.RuntimeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 通用 工作流服务实现
 *
 * @author may
 */
@RequiredArgsConstructor
@Service
public class WorkflowServiceImpl implements WorkflowService {

    private final IActProcessInstanceService iActProcessInstanceService;
    private final RuntimeService runtimeService;

    /**
     * 运行中的实例 删除程实例，删除历史记录，删除业务与流程关联信息
     *
     * @param businessKeys 业务id
     * @return 结果
     */
    @Override
    public boolean deleteRunAndHisInstance(List<String> businessKeys) {
        return iActProcessInstanceService.deleteRunAndHisInstance(businessKeys);
    }

    /**
     * 获取当前流程状态
     *
     * @param taskId 任务id
     */
    @Override
    public String getBusinessStatusByTaskId(String taskId) {
        return WorkflowUtils.getBusinessStatusByTaskId(taskId);
    }

    /**
     * 获取当前流程状态
     *
     * @param businessKey 业务id
     */
    @Override
    public String getBusinessStatus(String businessKey) {
        return WorkflowUtils.getBusinessStatus(businessKey);
    }

    /**
     * 设置流程实例对象
     *
     * @param obj         业务对象
     * @param businessKey 业务id
     */
    @Override
    public void setBusinessInstanceDTO(Object obj, String businessKey) {
        WorkflowUtils.setBusinessInstanceDTO(obj, businessKey);
    }

    /**
     * 设置流程实例对象
     *
     * @param obj       业务对象
     * @param idList    业务id
     * @param fieldName 主键属性名称
     */
    @Override
    public void setBusinessInstanceListDTO(Object obj, List<String> idList, String fieldName) {
        WorkflowUtils.setBusinessInstanceListDTO(obj, idList, fieldName);
    }

    /**
     * 设置流程变量(全局变量)
     *
     * @param taskId       任务id
     * @param variableName 变量名称
     * @param value        变量值
     */
    @Override
    public void setVariable(String taskId, String variableName, Object value) {
        runtimeService.setVariable(taskId, variableName, value);
    }

    /**
     * 设置流程变量(全局变量)
     *
     * @param taskId    任务id
     * @param variables 流程变量
     */
    @Override
    public void setVariables(String taskId, Map<String, Object> variables) {
        runtimeService.setVariables(taskId, variables);
    }

    /**
     * 设置流程变量(本地变量,非全局变量)
     *
     * @param taskId       任务id
     * @param variableName 变量名称
     * @param value        变量值
     */
    @Override
    public void setVariableLocal(String taskId, String variableName, Object value) {
        runtimeService.setVariableLocal(taskId, variableName, value);
    }

    /**
     * 设置流程变量(本地变量,非全局变量)
     *
     * @param taskId    任务id
     * @param variables 流程变量
     */
    @Override
    public void setVariablesLocal(String taskId, Map<String, Object> variables) {
        runtimeService.setVariablesLocal(taskId, variables);
    }
}
