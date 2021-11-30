package com.masalski.alfa.service;

import com.masalski.alfa.models.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ExchangeCourse", url = "${feign.baseUrl}")
public interface ExchangeService {
    @GetMapping(value = "/latest.json?app_id=${feign.app_id}")
    Exchange getExchange();

    @GetMapping(value = "/historical/{date}.json?app_id=${feign.app_id}")
    Exchange getExchange(@PathVariable String date);
}

