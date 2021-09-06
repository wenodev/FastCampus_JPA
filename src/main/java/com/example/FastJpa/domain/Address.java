package com.example.FastJpa.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@ToString
@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;
    private String district;

    @Column(name = "address_detail")
    private String detail;

    private String zipCode;
}
