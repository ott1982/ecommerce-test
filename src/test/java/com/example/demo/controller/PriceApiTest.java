package com.example.demo.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
class PriceApiTest {

    @Autowired
    PriceApi priceApi;

    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(priceApi).build();

    @ParameterizedTest
    @CsvFileSource(delimiter = ';', resources = "/data.csv", numLinesToSkip = 1)
    public void getPrice(LocalDateTime date, Integer productId
            , Integer brandId, Double expected) throws Exception {
        mockMvc.perform(get("/price"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(Matchers.is(expected)));
    }
}