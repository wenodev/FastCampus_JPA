package com.example.FastJpa.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;
    private String district;

    @Column(name = "address_detail")
    private String detail;

    private String zipCode;
}
