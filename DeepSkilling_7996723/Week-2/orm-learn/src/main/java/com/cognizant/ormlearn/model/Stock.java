package com.cognizant.ormlearn.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="stock")
public class Stock {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="st_id")
    private int id;

    @Column(name="st_code")
    private String code;

    @Column(name="st_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name="st_open")
    private double open;

    @Column(name="st_close")
    private double close;

    @Column(name="st_volume")
    private long volume;

    // getters setters
}