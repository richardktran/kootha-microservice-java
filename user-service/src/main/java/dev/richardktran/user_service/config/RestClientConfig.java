package dev.richardktran.user_service.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import dev.richardktran.user_service.client.IdGenerationClient;
import dev.richardktran.user_service.utils.ServiceDiscovery;

@Configuration
public class RestClientConfig {
    @Autowired
    private ServiceDiscovery serviceDiscovery;

    @Bean
    public IdGenerationClient idGenerationClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl(serviceDiscovery.getServiceUrl("id-generation-service"))
                .requestFactory(getClientRequestFactory())
                .build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(IdGenerationClient.class);
    }
    

    private ClientHttpRequestFactory getClientRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(Duration.ofSeconds(3));
        factory.setReadTimeout(Duration.ofSeconds(3));

        return factory;
    }
}
