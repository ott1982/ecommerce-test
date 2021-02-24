package com.example.demo.controller;

import com.example.demo.dto.PriceResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price")
public class PriceApi extends CommonContoller {
    private static final Logger logger = LoggerFactory.getLogger(PriceApi.class);

    @GetMapping
    public ResponseEntity<PriceResponseDto> getPrice(String date, String productId
            , String idCadena) {
        if (logger.isDebugEnabled()) {
            logger.debug("getPrice:: date: {}; productId: {}; idCadena: {}"
                    , date, productId, idCadena);
        }
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
}
