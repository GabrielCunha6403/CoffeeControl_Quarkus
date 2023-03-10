package com.unifor.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Storage {
    private Long id;
    private Product product;
    private Integer currentAmount;
    private Integer minAmount;

}
