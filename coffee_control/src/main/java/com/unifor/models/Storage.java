package com.unifor.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Storage {
    private Integer id;
    private Product product;
    private Integer currentAmount=0;
    private Integer minAmount=0;

}
