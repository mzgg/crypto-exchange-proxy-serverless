package com.crypto.exchange.proxy.market.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "ip-check", url = "http://checkip.dyndns.org")
public interface IpCheckClient {

	@RequestMapping(method = RequestMethod.GET, consumes = "text/html;charset=ISO-8859-1")
	String check();



}


