package com.crypto.exchange.proxy.market.service;

import com.crypto.exchange.proxy.market.feign.IpCheckClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IpCheckService {

    private final IpCheckClient ipCheckClient;

    public String ipCheck(){
        return ipCheckClient.check();
    }
}
