package be.pieterh.dolphinscheduler_scheduler

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@EnableWebMvc
@Configuration
class RestTemplateConfig : WebMvcConfigurer {

    @Bean
    fun restTemplate(
        builder: RestTemplateBuilder,
    ): RestTemplate {

        return builder
            .build()
    }

    @Bean
    fun dolphinRequestBodyBuilder(): DolphinRequestBody.Builder {
        return DolphinRequestBody.Builder()
            .withFailureStrategy("CONTINUE")
            .withWarningType("NONE")
            .withExecType("START_PROCESS")
            .withTaskDependType("TASK_POST")
            .withComplementDependentMode("OFF_MODE")
            .withRunMode("RUN_MODE_SERIAL")
            .withProcessInstancePriority("MEDIUM")
            .withWorkerGroup("default")
            .withTenantCode("default")
            .withExpectedParallelismNumber(2)
            .withDryRun(0)
            .withTestFlag(0)
            .withVersion(8)
            .withAllLevelDependent(false)
            .withExecutionOrder("DESC_ORDER")
    }

    @Bean
    fun dolphinHeaders(@Value("\${dolphin-scheduler-scheduler.token}") token: String): HttpHeaders {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_FORM_URLENCODED
        headers.set("token", token)
        return headers
    }

}