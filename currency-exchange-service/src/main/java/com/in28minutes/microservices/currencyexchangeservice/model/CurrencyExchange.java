package com.in28minutes.microservices.currencyexchangeservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class CurrencyExchange {
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    @Id

    private Long id;
    private BigDecimal conversionMultiple;
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public CurrencyExchange(){

    }

    public CurrencyExchange(String from, String to, Long id, BigDecimal conversionMultiple) {
        this.from = from;
        this.to = to;
        this.id = id;
        this.conversionMultiple = conversionMultiple;
    }


    public CurrencyExchange(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }
}
