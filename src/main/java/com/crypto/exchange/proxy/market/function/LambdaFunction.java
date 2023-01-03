package com.crypto.exchange.proxy.market.function;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.crypto.exchange.proxy.market.service.ExchangeProxyService;
import com.crypto.exchange.proxy.market.service.IpCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class LambdaFunction {

    @Autowired
    private ExchangeProxyService exchangeProxyService;

    @Autowired
    private IpCheckService ipCheckService;


    @Bean
    public Function<APIGatewayProxyRequestEvent, Object> getResponseFromExchangeData() {
        return (event) -> exchangeProxyService
                .getValueFromPlatform(event.getPathParameters(), event.getQueryStringParameters());
    }

    @Bean
    public Function<APIGatewayProxyRequestEvent, Object> getIpCheck() {
        return (event) -> ipCheckService.ipCheck();
    }


}
