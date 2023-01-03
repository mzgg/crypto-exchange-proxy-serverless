package com.crypto.exchange.proxy.market.service;

import com.crypto.exchange.proxy.market.feign.GateIOClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeProxyService {

    private final GateIOClient gateIOClient;

    public Object getValueFromPlatform(Map<String, String> pathParamMap, Map<String, String> requestParamMap) {
        log.info("incoming pathParamMap:{} , requestParamMap{}", pathParamMap, requestParamMap);
        String platformKey = "param1";
        String platform = pathParamMap.get(platformKey);

        String path = convertPathAndRemovePlatform(pathParamMap, platformKey);

        return gateIOClient.getPairData(path, requestParamMap);

    }

    private String convertPathAndRemovePlatform(Map<String, String> pathParamMap, String platformKey) {
        TreeMap<String, String> sortedMap = new TreeMap<>(pathParamMap);
        sortedMap.remove(platformKey);
        return String.join("/", sortedMap.values());
    }


}
