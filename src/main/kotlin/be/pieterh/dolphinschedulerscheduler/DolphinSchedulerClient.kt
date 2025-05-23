package be.pieterh.dolphinschedulerscheduler

import be.pieterh.dolphinschedulerscheduler.dolphinschedulerto.DolphinStartWorkflowTO
import be.pieterh.dolphinschedulerscheduler.dolphinschedulerto.WorkFlowQueryTO
import be.pieterh.dolphinschedulerscheduler.dolphinschedulerto.WorkflowSummaryListTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.time.LocalDate

@Service
class DolphinSchedulerClient(
    val restTemplate: RestTemplate,
    val dolphinStartWorkflowTOBuilder: DolphinStartWorkflowTO.Builder,
    val dolphinHeaders: HttpHeaders,
    @Value("\${dolphin-scheduler-scheduler.base-url}") baseUrl: String,
    @Value("\${dolphin-scheduler-scheduler.project-code}") projectCode: String,
    @Value("\${dolphin-scheduler-scheduler.token}") token: String
) {
    val projectUrl = "$baseUrl/projects/$projectCode"
    val token = token

    fun startBatch(processDefinitionCode: String) {
        val currentDayAtStartOfDay = LocalDate.now().atStartOfDay().toString()

        val body = dolphinStartWorkflowTOBuilder
            .withProcessDefinitionCode(processDefinitionCode)
            .withScheduleTime(
                DolphinScheduleTime.Builder()
                    .withComplementStartDate(currentDayAtStartOfDay)
                    .withComplementEndDate(currentDayAtStartOfDay)
                    .build()
            )
            .build()

        val response: ResponseEntity<String> = restTemplate.exchange(
            "$projectUrl/executors/start-process-instance",
            HttpMethod.POST,
            HttpEntity(body, dolphinHeaders),
            String::class.java
        )

        println(response)
    }

    fun refreshTasks() : WorkflowSummaryListTO {
        val uri = UriComponentsBuilder.fromHttpUrl("$projectUrl/task-definition")
            .queryParam("pageNo", 1)
            .queryParam("pageSize", 500)
            .build()
            .toUri()

        val response: ResponseEntity<WorkFlowQueryTO> = restTemplate.exchange(
            uri,
            HttpMethod.GET,
            HttpEntity(null, dolphinHeadersForGet()),
            WorkFlowQueryTO::class.java
        )

        return response.body!!.data!!
    }

    fun dolphinHeadersForGet() : HttpHeaders {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON
        headers.set("token", token)
        return headers
    }
}