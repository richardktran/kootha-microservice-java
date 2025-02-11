package dev.richardktran.user_service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import dev.richardktran.user_service.constant.ServiceName;

@Component
public class ServiceDiscovery {
    @Autowired
    private EurekaClient eurekaClient;

    public String getServiceUrl(ServiceName serviceName) {
        try {
            InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(serviceName.getServiceName(), false);
            return instanceInfo.getHomePageUrl();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error getting service URL for " + serviceName, e);
        }
    }
}
