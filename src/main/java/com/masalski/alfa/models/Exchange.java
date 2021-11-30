package com.masalski.alfa.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

public class Exchange {

//    disclaimer: "https://openexchangerates.org/terms/",
//    license: "https://openexchangerates.org/license/",
//    timestamp: 1449877801,
//    base: "USD",
//    rates: {
//        AED: 3.672538,
//        AFN: 66.809999,
//        /* ... */
//    }

    private final String disclaimer;
    private final String license;
    private final int timestamp;
    private final String base;
    private final Map<String, Double> rates;

    public Exchange(String disclaimer, String license, int timestamp, String base, Map<String, Double> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.timestamp = timestamp;
        this.base = base;
        this.rates = rates;

    }

    public boolean rateIsUp(Exchange historical, String currency) {
        Double histRate = historical.getRates().get(currency.toUpperCase());
        Double todayRate = rates.get(currency.toUpperCase());
        System.out.printf("Rate %s change from %f to %f \n", currency.toUpperCase(), histRate, todayRate);
        //log.info("Курс {} изменился с {} на {} ", currency.toUpperCase(), histRate, todayRate);
        return todayRate > histRate;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exchange exchange = (Exchange) o;
        if (!Objects.equals(disclaimer, exchange.disclaimer)) return false;
        if (!Objects.equals(license, exchange.license)) return false;
        if (!Objects.equals(timestamp, exchange.timestamp)) return false;
        if (!Objects.equals(base, exchange.base)) return false;
        return Objects.equals(rates, exchange.rates);
    }

    @Override
    public int hashCode() {
        int result = disclaimer != null ? disclaimer.hashCode() : 0;
        result = 31 * result + (license != null ? license.hashCode() : 0);
        result = 31 * result + timestamp;
        result = 31 * result + (base != null ? base.hashCode() : 0);
        result = 31 * result + (rates != null ? rates.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Exchange{" +
                "disclaimer = '" + disclaimer + '\'' +
                ", license = '" + license + '\'' +
                ", timestamp = '" + timestamp + '\'' +
                ", base = '" + base + '\'' +
                ", rates = " + rates +
                '}';
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public String getBase() {
        return base;
    }

}
