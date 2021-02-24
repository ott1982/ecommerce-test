package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class PriceResponseDto {

    @JsonProperty("productId")
    private final Integer productId;

    @JsonProperty("idCadena")
    private final Integer idCadena;

    @JsonProperty("startDate")
    private final String startDate;

    @JsonProperty("endDate")
    private final String endDate;

    @JsonProperty("price")
    private final Double price;

    public PriceResponseDto(Integer productId, Integer idCadena
            , LocalDateTime startDate, LocalDateTime endDate, Double price) {
        this.productId = productId;
        this.idCadena = idCadena;
        this.startDate = startDate.toString();
        this.endDate = endDate.toString();
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getIdCadena() {
        return idCadena;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public Double getPrice() {
        return price;
    }
}
