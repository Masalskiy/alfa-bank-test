package com.masalski.alfa;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

//configure the mock response for a GET request on the ... endpoint:
@TestPropertySource(locations = "classpath:application-test.properties")
public class ExchangeMock {
    public static void setupMockExchangeLatestResponse(WireMockServer mockService) throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/latest.json?app_id=${feign.app_id}"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                                copyToString(
                                        ExchangeMock.class.getClassLoader().getResourceAsStream("payload/get-exchange-response.json"),
                                        defaultCharset()))));
    }
    public static void setupMockExchangeHistoricalResponse(WireMockServer mockService) throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/historical/2012-07-10.json?app_id=${feign.app_id}"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                                copyToString(
                                        ExchangeMock.class.getClassLoader().getResourceAsStream("payload/get-histExchange-response.json"),
                                        defaultCharset()))));
    }
    public static void setupMockGiphyResponse(WireMockServer mockService) throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("?api_key=${giphy.api_key}&tag=broken&rating=${giphy.rating}"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                                copyToString(
                                        ExchangeMock.class.getClassLoader().getResourceAsStream("payload/get-exchange-response.json"),
                                        defaultCharset()))));
    }

}
