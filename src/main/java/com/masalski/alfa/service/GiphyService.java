package com.masalski.alfa.service;

import com.masalski.alfa.models.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "giphy", url = "${giphy.baseUrl}")
public interface GiphyService {
    @GetMapping(value = "?api_key=${giphy.api_key}&tag={whoAmI}&rating=${giphy.rating}")
    Gif getGiphy(@PathVariable String whoAmI);
}
