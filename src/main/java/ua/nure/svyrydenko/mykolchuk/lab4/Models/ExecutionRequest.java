package ua.nure.svyrydenko.mykolchuk.lab4.Models;

import java.util.Map;

public class ExecutionRequest {
    private String operation;
    private Map<String, Object> parameters;
    public ExecutionRequest() {
    }

    public ExecutionRequest(String operation, Map<String, Object> parameters) {
        this.operation = operation;
        this.parameters = parameters;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}

