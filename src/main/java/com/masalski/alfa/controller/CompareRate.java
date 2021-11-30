package com.masalski.alfa.controller;

import com.masalski.alfa.Util;
import com.masalski.alfa.models.Exchange;
import com.masalski.alfa.models.Gif;
import com.masalski.alfa.service.ExchangeService;
import com.masalski.alfa.service.GiphyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompareRate {
    //@Scheduled(cron = "0 0 * * *")
    //сохранить historyRAtE и обновлять каждый день
    private final ExchangeService exchangeService;
    private final GiphyService giphyService;

    public CompareRate(@Autowired ExchangeService exchangeService, @Autowired GiphyService giphyService) {
        this.exchangeService = exchangeService;
        this.giphyService = giphyService;
    }

    @GetMapping("/api/{currency}")
    public String getResult(@PathVariable String currency) {
        Util util = new Util();
        Exchange today = exchangeService.getExchange();
        Exchange yesterday = exchangeService.getExchange(util.getHistDay());
        Gif gif;
        if (today.rateIsUp(yesterday, currency)) {
            System.out.println("Gif should be rich");
            gif = giphyService.getGiphy("rich");
        } else {
            System.out.println("Gif should be broken");
            gif = giphyService.getGiphy("broken");
        }
        //• если курс по отношению к USD за сегодня стал выше вчерашнего,
        //  то отдаем рандомную отсюда https://giphy.com/search/rich
        //• если ниже - отсюда https://giphy.com/search/broke

        String url = gif.getData().getImages().getDownsized_large().getUrl();
        return util.createHtml(url);
    }
}
