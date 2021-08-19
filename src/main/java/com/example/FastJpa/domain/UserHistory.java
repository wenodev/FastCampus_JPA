package com.example.FastJpa.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @ManyToOne
    private User user;
}
