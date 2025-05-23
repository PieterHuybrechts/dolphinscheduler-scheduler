package be.pieterh.dolphinschedulerscheduler.dolphinschedulerto

class WorkFlowQueryTO private constructor() {
    val data: WorkflowSummaryListTO? = null
}

class WorkflowSummaryListTO private constructor() {
    val totalList: List<WorkflowSummaryTO> = listOf()
}

class WorkflowSummaryTO private constructor() {
    val taskName: String? = null
    val processDefinitionCode: String? = null
}