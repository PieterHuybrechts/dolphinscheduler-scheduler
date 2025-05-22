package be.pieterh.dolphinscheduler_scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class DolphinSchedulerClient {

    private final String projectCode;
    private final String token;
    private final String baseUrl;

    public DolphinSchedulerClient(@Value("${dolphin-scheduler-scheduler.project-code}") String projectCode,
                                  @Value("${dolphin-scheduler-scheduler.token}") String token,
                                  @Value("${dolphin-scheduler-scheduler.base-url}") String baseUrl) {
        this.projectCode = projectCode;
        this.token = token;
        this.baseUrl = baseUrl;
    }

    public void startBatch(String processDefinitionCode) {
        String url = String.format("%s/projects/%s/executors/start-process-instance", baseUrl, projectCode);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("token", token);

        // Create request body
        MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("processDefinitionCode", processDefinitionCode);
        requestBody.add("failureStrategy", "CONTINUE");
        requestBody.add("warningType", "NONE");
        requestBody.add("warningGroupId", null);
        requestBody.add("execType", "START_PROCESS");
        requestBody.add("startNodeList", null);
        requestBody.add("taskDependType", "TASK_POST");
        requestBody.add("complementDependentMode", "OFF_MODE");
        requestBody.add("runMode", "RUN_MODE_SERIAL");
        requestBody.add("processInstancePriority", "MEDIUM");
        requestBody.add("workerGroup", "default");
        requestBody.add("tenantCode", "default");
        requestBody.add("environmentCode", null);
        requestBody.add("startParams", null);
        requestBody.add("expectedParallelismNumber", 2);
        requestBody.add("dryRun", 0);
        requestBody.add("testFlag", 0);
        requestBody.add("version", 8);
        requestBody.add("allLevelDependent", false);
        requestBody.add("executionOrder", "DESC_ORDER");

        // Create nested scheduleTime object
        Map<String, String> scheduleTime = new HashMap<>();

        String currentDayAtStartOfDay = LocalDate.now().atStartOfDay().toString();
        System.out.println(currentDayAtStartOfDay);

        scheduleTime.put("complementStartDate", currentDayAtStartOfDay);
        scheduleTime.put("complementEndDate", currentDayAtStartOfDay);
        requestBody.add("scheduleTime", scheduleTime);

        // Wrap the body and headers
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        // Send POST request
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // Print the response
        System.out.println("Response: " + response.getBody());
    }
}