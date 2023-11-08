package com.in28minutes.microservices.currencyexchangeservice.controllers;

import com.in28minutes.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class CurrencyExchangeController {

    private CurrencyExchangeRepository currencyExchangeRepository;
    private Logger logger= LoggerFactory.getLogger(CurrencyExchangeController.class);
    private Environment environment;

    @Autowired
    public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository currencyExchangeRepository){
        this.environment=environment;
        this.currencyExchangeRepository=currencyExchangeRepository;
    }
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieve(@PathVariable String from, @PathVariable String to){

         logger.info("retrieve exchange value called with {} to {}");
//        CurrencyExchange currencyExchange = new CurrencyExchange(from, to, 100L, BigDecimal.valueOf(80));
        CurrencyExchange currencyExchange= currencyExchangeRepository.findByFromAndTo(from,to);
        if(currencyExchange==null){
            throw new RuntimeException("Unable to find data for "+from+" to "+to);
        }
        String port=environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);


        return currencyExchange;
    }

}
