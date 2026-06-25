package com.cognizant.ormlearn.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.ormlearn.model.Stock;

public interface StockRepository extends JpaRepository<Stock,Integer>{

    List<Stock> findByCodeAndDateBetween(
            String code,
            Date start,
            Date end);

    List<Stock> findByCodeAndCloseGreaterThan(
            String code,
            double close);

    List<Stock> findTop3ByOrderByVolumeDesc();

    List<Stock> findTop3ByCodeOrderByCloseAsc(
            String code);
}