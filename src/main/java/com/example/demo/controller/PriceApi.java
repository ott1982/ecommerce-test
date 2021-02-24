package com.example.demo.controller;

import com.example.demo.dto.PriceResponseDto;
import com.example.demo.entity.Price;
import com.example.demo.repository.PriceRepository;
import com.example.demo.service.PriceService;
import com.example.demo.service.impl.PriceServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/price")
public class PriceApi extends CommonContoller {
    private static final Logger logger = LoggerFactory.getLogger(PriceApi.class);
    PriceService priceService;

    @Autowired
    public PriceApi(PriceRepository priceRepository) {
        priceService = new PriceServiceImpl(priceRepository);
    }

    @GetMapping
    public ResponseEntity<PriceResponseDto> getPrice(@RequestParam(
            "date") String date, @RequestParam("productid") Integer productId
            , @RequestParam("idcadena") Integer idCadena) {
        if (logger.isDebugEnabled()) {
            logger.debug("getPrice:: date: {}; productId: {}; idCadena: {}"
                    , date, productId, idCadena);
        }
        Optional<Price> optionalPrice = priceService
                .getPriceByDates(date, productId, idCadena);
        if (optionalPrice.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(PriceResponseDto
                .of(optionalPrice.get()), HttpStatus.OK);
    }
}
