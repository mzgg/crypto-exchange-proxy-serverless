package com.crypto.exchange.proxy;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class ExchangeHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent,Object> {
}
