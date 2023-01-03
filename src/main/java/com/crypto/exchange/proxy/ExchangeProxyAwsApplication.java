package com.crypto.exchange.proxy;

import com.crypto.exchange.proxy.market.service.ExchangeProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.HashMap;
import java.util.Map;

@EnableFeignClients
@SpringBootApplication
public class ExchangeProxyAwsApplication   {

//    @Autowired
//    private ExchangeProxyService exchangeProxyService;

    public static void main(String[] args) {
        SpringApplication.run(ExchangeProxyAwsApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Map<String, String> path = new HashMap<>();
//        path.put("proxy","binance/exchangeInfo");
//
//
////        Map<String, String> param = new HashMap<>();
////        param.put("currency_pair","BTC_USDT");
////        param.put("limit","1");
//
//        exchangeProxyService.getValueFromPlatform(path,null);
//    }
}
