package com.fse0.microservice.gateway.config;

import com.fse0.microservice.gateway.filter.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private JWTFilter filter;


    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route("process-pension",
                        p->p.path("/process-pension/**")
                                .filters(f -> f.filter(filter))
                                .uri("http://processpension844744-env.eba-scdiijfh.us-east-1.elasticbeanstalk.com/process-pension"))
                .route("pensioner-detail",
                        p -> p.path("/pensioner-detail/**")
                                .filters(f -> f.filter(filter))
                                .uri("http://pensionerdetail844744-env.eba-8w2u7mxi.us-east-1.elasticbeanstalk.com/pensioner-detail/**"))
                .route("login",
                        p->p.path("/login/**")
                                .filters(f -> f.filter(filter))
                                .uri("http://loginservice844744-env.eba-pgvskck6.us-east-1.elasticbeanstalk.com/login"))
                .build();
    }
}
