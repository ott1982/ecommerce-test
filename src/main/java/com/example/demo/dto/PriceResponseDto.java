package com.example.demo.dto;

import com.example.demo.entity.Price;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class PriceResponseDto extends CommonDto {

    @JsonProperty("productid")
    private final Integer productId;

    @JsonProperty("brandid")
    private final Integer brandId;

    @JsonProperty("startdate")
    private final String startDate;

    @JsonProperty("enddate")
    private final String endDate;

    @JsonProperty("price")
    private final Double price;

    private PriceResponseDto(Integer productId, Integer brandId
            , LocalDateTime startDate, LocalDateTime endDate, Double price) {
        this.productId = productId;
        this.brandId = brandId;
        this.startDate = startDate.toString();
        this.endDate = endDate.toString();
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getBrandId() {
        return brandId;
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
