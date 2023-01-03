package com.crypto.exchange.proxy.market.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.util.Map;


@FeignClient(value = "gateio", url = "${exchange.spot-base-url.gateio}")
public interface GateIOClient {

	@RequestMapping(method = RequestMethod.GET, value = "{path}")
	Object getPairData(URI baseUrl, @PathVariable(value="path") String path, @RequestParam Map<String, String> query);



}


