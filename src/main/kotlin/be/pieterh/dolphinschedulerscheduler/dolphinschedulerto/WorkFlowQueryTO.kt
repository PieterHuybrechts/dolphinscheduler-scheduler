package be.pieterh.dolphinschedulerscheduler.dolphinschedulerto

class WorkFlowQueryTO private constructor() {
    val data: WorkflowSummaryListTO? = null
}

class WorkflowSummaryListTO private constructor() {
    val totalList: List<WorkflowSummaryTO> = listOf()
}

class WorkflowSummaryTO private constructor() {
    val name: String? = null
    val code: String? = null
    val version: Int? = null
}