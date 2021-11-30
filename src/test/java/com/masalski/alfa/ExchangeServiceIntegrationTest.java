package com.masalski.alfa;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.masalski.alfa.service.ExchangeService;
import com.masalski.alfa.service.GiphyService;
import com.masalski.alfa.models.Exchange;
import com.masalski.alfa.models.Gif;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
public class ExchangeServiceIntegrationTest {
    @Autowired
    private WireMockServer mockExchangeService;

    @Autowired
    private ExchangeService exchangeService;

    @Autowired
    private GiphyService giphyService;

    @BeforeEach
    void setUp() throws IOException {
        ExchangeMock.setupMockExchangeLatestResponse(mockExchangeService);
        ExchangeMock.setupMockExchangeHistoricalResponse(mockExchangeService);
        ExchangeMock.setupMockGiphyResponse(mockExchangeService);
    }
    //At this point, we have a SpringBootTest configured with a WireMockServer ready to return a
    // predefined response of ExchangeRate when the //latest.json?app_id=${feign.app_id} endpoint is invoked by the ExchangeClient

    //our test methods
    @Test
    public void whenGetLatestExchange_thenExchangeShouldBeReturned() {
        assertNotNull(exchangeService.getExchange());
    }

    @Test
    public void whenGetLatestExchange_thenTheCorrectExchangeShouldBeReturned() {
        Exchange exchange = exchangeService.getExchange();
        assertEquals("USD", exchange.getBase());
        assertEquals("Usage subject to terms: https://openexchangerates.org/terms", exchange.getDisclaimer());
        assertEquals("https://openexchangerates.org/license", exchange.getLicense());
        assertTrue(exchange.getRates().containsKey("RUB"));
    }

    @Test
    public void whenGetHistExchange_thenExchangeShouldBeReturned() {
         assertNotNull(exchangeService.getExchange("2012-07-10"));
    }

    @Test
    public void whenGetHistoricalExchange_thenTheCorrectExchangeShouldBeReturned() {
        Exchange exchange = exchangeService.getExchange("2012-07-10");
        assertEquals("USD", exchange.getBase());
        assertEquals("Usage subject to terms: https://openexchangerates.org/terms", exchange.getDisclaimer());
        assertEquals("https://openexchangerates.org/license", exchange.getLicense());
        //assertEquals(1, exchange.getTimestamp());
        assertTrue(exchange.getRates().containsKey("RUB"));
    }

    @Test
    public void whenGetGiphy_thenGiphyShouldBeReturned() {
        assertNotNull(giphyService.getGiphy("broken"));
    }

    @Test
    public void whenGetGiphy_thenTheCorrectGiphyShouldBeReturned() {
        Gif gif = giphyService.getGiphy("broken");
        assertNotNull(gif.getData().getEmbed_url());
        assertNotNull(gif.getData().getImages().getDownsized_large().getUrl());
    }

}
