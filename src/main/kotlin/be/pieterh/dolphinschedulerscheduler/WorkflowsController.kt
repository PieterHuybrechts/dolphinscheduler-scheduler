package be.pieterh.dolphinschedulerscheduler

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller("/")
class WorkflowsController(val client: DolphinSchedulerClient, val repository: DolphinSchedulerWorkFlowRepository) {

    @GetMapping
    fun get(model: Model): String {
        model.addAttribute("tasks", repository.findAll())

        return "index"
    }

    @GetMapping("/workflows")
    fun search(@RequestParam nameQuery: String, model: Model): String {
        model.addAttribute("tasks", repository.searchByName(nameQuery))
        return "fragments :: tasksList"
    }

    @PostMapping("/workflows/{workflowId}/start")
    fun startWorkflow(@PathVariable workflowId: String): String {
        val version = repository.find(workflowId)?.version
        client.startBatch(workflowId, version ?: 0)

        return "fragments :: batchStartConfirmation"
    }

    @GetMapping("workflows/refresh")
    fun refreshWorkflows(model: Model): String {
        val workFlows = client.refreshTasks()
        repository.save(workFlows)
        val allTasks = repository.findAll()
        model.addAttribute("tasks", allTasks)

        return "fragments :: tasksList"
    }

}