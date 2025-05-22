package be.pieterh.dolphinscheduler_scheduler

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller("/")
class WorkflowsController(val client: DolphinSchedulerClient) {

    @GetMapping
    fun get(): String {
        return "index"
    }

    @PostMapping("/workflows/start")
    fun startWorkflow(): String {
        client.startBatch("128090641501184")

        return "fragments :: batchStartConfirmation"
    }

}