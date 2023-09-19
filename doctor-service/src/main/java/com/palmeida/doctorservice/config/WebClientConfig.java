package com.palmeida.doctorservice.config;

import com.palmeida.doctorservice.client.PacientClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient pacientWebClient() {
        return WebClient.builder()
                .baseUrl("http://pacient-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public PacientClient pacientClient() {
        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(pacientWebClient()))
                .build();
        return httpServiceProxyFactory.createClient(PacientClient.class);
    }
}
