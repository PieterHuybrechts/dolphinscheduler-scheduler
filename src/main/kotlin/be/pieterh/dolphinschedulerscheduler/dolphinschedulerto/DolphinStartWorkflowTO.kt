package be.pieterh.dolphinschedulerscheduler.dolphinschedulerto

import be.pieterh.dolphinschedulerscheduler.DolphinScheduleTime

class DolphinStartWorkflowTO private constructor(builder: Builder) {
    val processDefinitionCode: String = builder.processDefinitionCode!!
    val failureStrategy: String = builder.failureStrategy!!
    val warningType: String = builder.warningType!!
    val warningGroupId: String? = builder.warningGroupId
    val execType: String = builder.execType!!
    val startNodeList: String? = builder.startNodeList
    val taskDependType: String = builder.taskDependType!!
    val complementDependentMode: String = builder.complementDependentMode!!
    val runMode: String = builder.runMode!!
    val processInstancePriority: String = builder.processInstancePriority!!
    val workerGroup: String = builder.workerGroup!!
    val tenantCode: String = builder.tenantCode!!
    val environmentCode: String? = builder.environmentCode
    val startParams: String? = builder.startParams
    val expectedParallelismNumber: Int = builder.expectedParallelismNumber!!
    val dryRun: Int = builder.dryRun!!
    val testFlag: Int = builder.testFlag!!
    val version: Int = builder.version!!
    val allLevelDependent: Boolean = builder.allLevelDependent!!
    val executionOrder: String = builder.executionOrder!!
    val scheduleTime: DolphinScheduleTime = builder.scheduleTime!!

    class Builder {
        var processDefinitionCode: String? = null
        var failureStrategy: String? = null
        var warningType: String? = null
        var warningGroupId: String? = null
        var execType: String? = null
        var startNodeList: String? = null
        var taskDependType: String? = null
        var complementDependentMode: String? = null
        var runMode: String? = null
        var processInstancePriority: String? = null
        var workerGroup: String? = null
        var tenantCode: String? = null
        var environmentCode: String? = null
        var startParams: String? = null
        var expectedParallelismNumber: Int? = null
        var dryRun: Int? = null
        var testFlag: Int? = null
        var version: Int? = null
        var allLevelDependent: Boolean? = null
        var executionOrder: String? = null
        var scheduleTime: DolphinScheduleTime? = null

        fun withProcessDefinitionCode(processDefinitionCode: String): Builder {
            this.processDefinitionCode = processDefinitionCode
            return this
        }

        fun withFailureStrategy(failureStrategy: String): Builder {
            this.failureStrategy = failureStrategy
            return this
        }

        fun withWarningType(warningType: String): Builder {
            this.warningType = warningType
            return this
        }

        fun withWarningGroupId(warningGroupId: String): Builder {
            this.warningGroupId = warningGroupId
            return this
        }

        fun withExecType(execType: String): Builder {
            this.execType = execType
            return this
        }

        fun withStartNodeList(startNodeList: String): Builder {
            this.startNodeList = startNodeList
            return this
        }

        fun withTaskDependType(taskDependType: String): Builder {
            this.taskDependType = taskDependType
            return this
        }

        fun withComplementDependentMode(complementDependentMode: String): Builder {
            this.complementDependentMode = complementDependentMode
            return this
        }

        fun withRunMode(runMode: String): Builder {
            this.runMode = runMode
            return this
        }

        fun withProcessInstancePriority(processInstancePriority: String): Builder {
            this.processInstancePriority = processInstancePriority
            return this
        }

        fun withWorkerGroup(workerGroup: String): Builder {
            this.workerGroup = workerGroup
            return this
        }

        fun withTenantCode(tenantCode: String): Builder {
            this.tenantCode = tenantCode
            return this
        }

        fun withEnvironmentCode(environmentCode: String): Builder {
            this.environmentCode = environmentCode
            return this
        }

        fun withStartParams(startParams: String): Builder {
            this.startParams = startParams
            return this
        }

        fun withExpectedParallelismNumber(expectedParallelismNumber: Int): Builder {
            this.expectedParallelismNumber = expectedParallelismNumber
            return this
        }

        fun withDryRun(dryRun: Int): Builder {
            this.dryRun = dryRun
            return this
        }

        fun withTestFlag(testFlag: Int): Builder {
            this.testFlag = testFlag
            return this
        }

        fun withVersion(version: Int): Builder {
            this.version = version
            return this
        }

        fun withAllLevelDependent(allLevelDependent: Boolean): Builder {
            this.allLevelDependent = allLevelDependent
            return this
        }

        fun withExecutionOrder(executionOrder: String): Builder {
            this.executionOrder = executionOrder
            return this
        }

        fun withScheduleTime(scheduleTime: DolphinScheduleTime): Builder {
            this.scheduleTime = scheduleTime
            return this
        }

        fun build(): DolphinStartWorkflowTO {
            return DolphinStartWorkflowTO(this)
        }
    }
}