package com.example.demo.service.impl;

import com.example.demo.entity.Price;
import com.example.demo.repository.PriceRepository;
import com.example.demo.service.PriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class PriceServiceImpl extends CommonServiceImpl
        implements PriceService {
    private static final Logger logger = LoggerFactory
            .getLogger(PriceServiceImpl.class);
    PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<Price> getPriceByDates(String date, Integer productId
            , Integer idCadena) {
        logger.debug("getting price");
        return Optional.empty();
    }
}
