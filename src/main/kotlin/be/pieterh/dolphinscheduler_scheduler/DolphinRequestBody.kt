package be.pieterh.dolphinscheduler_scheduler

class DolphinRequestBody private constructor(builder: Builder) {
    val processDefinitionCode: String
    val failureStrategy: String
    val warningType: String
    val warningGroupId: String?
    val execType: String
    val startNodeList: String?
    val taskDependType: String
    val complementDependentMode: String
    val runMode: String
    val processInstancePriority: String
    val workerGroup: String
    val tenantCode: String
    val environmentCode: String?
    val startParams: String?
    val expectedParallelismNumber: Int
    val dryRun: Int
    val testFlag: Int
    val version: Int
    val allLevelDependent: Boolean
    val executionOrder: String
    val scheduleTime: DolphinScheduleTime

    init {
        this.processDefinitionCode = builder.processDefinitionCode!!
        this.failureStrategy = builder.failureStrategy!!
        this.warningType = builder.warningType!!
        this.warningGroupId = builder.warningGroupId
        this.execType = builder.execType!!
        this.startNodeList = builder.startNodeList
        this.taskDependType = builder.taskDependType!!
        this.complementDependentMode = builder.complementDependentMode!!
        this.runMode = builder.runMode!!
        this.processInstancePriority = builder.processInstancePriority!!
        this.workerGroup = builder.workerGroup!!
        this.tenantCode = builder.tenantCode!!
        this.environmentCode = builder.environmentCode
        this.startParams = builder.startParams
        this.expectedParallelismNumber = builder.expectedParallelismNumber!!
        this.dryRun = builder.dryRun!!
        this.testFlag = builder.testFlag!!
        this.version = builder.version!!
        this.allLevelDependent = builder.allLevelDependent!!
        this.executionOrder = builder.executionOrder!!
        this.scheduleTime = builder.scheduleTime!!
    }

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

        fun build(): DolphinRequestBody {
            return DolphinRequestBody(this)
        }
    }
}