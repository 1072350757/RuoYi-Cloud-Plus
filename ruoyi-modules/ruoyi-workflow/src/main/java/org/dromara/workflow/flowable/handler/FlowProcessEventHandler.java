package org.dromara.workflow.flowable.handler;

import org.dromara.common.core.utils.ServletUtils;
import org.dromara.common.core.utils.SpringUtils;
import org.dromara.workflow.api.domain.event.ProcessEvent;
import org.dromara.workflow.api.domain.event.ProcessTaskEvent;
import org.springframework.stereotype.Component;

/**
 * 流程监听服务
 *
 * @author may
 * @date 2024-06-02
 */
@Component
public class FlowProcessEventHandler {

    /**
     * 总体流程监听(例如: 提交 退回 撤销 终止 作废等)
     *
     * @param key         流程key
     * @param businessKey 业务id
     * @param status      状态
     * @param submit      当为true时为申请人节点办理
     */
    public void processHandler(String key, String businessKey, String status, boolean submit) {
        ProcessEvent processEvent = new ProcessEvent();
        processEvent.setKey(key);
        processEvent.setBusinessKey(businessKey);
        processEvent.setStatus(status);
        processEvent.setSubmit(submit);
        processEvent.setRequest(ServletUtils.getRequest());
        SpringUtils.context().publishEvent(processEvent);
    }

    /**
     * 执行办理任务监听
     *
     * @param keyNode     流程定义key与流程节点标识(拼接方式：流程定义key_流程节点)
     * @param taskId      任务id
     * @param businessKey 业务id
     */
    public void processTaskHandler(String keyNode, String taskId, String businessKey) {
        ProcessTaskEvent processTaskEvent = new ProcessTaskEvent();
        processTaskEvent.setKeyNode(keyNode);
        processTaskEvent.setTaskId(taskId);
        processTaskEvent.setBusinessKey(businessKey);
        processTaskEvent.setRequest(ServletUtils.getRequest());
        SpringUtils.context().publishEvent(processTaskEvent);
    }
}
