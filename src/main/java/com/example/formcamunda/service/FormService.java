package com.example.formcamunda.service;

import com.example.formcamunda.model.FormStartRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class FormService {

    private final RestTemplate restTemplate;

    @Value("${camunda.rest.url}")
    private String camundaRestUrl;

    public FormService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String startProcess(FormStartRequest request) {
        String url = camundaRestUrl + "/process-definition/key/" + request.getProcessKey() + "/start";

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("variables", request.getFormData());
        System.out.println(request.toString());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, httpEntity, String.class);

        return response.getBody();
    }
}
