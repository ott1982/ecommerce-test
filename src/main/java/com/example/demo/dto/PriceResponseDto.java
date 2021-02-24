package com.example.demo.dto;

import com.example.demo.entity.Price;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class PriceResponseDto extends CommonDto {

    @JsonProperty("productid")
    private final Integer productId;

    @JsonProperty("idcadena")
    private final Integer idCadena;

    @JsonProperty("startdate")
    private final String startDate;

    @JsonProperty("enddate")
    private final String endDate;

    @JsonProperty("price")
    private final Double price;

    private PriceResponseDto(Integer productId, Integer idCadena
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

    public static PriceResponseDto of(Price price) {
        return new PriceResponseDto(price.getProductId(), price.getBrandId()
                , price.getStartDate(), price.getEndDate(), price.getPrice());
    }
}
