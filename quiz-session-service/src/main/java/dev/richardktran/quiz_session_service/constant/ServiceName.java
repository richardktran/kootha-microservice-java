package dev.richardktran.quiz_session_service.constant;

public enum ServiceName {
    ID_GENERATION_SERVICE("id-generation-service");

    private final String serviceName;

    ServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
