package dev.richardktran.user_service.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Component
public class ServiceDiscovery {
    @Autowired
    private EurekaClient eurekaClient;

    public String getServiceUrl(String serviceName) {
        try {
            InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(serviceName, false);
            return instanceInfo.getHomePageUrl();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error getting service URL for " + serviceName, e);
        }
    }
}
