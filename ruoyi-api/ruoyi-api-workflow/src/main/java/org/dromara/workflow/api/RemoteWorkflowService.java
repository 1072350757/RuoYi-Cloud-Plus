package org.dromara.workflow.api;

import org.dromara.workflow.api.domain.RemoteCompleteTask;
import org.dromara.workflow.api.domain.RemoteStartProcess;
import org.dromara.workflow.api.domain.RemoteStartProcessReturn;

import java.util.List;
import java.util.Map;

/**
 * 通用 工作流服务
 *
 * @Author ZETA
 * @Date 2024/6/3
 */
public interface RemoteWorkflowService {

    /**
     * 运行中的实例 删除程实例，删除历史记录，删除业务与流程关联信息
     *
     * @param businessIds 业务id
     * @return 结果
     */
    boolean deleteInstance(List<Long> businessIds);

    /**
     * 获取当前流程状态
     *
     * @param taskId 任务id
     * @return 状态
     */
    String getBusinessStatusByTaskId(Long taskId);

    /**
     * 获取当前流程状态
     *
     * @param businessId 业务id
     * @return 状态
     */
    String getBusinessStatus(String businessId);

    /**
     * 设置流程变量
     *
     * @param instanceId 流程实例id
     * @param variable   流程变量
     */
    void setVariable(Long instanceId, Map<String, Object> variable);

    /**
     * 获取流程变量
     *
     * @param instanceId 流程实例id
     */
    Map<String, Object> instanceVariable(Long instanceId);

    /**
     * 按照业务id查询流程实例id
     *
     * @param businessId 业务id
     * @return 结果
     */
    Long getInstanceIdByBusinessId(String businessId);

    /**
     * 新增租户流程定义
     *
     * @param tenantId 租户id
     */
    void syncDef(String tenantId);

    /**
     * 启动流程
     *
     * @param startProcess 参数
     * @return 结果
     */
    RemoteStartProcessReturn startWorkFlow(RemoteStartProcess startProcess);

    /**
     * 办理任务
     *
     * @param completeTask 参数
     * @return 结果
     */
    boolean completeTask(RemoteCompleteTask completeTask);

}
