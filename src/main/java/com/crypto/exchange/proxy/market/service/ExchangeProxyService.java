package com.crypto.exchange.proxy.market.service;

import com.crypto.exchange.proxy.market.feign.GateIOClient;
import com.crypto.exchange.proxy.market.resource.MessageResponse;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

@Slf4j
@Service
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "exchange")
public class ExchangeProxyService {

    @Setter
    private Map<String, String> spotBaseUrl;


    private final GateIOClient gateIOClient;

    public Object getValueFromPlatform(Map<String, String> pathParamMap, Map<String, String> requestParamMap) {
        log.info("incoming pathParamMap:{} , requestParamMap{}", pathParamMap, requestParamMap);
        if (Objects.isNull(requestParamMap)) {
            requestParamMap = new HashMap<>();
        }

        if (Objects.isNull(pathParamMap)) {
            return MessageResponse.builder().message("Path couldn't be empty").build();

        }

        String path = convertPathAndRemovePlatform(pathParamMap);

        String platformName = extractedPlatformName(path);
        String baseUrlByPlatformName = spotBaseUrl.get(platformName);

        if (Objects.isNull(baseUrlByPlatformName)) {
            return MessageResponse.builder().message("Platform is not found").build();
        }

        String realPath = path.replace(platformName + "/", "");

        URI determinedBasePathUri = URI.create(baseUrlByPlatformName);
        return gateIOClient.getPairData(determinedBasePathUri, realPath, requestParamMap);

    }

    private String extractedPlatformName(String path) {
        String[] split = path.split("/");
        if (split.length > 1) {
            if (ObjectUtils.isEmpty(split[0])) {
                return split[1];
            }
            return split[0];
        }
        throw new RuntimeException();
    }

    private String convertPathAndRemovePlatform(Map<String, String> pathParamMap) {
        TreeMap<String, String> sortedMap = new TreeMap<>(pathParamMap);
        return String.join("/", sortedMap.values());
    }


}
