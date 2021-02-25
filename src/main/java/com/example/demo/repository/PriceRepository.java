package com.example.demo.repository;

import com.example.demo.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {

    @Query(nativeQuery = true, value = "select p.*" +
            " from PRICE p" +
            " where p.product_id = :productId" +
            " and p.brand_id = :brandId" +
            " and p.start_date <= :localDateTime" +
            " and p.end_date >= :localDateTime" +
            " order by p.priority desc" +
            " limit 1")
    Optional<Price> searchPrice(@Param("localDateTime") String localDateTime
            , @Param("productId") Integer productId
            , @Param("brandId") Integer brandId);
}
