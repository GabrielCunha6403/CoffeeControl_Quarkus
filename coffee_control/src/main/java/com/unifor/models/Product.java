package com.unifor.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Integer minUserAmount;
    private Boolean enabled;
    private List<ContributionProduct> contributions;
    private List<SolicitationProduct> solicitations;

}
