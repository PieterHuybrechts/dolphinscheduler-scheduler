package be.pieterh.dolphinscheduler_scheduler

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDate

@Service
class DolphinSchedulerClient(
    val restTemplate: RestTemplate,
    val dolphinRequestBodyBuilder: DolphinRequestBody.Builder,
    val dolphinHeaders: HttpHeaders,
    @Value("\${dolphin-scheduler-scheduler.base-url}") baseUrl: String,
    @Value("\${dolphin-scheduler-scheduler.project-code}") projectCode: String
) {
    val baseUrl = "$baseUrl/projects/$projectCode/executors/start-process-instance"

    fun startBatch(processDefinitionCode: String) {
        val currentDayAtStartOfDay = LocalDate.now().atStartOfDay().toString()

        val body = dolphinRequestBodyBuilder
            .withProcessDefinitionCode(processDefinitionCode)
            .withScheduleTime(
                DolphinScheduleTime.Builder()
                    .withComplementStartDate(currentDayAtStartOfDay)
                    .withComplementEndDate(currentDayAtStartOfDay)
                    .build()
            )
            .build()

        val response: ResponseEntity<String> = restTemplate.exchange(
            baseUrl,
            HttpMethod.POST,
            HttpEntity(body, dolphinHeaders),
            String::class.java
        )

        println(response)
    }

}