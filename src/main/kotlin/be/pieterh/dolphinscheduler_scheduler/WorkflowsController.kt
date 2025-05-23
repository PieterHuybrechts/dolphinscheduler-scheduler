package be.pieterh.dolphinscheduler_scheduler

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller("/")
class WorkflowsController(val client: DolphinSchedulerClient, val repository: DolphinSchedulerTaskRepository) {

    @GetMapping
    fun get(model: Model): String {
        model.addAttribute("tasks", repository.findAll())

        return "index"
    }

    @PostMapping("/workflows/start/{workflowId}")
    fun startWorkflow(@PathVariable workflowId: String): String {
        client.startBatch(workflowId)

        return "fragments :: batchStartConfirmation"
    }

}