package com.example.formcamunda.model;

import java.util.Map;

public class FormStartRequest {

    private String processKey;
    private Map<String, Object> formData;

    public FormStartRequest() {
    }

    public FormStartRequest(String processKey, Map<String, Object> formData) {
        this.processKey = processKey;
        this.formData = formData;
    }

    public String getProcessKey() {
        return processKey;
    }

    public void setProcessKey(String processKey) {
        this.processKey = processKey;
    }

    public Map<String, Object> getFormData() {
        return formData;
    }

    public void setFormData(Map<String, Object> formData) {
        this.formData = formData;
    }

    @Override
    public String toString() {
        return "FormStartRequest{" +
                "processKey='" + processKey + '\'' +
                ", formData=" + formData +
                '}';
    }
}
