package com.example.demo.controller;

import com.example.demo.repository.PriceRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static java.lang.String.format;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PriceApiTest {

    @Autowired
    PriceRepository priceRepository;

    MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(
                new PriceApi(priceRepository)).build();
    }

    @ParameterizedTest
    @CsvFileSource(delimiter = ';', resources = "/data.csv", numLinesToSkip = 1)
    public void getPrice(LocalDateTime date, Integer productId
            , Integer brandId, Double expected) throws Exception {
        mockMvc.perform(get(format("/price?brandid=%s&productid=%s&date=%s"
                , brandId, productId, date.toString())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(Matchers.is(expected)));
    }
}