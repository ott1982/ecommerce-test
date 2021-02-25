package com.example.demo.service;

import com.example.demo.entity.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {

    Optional<Price> getPriceByDates(LocalDateTime date, Integer productId
            , Integer idCadena);
}