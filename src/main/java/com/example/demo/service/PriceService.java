package com.example.demo.service;

import com.example.demo.entity.Price;

import java.util.Optional;

public interface PriceService {

    Optional<Price> getPriceByDates(String date, Integer productId
            , Integer idCadena);
}