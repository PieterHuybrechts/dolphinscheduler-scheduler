package be.pieterh.dolphinschedulerscheduler

import be.pieterh.dolphinschedulerscheduler.domain.WorkFlow
import org.springframework.stereotype.Repository

@Repository
class DolphinSchedulerWorkFlowRepository() {

    var workFlows = listOf<WorkFlow>()

    fun save(workFlows: List<WorkFlow>) {
        this.workFlows = workFlows
    }

    fun findAll(): List<WorkFlow> {
        return workFlows
    }

    fun find(workFlowId: String): WorkFlow? {
        return workFlows.first { workFlow -> workFlow.code == workFlowId }
    }

}